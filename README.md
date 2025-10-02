# Image Upload API

This project implements a **Spring Boot REST API** for user registration, authentication, and secure image upload, retrieval, and deletion.  
Initially, the requirement mentioned **Imgur API** for image storage. However, due to issues with the Imgur Developer Portal (client registration is currently broken and does not provide a reliable way to obtain `client_id` and `client_secret`), I switched to **Cloudinary**.

---
- Imgur’s OAuth2 / API client registration is **not functioning** reliably (developer portal redirects to the public website without providing access to application/client creation).  
- This makes it impossible to obtain valid API credentials required for upload and delete operations.  
- Using Imgur would block the completion of the coding challenge due to lack of client credentials.

---
- Cloudinary provides a **stable, well-documented API** for media upload, retrieval, and deletion.  
- It offers a free developer account with API credentials (`cloud_name`, `api_key`, `api_secret`).  
- API Secret will be provided in email

---
- [Upload API Reference](https://cloudinary.com/documentation/image_upload_api_reference)  
---
- Java 17  
- Spring Boot 3.x  
- Spring Security (Basic Auth)  
- Spring Data JPA  
- H2 (in-memory database)  
- Cloudinary SDK (`cloudinary-http44`)  
- Lombok  

---
Run:

mvn clean install
mvn spring-boot:run