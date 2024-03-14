package com.xworkz.vendorManagementSystem.repository;

import java.util.List;

import com.xworkz.vendorManagementSystem.entity.VendorEntity;

public interface VendorRepository {

	public boolean save(VendorEntity entity);
	
	public VendorEntity isExistByNameOrEmailOrWebsite(String name,String email,String website);
	
    public List<VendorEntity> findAllByAjax();
    
    public VendorEntity isExistByEmailOtp(String email,String otp);
    
    public void updateOtpByEmail(String email,String otp);
}
