package com.cg.apps2.demoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps2.demoapp.dto.UserDataDTO;
import com.cg.apps2.demoapp.exception.UserNotFoundException;
import com.cg.apps2.demoapp.model.UserData;
import com.cg.apps2.demoapp.repository.UserDataRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDataService implements IUserDataService{
	
	@Autowired
	private UserDataRepository udRepo;
	
	@Override
	public List<UserData> getUserLoginData(){
		log.debug("Getting all user data from SERVICE LAYER");
		return udRepo.findAll();
	}
	
	@Override
	public UserData getUserDataById(Long userId) {
		log.debug("Getting user data by id: {} from SERVICE LAYER",userId);
		return udRepo.findById(userId).orElseThrow(()->new UserNotFoundException("User with id:"+userId+" not found"));
	}
	
	@Override
	public UserData saveData(UserDataDTO userDataDTO) {
		log.debug("User Data saved in database in SERVICE LAYER");
		UserData userData=new UserData(userDataDTO);
		return userData;
	}

}
