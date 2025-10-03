package com.synchrony.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {
	@JsonProperty("id")
    private Long id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("public_id")
    private String publicId;
}