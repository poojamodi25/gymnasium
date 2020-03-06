
package com.gym.config;


 public class SmsConfigOtp{
 private String apikey;
 private String otpMessage;
 private String sender;
 private String server;
 private String otherMessage;


         public String getApikey(){
             return this.apikey;
         }
         public String getOtpMessage(){
             return this.otpMessage;
         }
         public String getSender(){
             return this.sender;
         }
         public String getServer(){
             return this.server;
         }
         public String getOtherMessage(){
             return this.otherMessage;
         }


         public void setApikey(String apikey){
             this.apikey=apikey;
         }
         public void setOtpMessage(String otpMessage){
             this.otpMessage=otpMessage;
         }
         public void setSender(String sender){
             this.sender=sender;
         }
         public void setServer(String server){
             this.server=server;
         }
         public void setOtherMessage(String otherMessage){
             this.otherMessage=otherMessage;
         }

}