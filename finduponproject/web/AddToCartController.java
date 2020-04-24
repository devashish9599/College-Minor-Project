package com.finduponproject.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.finduponproject.model.Cart;
import com.finduponproject.model.Product;
import com.finduponproject.model.User;

import com.finduponproject.repository.CartRepository;
import com.finduponproject.repository.GcartRepository;
import com.finduponproject.repository.ProductRepository;
import com.finduponproject.repository.UserRepository;

@Controller

public class AddToCartController {

	@Autowired
	UserRepository userR;

	@Autowired
	ProductRepository productR;

	@Autowired
	CartRepository cartR;

	@Autowired
	GcartRepository gcartR;

	@RequestMapping(path = { "/addtocart", "/addtocart/{id}" })
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addToCart(@ModelAttribute("user") @Valid User user, @PathVariable("id") Long id) {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		User user2 = userR.findByEmail(loggedInUser.getName());

		Optional<Product> product = productR.findById(id);

		String productName = product.get().getName();
		String productType = product.get().getType();
		Long productPrice = product.get().getPrice();
		String productPicName = product.get().getPicName();
		Long uid = user2.getId();
		String userId = String.valueOf(uid);

		Cart cart = new Cart(userId, productName, productPrice, productType, productPicName);
		cartR.save(cart);

		return;
	}

	@RequestMapping("/delete")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@ModelAttribute("user") @Valid User user) {
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		User user2 = userR.findByEmail(loggedInUser.getName());
		String uId = String.valueOf(user2.getId());
		List<Cart> cart = gcartR.findByuId(uId);
		for (Cart cart2 : cart) {
			
			if(cart2.getuId().equals(uId)) {
				gcartR.delete(cart2);
			}
		}
		
		
		return;
	}

}
