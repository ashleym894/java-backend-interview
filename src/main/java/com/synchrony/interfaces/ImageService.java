package com.synchrony.interfaces;

import java.util.Optional;

import com.synchrony.entities.Images;
import com.synchrony.entities.User;

public interface ImageService {

	Images saveImage(User user, String publicId, String url);
    Optional<Images> findById(Long id);
    void delete(Images image);

}
