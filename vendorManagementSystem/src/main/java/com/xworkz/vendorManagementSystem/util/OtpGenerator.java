package com.xworkz.vendorManagementSystem.util;

public class OtpGenerator {

	public static String generatorOTP() {
		System.out.println("Generator OTP");
		int generatorOTP = (int) (Math.random() * 900000) + 100000;
		String otp = String.valueOf(generatorOTP);
		System.out.println("6 digit OTP " + otp);
		return otp;
	}

}
