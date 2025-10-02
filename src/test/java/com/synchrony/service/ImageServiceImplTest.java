package com.synchrony.service;

import com.synchrony.entities.Images;
import com.synchrony.entities.User;
import com.synchrony.repositories.ImageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ImageServiceImplTest {

    @Mock
    private ImageRepository imageRepository;

    @InjectMocks
    private ImageServiceImpl imageService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setPassword("secret");
    }

    @Test
    void testSaveImage() {
        Images image = new Images();
        image.setId(1L);
        image.setUser(user);
        image.setPublicId("public123");
        image.setUrl("http://cloudinary.com/sample.jpg");

        when(imageRepository.save(any(Images.class))).thenReturn(image);

        Images saved = imageService.saveImage(user, "public123", "http://cloudinary.com/sample.jpg");

        assertNotNull(saved);
        assertEquals("public123", saved.getPublicId());
        assertEquals("http://cloudinary.com/sample.jpg", saved.getUrl());
        assertEquals(user, saved.getUser());

        verify(imageRepository, times(1)).save(any(Images.class));
    }

    @Test
    void testFindById() {
        Images image = new Images();
        image.setId(1L);
        image.setUser(user);
        image.setPublicId("public123");
        image.setUrl("http://cloudinary.com/sample.jpg");

        when(imageRepository.findById(1L)).thenReturn(Optional.of(image));

        Optional<Images> found = imageService.findById(1L);

        assertTrue(found.isPresent());
        assertEquals("public123", found.get().getPublicId());

        verify(imageRepository, times(1)).findById(1L);
    }

    @Test
    void testDelete() {
        Images image = new Images();
        image.setId(1L);

        doNothing().when(imageRepository).delete(image);

        imageService.delete(image);

        verify(imageRepository, times(1)).delete(image);
    }
}
