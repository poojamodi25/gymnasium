package com.gym.config;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ConfigJson {
	public static Configration config;
    public static void loadConfig() {
 	   String config_dir=System.getenv(EnvironmentConfig.gymHome);  
 	   String gpath = config_dir+"\\"+EnvironmentConfig.gymConfig;
  	 Gson gson=new Gson();
  	 try {
  	        System.out.println("JAVA_HOME Value:- "+gpath);
  		 JsonReader reader=new JsonReader(new FileReader(gpath));
  		config=gson.fromJson(reader, Configration.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

}
