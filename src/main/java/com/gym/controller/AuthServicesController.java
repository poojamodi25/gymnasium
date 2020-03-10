package com.gym.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gym.Bean.LoginRequestBean;
import com.gym.Bean.LoginResponceBean;
import com.gym.Bean.OtpRequest;
import com.gym.Bean.OtpResponse;
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
	     Pageable pageable = PageRequest.of(0, 1);
	     List<LoginDetail> logins= loginRepo.getOtpWithinFiveMints(login.getMobileNo(), login.getAppId(), pageable);
	     String otp="";
		 if(logins.size()==1){
		    otp=logins.get(0).getOtp();
		 }
		 else {
				Random random = new Random();
				otp = String.format("%05d", random.nextInt(100000)); 
				LoginDetail detail = new LoginDetail(); 
				detail.setAppId(login.getAppId());
				detail.setMobileNumber(login.getMobileNo());
				Date d=new Date();
				//d.setMinutes(d.getMinutes()+330);
				detail.setOtpIssueDate(d);
				detail.setOtp(otp);
				detail.setStatus(false);
				loginRepo.save(detail);

		 }
		LoginResponceBean res=new LoginResponceBean();

		System.out.println(otp);
		boolean flag = SmsUtility.sendSms(login.getMobileNo(), otp);
		if(flag)
		{
			res.setStatus(1);
			res.setMsg("Otp send successful!!");			
		}
		else {
			res.setStatus(0);
			res.setMsg("Otp send failed!!");
		}
		      
	     return res; 
	  }
	
	
	  @RequestMapping(value="/submitOtp",method=RequestMethod.POST) 
	  public OtpResponse submit(@RequestBody OtpRequest otp) {
		     Pageable pageable = PageRequest.of(0, 1);
		     List<LoginDetail> logins= loginRepo.getOtpWithinFiveMints(otp.getMobileNo(), otp.getAppId(), pageable);
		     LoginDetail ld=null;
		     
		  OtpResponse res=new OtpResponse();
		  if(logins.size()==1)
		  {
			  ld=logins.get(0);
		  }
		  if(ld!=null && ld.getOtp().equals(otp.getOtp())) {
			res.setStatus(1);
			res.setMsg("otp verification sucess");
			res.setTokenId("1234567878");
			ld.setOtpSubmitDate(new Date());
			ld.setStatus(true);
		    loginRepo.save(ld);
		  }
		  else
		  {
				res.setStatus(0);
				res.setMsg("otp verification failed");
				//res.setTokenId("");
		  }
		  return res; 
		  }
	 
	
}
