
package com.gym.config;


 public class Configration{
 private Mysqlconfig mysqlconfig;
 private SmsConfigOtp smsConfigOtp;

         public Mysqlconfig getMysqlconfig(){
             return this.mysqlconfig;
         }


         public void setMysqlconfig(Mysqlconfig mysqlconfig){
             this.mysqlconfig=mysqlconfig;
         }


		public SmsConfigOtp getSmsConfigOtp() {
			return smsConfigOtp;
		}


		public void setSmsConfigOtp(SmsConfigOtp smsConfigOtp) {
			this.smsConfigOtp = smsConfigOtp;
		}
         
         

}