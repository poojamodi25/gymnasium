
package com.gym.Bean;


 public class OtpRequest{
 private String otp;
 private String mobileNo;
 private String appId;


         public String getOtp(){
             return this.otp;
         }
         public String getMobileNo(){
             return this.mobileNo;
         }
         public String getAppId(){
             return this.appId;
         }


         public void setOtp(String otp){
             this.otp=otp;
         }
         public void setMobileNo(String mobileNo){
             this.mobileNo=mobileNo;
         }
         public void setAppId(String appId){
             this.appId=appId;
         }

}