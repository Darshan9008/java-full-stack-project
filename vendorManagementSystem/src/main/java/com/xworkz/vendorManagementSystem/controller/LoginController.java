package com.xworkz.vendorManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vendorManagementSystem.repository.VendorRepository;
import com.xworkz.vendorManagementSystem.service.VendorService;

@Component
@RequestMapping("/")
public class LoginController {
	
		@Autowired
		private VendorService service;

		@Autowired
		private VendorRepository repo;

		public LoginController() {
			System.out.println("created LoginController");
		}

		@RequestMapping("/singIn")
		public String loginUsingEmailAndOtp( Model model) {
			
			System.out.println("loginUsingEmailAndOtp");
			return "logIn";

		}

	}
	
	


