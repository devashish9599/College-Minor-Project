package com.finduponproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finduponproject.model.Product;
import com.finduponproject.repository.ProductRepository;
import com.finduponproject.service.ProductService;

@Controller

public class ProductListingController {

	@Autowired
	ProductService productService;

	@RequestMapping("/keyboards")
	public String KeyboardList(Model model) {
		List<Product> allKeyBoards = productService.findByType("keyboard");
		model.addAttribute("keyboardlist", allKeyBoards);
		return "keyboards";
	}

	@RequestMapping("/mouse")
	public String allMouse(Model model) {
		List<Product> allMouse = productService.findByType("mouse");
		model.addAttribute("mouselist", allMouse);
		return "mouse";

	}

	@RequestMapping("/headphones")
	public String allheadphones(Model model) {
		List<Product> allheadphones = productService.findByType("headphone");
		model.addAttribute("phonelist", allheadphones);
		return "headphones";

	}

	@RequestMapping("/ram")
	public String allRam(Model model) {
		List<Product> allRam = productService.findByType("ram");
		model.addAttribute("ramlist", allRam);
		return "ram";

	}

	@RequestMapping("/ssd")
	public String allSsd(Model model) {
		List<Product> allSsd = productService.findByType("ssd");
		model.addAttribute("ssdlist", allSsd);
		return "ssd";

	}

	@RequestMapping("/routers")
	public String allRouters(Model model) {
		List<Product> allRouters = productService.findByType("router");
		model.addAttribute("routerlist", allRouters);
		return "routers";

	}
	
	@RequestMapping("/modems")
	public String allModems(Model model) {
		List<Product> allModems = productService.findByType("modem");
		model.addAttribute("modemlist", allModems);
		return "modems";

	}


}
