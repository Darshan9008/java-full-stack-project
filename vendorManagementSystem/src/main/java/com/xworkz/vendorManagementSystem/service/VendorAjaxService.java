package com.xworkz.vendorManagementSystem.service;

public interface VendorAjaxService {
	
    public String findByWebsiteAjax(String website);
	
	public String findByGstAjax(String gstNo);
	
	public String findByEmail(String email);
	
	public String findByContactAjax(Long contactNumber);
	
	

}
