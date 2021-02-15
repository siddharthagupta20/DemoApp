package com.cg.apps2.demoapp.model;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;

import com.cg.apps2.demoapp.dto.UserDataDTO;

import lombok.Data;

@Data
@Entity
@Table(name="user_data")
public class UserData implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 4459288523472104823L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private LocalDate dob;
	
	@Column
	private String gender;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String username;
	
	public UserData(UserDataDTO userDataDTO) {
		try {
		BeanUtils.copyProperties(this, userDataDTO);
		}
		catch(IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
	}

	
}
