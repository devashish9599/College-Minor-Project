package com.finduponproject.web;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finduponproject.model.Product;
import com.finduponproject.repository.ProductRepository;

@Controller
@RequestMapping(path = { "/order", "/order/{id}" })
public class ProductController {

	@Autowired
	ProductRepository productR;

	/*
	 * @Autowired(required = true) Product product;
	 */

	@GetMapping
	public String particularProduct(@PathVariable("id") Long id, Model model) throws UnsupportedEncodingException {
		final Optional<Product> product = productR.findById(id);

		byte[] orgImg = product.get().getPic();
		Product particularProduct = new Product(product.get().getName(), product.get().getPrice(),
				product.get().getType().toUpperCase(), orgImg, product.get().getDescription());

		byte[] encodeBase64 = Base64.encodeBase64(orgImg);
		String base64String = new String(encodeBase64, "utf-8");

		particularProduct.setBase64Encoded(base64String);
		model.addAttribute("particularproduct", particularProduct);
		model.addAttribute("productid", id);
		return "order";
	}

}
