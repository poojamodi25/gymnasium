
package com.gym.Bean;


 public class LoginResponceBean{
 private int status;
 private String msg;
 private String data;


         public int getStatus(){
             return this.status;
         }
         public String getMsg(){
             return this.msg;
         }
         public String getData(){
             return this.data;
         }


         public void setStatus(int status){
             this.status=status;
         }
         public void setMsg(String msg){
             this.msg=msg;
         }
         public void setData(String data){
             this.data=data;
         }

}