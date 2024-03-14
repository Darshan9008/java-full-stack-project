package com.xworkz.vendorManagementSystem.service;

import com.xworkz.vendorManagementSystem.entity.VendorEntity;

public interface VendorService {

	public boolean validateAndSave(VendorEntity entity);
	
	public String isExistByNameOrEmailOrWebsiteInService(String name,String email,String website);
	
	public boolean sendMail(String email);
	
	public String isExist(String email,String otp);

}
