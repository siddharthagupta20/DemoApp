package com.cg.apps2.demoapp.service;

import java.util.List;

import com.cg.apps2.demoapp.dto.UserDataDTO;
import com.cg.apps2.demoapp.model.UserData;

public interface IUserDataService {
	
	List<UserData> getUserLoginData();
	
	UserData getUserDataById(Long id);
	
	UserData saveData(UserDataDTO userDataDTO);

}
