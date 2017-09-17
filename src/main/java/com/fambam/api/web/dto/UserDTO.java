package com.fambam.api.web.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fambam.api.model.Gender;
import com.fambam.api.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 69720055006193511L;
	private String firstName;
	private String lastName;
	private String middleName;
	private String userName;
	private String mobileNumber;
	private Gender gender;
	
	public static UserDTO build(User user){
		UserDTO dto = new UserDTO();
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setMiddleName(user.getMiddleName());
		dto.setUserName(user.getUserName());
		dto.setMobileNumber(user.getMobileNumber());
		dto.setGender(user.getGender());
		return dto;
	}
	
	public static List<UserDTO> build(List<User> users){
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		users.forEach(user->{
			userDTOList.add(build(user));
		});
		return userDTOList;
	}
	

}

