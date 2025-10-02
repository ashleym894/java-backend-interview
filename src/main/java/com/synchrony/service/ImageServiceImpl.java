package com.synchrony.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synchrony.entities.Images;
import com.synchrony.entities.User;
import com.synchrony.interfaces.ImageService;
import com.synchrony.repositories.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

	private static final Logger LOGGER= LoggerFactory.getLogger(ImageServiceImpl.class);

	@Autowired
	ImageRepository imageRepo;

	 @Override
	    public Images saveImage(User user, String publicId, String url) {
	        Images image = new Images();
	        image.setUser(user);
	        image.setPublicId(publicId);
	        image.setUrl(url);
	        return imageRepo.save(image);
	    }

	    @Override
	    public Optional<Images> findById(Long id) {
	        return imageRepo.findById(id);
	    }

	    @Override
	    public void delete(Images image) {
	    	imageRepo.delete(image);
	    }

}
