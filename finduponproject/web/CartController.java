package com.finduponproject.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finduponproject.model.Cart;
import com.finduponproject.model.User;
import com.finduponproject.repository.GcartRepository;
import com.finduponproject.repository.UserRepository;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	UserRepository userR;

	@Autowired
	GcartRepository gcartR;

	@GetMapping
	public String getCart(@ModelAttribute("user") @Valid User user, Model model) {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = userR.findByEmail(loggedInUser.getName());
		String address = currentUser.getAddress();
		String email = currentUser.getEmail();
		String contact = currentUser.getNumber();
		String name = currentUser.getName();
		long currentUserId = currentUser.getId();
		String userCartId = String.valueOf(currentUserId);
		List<Cart> cartItems = gcartR.findByuId(userCartId);

		long sum = 0;
		int count = 0;
		for (Cart cart : cartItems) {
			count++;
			sum = sum + cart.getpPrice();
		}

		model.addAttribute("userCart", cartItems);
		model.addAttribute("total", sum);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("number", contact);
		model.addAttribute("address", address);
		model.addAttribute("cartCount", count);
		return "trycart";

	}
}
