
package com.gym.Bean;


 public class OtpResponse{
 private int status;
 private String msg;
 private String tokenId;


         public int getStatus(){
             return this.status;
         }
         public String getMsg(){
             return this.msg;
         }
         public String getTokenId(){
             return this.tokenId;
         }


         public void setStatus(int status){
             this.status=status;
         }
         public void setMsg(String msg){
             this.msg=msg;
         }
         public void setTokenId(String tokenId){
             this.tokenId=tokenId;
         }

}