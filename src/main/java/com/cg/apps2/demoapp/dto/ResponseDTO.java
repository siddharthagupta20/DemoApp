package com.cg.apps2.demoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
	
	private String message;
	private Object data;

}
