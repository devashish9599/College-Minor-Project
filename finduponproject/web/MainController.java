package com.finduponproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finduponproject.model.User;
import com.finduponproject.repository.UserRepository;

@Controller
public class MainController {
	
	
	
	@GetMapping("/")
	    public String root() {
		
	        return "index";
	    }

	    @GetMapping("/login")
	    public String login(Model model) {
	        return "login";
	    }

	   @GetMapping("/user")
	    public String userIndex()
	    {
		   
	        return "user/index";
	    }
	    
	  @GetMapping("/upload1")
	  public String up1(){
		  return "upload1";
	  }


}
