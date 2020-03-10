package com.gym.repository.gimnasium;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gym.model.gimnasium.LoginDetail;

public interface LoginDetailRepo extends JpaRepository<LoginDetail, Long>{

	
	  @Query("select aa.otp,aa.serialNumber from LoginDetail aa where aa.mobileNumber=? and status=0 and aa.appId=? and timestampdiff(MINUTE,aa.otpIssueDate,now())<=5 order by otpIssueDate desc limit 1; "
	  ) List<LoginDetail> findByMobileNumber(String mobileNumber,String appId);
	 
}
