package com.gym.repository.gimnasium;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gym.Bean.OtpRequest;
import com.gym.model.gimnasium.LoginDetail;

public interface LoginDetailRepo extends JpaRepository<LoginDetail, Long>{

	/*
	 * @Query("select * from LoginDetail c where c.mobileNumber=? and c.appId=? and status=0 and "
	 * ) List<OtpRequest> findByMobileNumber(String mobileNumber);
	 */
}
