package com.gym.model.gimnasium;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class LoginDetail {
	
	private long serialNumber;
	private String mobileNumber;
	private String otp;
	private String tokenId;
	private Date otpIssueDate;
	private Date otpSubmitDate;
	private String appId;
	private boolean status;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public Date getOtpIssueDate() {
		return otpIssueDate;
	}
	public void setOtpIssueDate(Date otpIssueDate) {
		this.otpIssueDate = otpIssueDate;
	}
	public Date getOtpSubmitDate() {
		return otpSubmitDate;
	}
	public void setOtpSubmitDate(Date otpSubmitDate) {
		this.otpSubmitDate = otpSubmitDate;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
	

}
