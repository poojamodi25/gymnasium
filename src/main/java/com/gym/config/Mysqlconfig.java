
package com.gym.config;


 public class Mysqlconfig{
 private String classname;
 private String url;
 private String username;
 private String password;


         public String getClassname(){
             return this.classname;
         }
         public String getUrl(){
             return this.url;
         }
         public String getUsername(){
             return this.username;
         }
         public String getPassword(){
             return this.password;
         }


         public void setClassname(String classname){
             this.classname=classname;
         }
         public void setUrl(String url){
             this.url=url;
         }
         public void setUsername(String username){
             this.username=username;
         }
         public void setPassword(String password){
             this.password=password;
         }

}