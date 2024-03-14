package com.xworkz.vendorManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vendorManagementSystem.entity.VendorEntity;
import com.xworkz.vendorManagementSystem.repository.VendorRepository;
import com.xworkz.vendorManagementSystem.util.EmailSender;
import com.xworkz.vendorManagementSystem.util.OtpGenerator;

@Service
public class VendorLoginServiceImpl implements VendorLoginService {
	
	@Autowired
	private VendorRepository repo;

	@Autowired
	private EmailSender emailSender;
	
	
	@Override
	public String emailLoginAjax(String email) {
		System.out.println("invoking emailLoginAjax in VendorLoginServiceImpl");
		List<VendorEntity> dto = this.repo.findAllByAjax();
		for (VendorEntity dtos : dto) {
			if (dtos.getEmail().equals(email)) {
				System.out.println("Email is Verified");
				return "";
			}
		}

		return "Please register account";
	}

	
	@Override
	public String loginOtpEmail(String email) {
		System.out.println("invoking loginOtpEmailMsg in VendorLoginServiceImpl");
		String otp = OtpGenerator.generatorOTP();
		String text = "Your OTP for Login :" + otp;
		String subject = "One Tome Password";
		String to = email;
		String from = "darshanrr9008@outlook.com";

		boolean emailOTP = this.emailSender.emailSender(to, from, subject, text);
		System.out.println("mail sent " + emailOTP);
		this.repo.updateOtpByEmail(email, otp);
		if (emailOTP) {
			return "OTP Sent successfully";
		}
		return null;
	}

	@Override
	public String loginOtpAjax(String otp) {
		System.out.println("invoking loginOtpAjax in VendorLoginServiceImpl");
		List<VendorEntity> dto = this.repo.findAllByAjax();
		for (VendorEntity dtos : dto) {
			if (dtos.getOtp().equals(otp)) {
				System.out.println("Checking for OTP:" + otp);
				return "OTP Matched";
			} else {
				return "OTP Not Matched";
			}

		}
		return null;
	}
}

	


