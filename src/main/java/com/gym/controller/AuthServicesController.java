package com.gym.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gym.Bean.LoginRequestBean;
import com.gym.Bean.LoginResponceBean;
import com.gym.Bean.OtpRequest;
import com.gym.model.gimnasium.LoginDetail;
import com.gym.repository.gimnasium.LoginDetailRepo;
import com.gym.utlis.SmsUtility;

@RestController
public class AuthServicesController {
@Autowired
LoginDetailRepo loginRepo ;
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/RequestOtp",method=RequestMethod.POST) 
    public LoginResponceBean loginPage(@RequestBody LoginRequestBean login) 
	  {
		LoginResponceBean res=new LoginResponceBean();
		Random random = new Random();
		String value = String.format("%05d", random.nextInt(100000));
		System.out.println(value);
		boolean flag = SmsUtility.sendSms(login.getMobileNo(), value);
		if(flag)
		{
			LoginDetail detail = new LoginDetail(); 
			detail.setAppId(login.getAppId());
			detail.setMobileNumber(login.getMobileNo());
			Date d=new Date();
			//d.setMinutes(d.getMinutes()+330);
			detail.setOtpIssueDate(d);
			detail.setOtp(value);
			detail.setStatus(false);
			res.setStatus(1);
			res.setMsg("Otp send successful!!");
			loginRepo.save(detail);
			
		}
		else {
			res.setStatus(0);
			res.setMsg("Otp send failed!!");
		}
		      
	     return res; 
	  }
	
	
	  @RequestMapping(value="/submitOtp",method=RequestMethod.POST) 
	  public String submit(@RequestBody OtpRequest otp) {
		  List<LoginDetail> ld= loginRepo.findByMobileNumber(otp.getMobileNo(), otp.getAppId());
		 // OtpResponce res=new OtpResponce();
		  if(ld.size()==1)
		  {}
		  else
		  {}
				  return ""; 
		  }
	 
	
}
