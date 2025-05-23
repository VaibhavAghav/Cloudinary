package com.scm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scm.model.DbUser;
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

		return "redirect:/all";
	}

	@GetMapping("/all")
	public String allData(Model model) {
		List<DbUser> alluser = homeService.getAllData();
		model.addAttribute("users", alluser);
		return "viewall";
	}

	@GetMapping("/get/{id}")
	@ResponseBody
	public DbUser getUSerById(@PathVariable int id) {
		System.out.println("USer in getUserById " + id);
		DbUser user = homeService.getUserById(id);
		System.out.println("user information " + user);
		return user;
	}

	@GetMapping("/edit/{id}")
	public String updateUser(@PathVariable int id, Model model) {
		System.out.println("USer in getUserById " + id);
		DbUser user = homeService.getUserById(id);
		System.out.println("user information " + user);
		model.addAttribute("user", user);
		return "update";
	}

	@PostMapping("/update")
	public String updateData(@ModelAttribute User user, @RequestParam("existingPublicId") String existingPublicId,
			@RequestParam("existingSecureUrl") String existingSecureUrl) throws IOException {

		System.out.println("UpdateUser Controller");

		boolean save = homeService.updateUser(user, existingPublicId, existingSecureUrl);
		System.out.println("saving user result: " + save);

		return "redirect:/all";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		boolean delete = homeService.deleteUser(id);
		return "redirect:/all";
	}

}
