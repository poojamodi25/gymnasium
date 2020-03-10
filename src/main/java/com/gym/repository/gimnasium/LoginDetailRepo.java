package com.gym.repository.gimnasium;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gym.model.gimnasium.LoginDetail;

public interface LoginDetailRepo extends JpaRepository<LoginDetail, Long>{

	
	  @Query("select aa from LoginDetail aa where aa.mobileNumber=?1 and aa.status=0 and aa.appId=?2 and timestampdiff(MINUTE,aa.otpIssueDate,now())<=5 order by otpIssueDate desc")
	  List<LoginDetail> getOtpWithinFiveMints(String mobileNumber,String appId,Pageable pageable);
	    
}
