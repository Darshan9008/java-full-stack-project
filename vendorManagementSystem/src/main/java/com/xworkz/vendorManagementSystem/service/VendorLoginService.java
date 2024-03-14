package com.xworkz.vendorManagementSystem.service;

public interface VendorLoginService {
	
	public String emailLoginAjax(String email);
	
	public String loginOtpEmail(String email);
	
	public String loginOtpAjax(String otp);
	

}
