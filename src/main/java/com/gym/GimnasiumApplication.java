package com.gym;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gym.config.ConfigJson;
import com.gym.model.gimnasium.UserDetails;
import com.gym.repository.gimnasium.UserDetailsRepo;

@SpringBootApplication
@RestController
public class GimnasiumApplication {
	@Autowired
     private UserDetailsRepo userDetail;
	@RequestMapping(value = "/pooja",method=RequestMethod.GET) 
    public String hello() 
	  {
		UserDetails b=new UserDetails();
		  b.setName("user1");
		  userDetail.save(b);
	     return "success"; 
	  }
		
	@GetMapping("/getUsers")
	public List<UserDetails> getBooks() {
		return userDetail.findAll();
	}
	public static void main(String[] args) {
		ConfigJson.loadConfig();
		System.out.println("classname: "+ConfigJson.config.getMysqlconfig().getClassname());
		SpringApplication.run(GimnasiumApplication.class, args);
	}

}
