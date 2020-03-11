package com.gym.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RestController
public class MiddleWareController extends OncePerRequestFilter{
	
	 @Override
	 @RequestMapping(value="Auth/*",method=RequestMethod.POST)
     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         // your code
		 String appId=request.getHeader("appId");
		 String mobileNo=request.getHeader("mobileNumber");
         System.out.println("Authorize ="+mobileNo+" "+appId);
		 System.out.println("Authorize user");
         filterChain.doFilter(request, response);
     }

}
