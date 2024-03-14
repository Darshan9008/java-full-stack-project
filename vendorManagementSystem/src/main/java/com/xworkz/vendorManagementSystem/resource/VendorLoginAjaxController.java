package com.xworkz.vendorManagementSystem.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.vendorManagementSystem.service.VendorLoginService;

@RestController
@RequestMapping("/")
@EnableWebMvc
public class VendorLoginAjaxController {
	@Autowired
	private VendorLoginService loginService;

	public VendorLoginAjaxController() {
		System.out.println("invoking in VendorLoginAjaxController");
	}

	@GetMapping(value = "/loginEmailAjax/{email}")
	public String loginEmailAjax(@PathVariable String email) {
		System.out.println("Checking for email:" + email);
		System.out.println("loginEmailAjax....");
		return this.loginService.emailLoginAjax(email);
	}

	@GetMapping(value = "/loginOtpEmailMsg/{email}")
	public String loginOtpMsg(@PathVariable String email) {
		System.out.println("Checking for loginOtpMsg...");
		System.out.println("Login Details send succesfully...");
		return this.loginService.loginOtpEmail(email);
	}

	@GetMapping(value = "/loginOtpAjax/{otp}")
	public String loginOtpAjax(@PathVariable String otp) {
		System.out.println("Checking for otp:" + otp);
		System.out.println("loginOtpAjax....");
		return this.loginService.loginOtpAjax(otp);
	}

}


