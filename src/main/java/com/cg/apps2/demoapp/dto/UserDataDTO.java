package com.cg.apps2.demoapp.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserDataDTO {
	
	private Long id;
	
	@NotEmpty(message="User name cannot be null")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="User Name Invalid")
	private String name;
	
	@JsonFormat(pattern="dd-mm-yyyy")
	@NotNull(message="DOB should not be null")
	@PastOrPresent(message="DOB should be a past or today's date")
	private LocalDate dob;
	
	@Pattern(regexp="M|F|O", message="Gender should be selected")
	private String gender;
	
	@Pattern(regexp="^[a-zA-Z]*([_+-.][a-zA-Z0-9]+){0,1}[@]([.][a-zA-Z]{2,3}){1,2}$")
	private String email;
	
	@Pattern(regexp="^(?=.*\\d)(?.*[A-Z])(?.*\\W)(?!.*\\W\\w*\\W)(?.*\\s).{8,}$")
	private String password;
}
