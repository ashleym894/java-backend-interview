package com.synchrony.main.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.synchrony.main.entities.*;
import com.synchrony.main.messaging.EventPublisher;
import com.synchrony.main.model.ImageDto;
import com.synchrony.main.repositories.UserRepository;
import com.synchrony.main.service.CloudinaryServiceImpl;
import com.synchrony.main.service.ImageServiceImpl;

@RestController
@RequestMapping("/api/images")
public class ImageController {

	@Autowired
	private CloudinaryServiceImpl cloudinaryService;

	@Autowired
	private ImageServiceImpl imageService;
	
	@Autowired
	private EventPublisher eventPublisher;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/upload")
	public ResponseEntity<ImageDto> upload(@RequestParam("file") MultipartFile file,
	                                       Principal principal) throws IOException {
	    User user = userRepository.findByUsername(principal.getName())
	                              .orElseThrow();

	    Map<String, Object> result = cloudinaryService.uploadFile(file);

	    Images image = imageService.saveImage(
	            user,
	            (String) result.get("public_id"),
	            (String) result.get("secure_url")
	    );
	    eventPublisher.publishImageEvent(user.getUsername(), image.getPublicId());
	    ImageDto dto = new ImageDto(image.getId(), image.getUrl(), image.getPublicId());
	    return ResponseEntity.ok(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id, Principal principal) throws IOException {
	    User user = userRepository.findByUsername(principal.getName())
	                              .orElseThrow();

	    Images image = imageService.findById(id)
	                              .orElseThrow(() -> new RuntimeException("Image not found"));

	    if (!image.getUser().getId().equals(user.getId())) {
	        return ResponseEntity.status(HttpStatus.FORBIDDEN)
	                             .body("You are not authorized to delete this image");
	    }

	    cloudinaryService.deleteFile(image.getPublicId());
	    imageService.delete(image);

	    return ResponseEntity.ok("Image deleted successfully");
	}
}
