package com.cg.apps2.demoapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps2.demoapp.dto.ResponseDTO;
import com.cg.apps2.demoapp.dto.UserDataDTO;
import com.cg.apps2.demoapp.exception.UserNotFoundException;
import com.cg.apps2.demoapp.model.UserData;
import com.cg.apps2.demoapp.service.IUserDataService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/demoapp")
@CrossOrigin(allowedHeaders="*")
@Slf4j
public class UserDataController {
	
	@Autowired
	IUserDataService udService;
	
	@GetMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDTO> getUserLoginData(){
		log.debug("Getting data of all users from controller.");
		List<UserData> userList=null;
		userList=udService.getUserLoginData();
		ResponseDTO respDTO=new ResponseDTO("Get Call Successfull",userList);
		try {
			return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping(value= {"/get/{userId}"})
	public ResponseEntity<ResponseDTO> getUserDataById(@PathVariable("userId") Long userId){
		log.debug("Getting data of all users from controller.");
		UserData userData=null;
		userData=udService.getUserDataById(userId);
		ResponseDTO respDTO=new ResponseDTO("Get call for userId: "+userId+" Successful",userData);
		try {
			return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createUserData(@Valid@RequestBody UserDataDTO userDataDTO){
		log.debug("Creating User Data {}",userDataDTO);
		UserData userData=null;
		userData=udService.saveData(userDataDTO);
		ResponseDTO respDTO=new ResponseDTO("Saving Data Successful",userData);
		try{
			return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.CREATED);
		}catch(UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}