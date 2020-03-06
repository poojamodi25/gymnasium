
package com.gym.Bean;


 public class LoginRequestBean{
 private String mobileNo;
 private String appId;


         public String getMobileNo(){
             return this.mobileNo;
         }
         public String getAppId(){
             return this.appId;
         }


         public void setMobileNo(String mobileNo){
             this.mobileNo=mobileNo;
         }
         public void setAppId(String appId){
             this.appId=appId;
         }

}