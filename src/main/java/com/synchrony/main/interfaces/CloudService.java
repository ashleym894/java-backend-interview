package com.synchrony.main.interfaces;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudService {

	Map<String, Object> uploadFile(MultipartFile file) throws IOException;

    Map<String, Object> deleteFile(String publicId) throws IOException;
	
}
