package com.scm.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scm.model.User;
import com.scm.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService homeService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/register")
	public String registerUser() {
		return "register";
	}

	@PostMapping("/upload")
	public String saveData(@ModelAttribute User model) throws IOException {

		System.out.println("Inside save Data " + model.getName() + " " + model.getPhoto().getOriginalFilename() + " "
				+ model.isIshuman());
		boolean save;
		save = homeService.savedData(model);

		System.out.println("saving user false " + save);

		return "home";
	}

}
