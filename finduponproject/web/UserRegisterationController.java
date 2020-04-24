package com.finduponproject.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finduponproject.model.User;
import com.finduponproject.service.UserService;







@Controller
@RequestMapping("/registration")
public class UserRegisterationController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
    public User userRegistration() {
        return new User();
    }
	
	@GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") @Valid User user,
            BindingResult result){

		User existing = userService.findByEmail(user.getEmail());
		if (existing != null){
			result.rejectValue("email", null, "There is already an account registered with that email");
		}

		if (result.hasErrors()){
			return "registration";
		}

		userService.save(user);
		return "redirect:/registration?success";
		}



}
