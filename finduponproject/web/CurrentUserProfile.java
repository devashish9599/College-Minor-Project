package com.finduponproject.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finduponproject.model.User;
import com.finduponproject.repository.UserRepository;

@Controller
@RequestMapping("/profile")
public class CurrentUserProfile {

	@Autowired
	UserRepository userR;

	@GetMapping
	public String userProfile(@ModelAttribute("user") @Valid User user, Model model)
			throws UnsupportedEncodingException {

		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		// String email = loggedInUser.getName();

		User user2 = userR.findByEmail(loggedInUser.getName());

		String name = user2.getName();
		String email1 = user2.getEmail();
		String address = user2.getAddress();
		String number = user2.getNumber();

			byte[] orgImg = user2.getPic();
			byte[] encode = Base64.encodeBase64(orgImg);
			String base64String = new String(encode, "utf-8");
			user2.setBase64Encoded(base64String);
			model.addAttribute("userName", name);
			model.addAttribute("email", email1);
			model.addAttribute("pic", base64String);
			model.addAttribute("address", address);
			model.addAttribute("number", number);

			return "profile";

		}

	}