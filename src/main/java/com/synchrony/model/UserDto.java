package com.synchrony.model;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class UserDto {


    @NotBlank(message = "Username is required")
    @JsonProperty("username")
	private String username;

	@JsonProperty("passcode")
	private String passcode;

	@JsonProperty("email_address")
	private String email_address;

}
