package com.gym.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gym.Bean.LoginResponseBean;
import com.gym.model.gimnasium.UserDetails;
import com.gym.repository.gimnasium.UserDetailsRepo;

@RestController
public class UserDetailController {
	@Autowired
	UserDetailsRepo UserRepo ;
	@RequestMapping(value="/SaveUserDetail",method=RequestMethod.POST)
	  public LoginResponseBean SaveUserDetail(@RequestBody UserDetails user,@RequestParam String userType,@RequestHeader Map<String, String> headers)
	  {
	    headers.forEach((key, value) -> {
	       System.out.println(String.format("Header '%s' = %s", key, value));
	    });
		LoginResponseBean res=new LoginResponseBean();
		try {
		int usertype=0;
		if(userType.equals("admin")) {
			usertype=1;
		}
		else if(userType.equals("trainer")) {
			usertype=2;
		}
		else if(userType.equals("owner")) {
			usertype=3;
		}
		else if(userType.equals("enduser")) {
			usertype=4;
		}
		user.setUserType(usertype);
		user.setCreateDate(new Date());
		user.setModifiedDate(new Date());
		UserRepo.save(user);
		res.setStatus(1);
		res.setMsg("Data Inserted Successfully");
		}
		catch(Exception ex) {
			res.setStatus(0);
			res.setMsg("Data Inserted Failed");
		}
		return res;
		  
	  }
	
	
}
