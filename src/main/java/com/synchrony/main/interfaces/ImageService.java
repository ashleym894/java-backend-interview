package com.synchrony.main.interfaces;

import java.util.Optional;

import com.synchrony.main.entities.Images;
import com.synchrony.main.entities.User;

public interface ImageService {

	Images saveImage(User user, String publicId, String url);
    Optional<Images> findById(Long id);
    void delete(Images image);

}
