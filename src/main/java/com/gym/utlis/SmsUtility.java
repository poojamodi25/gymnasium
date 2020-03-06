package com.gym.utlis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.gym.config.ConfigJson;

public class SmsUtility {
	
	public static Boolean sendSms(String number,String otpNumber) {
		try {
			// Construct data
			String apiKey = "apikey="+ConfigJson.config.getSmsConfigOtp().getApikey();
			String message = "&message="+ConfigJson.config.getSmsConfigOtp().getOtpMessage()+otpNumber;
			String sender = "&sender="+ConfigJson.config.getSmsConfigOtp().getSender();
			String numbers = "&numbers=" + number;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL(ConfigJson.config.getSmsConfigOtp().getServer()).openConnection();
			String data = apiKey + numbers + message +sender ;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			JsonObject obj = gson.fromJson(stringBuffer.toString(),JsonObject.class);
			 System.out.println("obj.get(\"status\")::::::::::::::"+obj.get("status").toString());
			 obj.get("status");
			 if(obj.get("status").toString().equalsIgnoreCase("success")||obj.get("status").toString().equalsIgnoreCase("\"success\""))
			 {
				 return true;
			 }
			 

			
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			//return "Error "+e;
		}
		return false;
	}

}
