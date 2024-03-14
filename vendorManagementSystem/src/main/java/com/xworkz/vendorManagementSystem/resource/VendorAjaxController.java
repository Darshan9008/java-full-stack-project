package com.xworkz.vendorManagementSystem.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.vendorManagementSystem.service.VendorAjaxService;

@RestController
@RequestMapping("/")
public class VendorAjaxController {
	
	@Autowired
	private VendorAjaxService ajaxService;

	public VendorAjaxController() {
		// TODO Auto-generated constructor stub
		System.out.println("running ajax controller");
	}
	
	@GetMapping(value="/uniqueEmail/{email:.+}")
	public String onEmail(@PathVariable String email) {
	String ajaxEmail=ajaxService.findByEmail(email);
	System.out.println("email already exist"+ajaxEmail);
	return ajaxEmail;
	}
	
	@GetMapping(value="/uniqueContactNumber/{contactNumber:.+}")
	public String onContactNumber(@PathVariable Long contactNumber) {
		String ajaxContactNumber=ajaxService.findByContactAjax(contactNumber);
		return ajaxContactNumber;
	}
	
	@GetMapping(value="/uniqueGstNo/{gstNo:.+}")
	public String onGstNo(@PathVariable String gstNo) {
		String ajaxGstNo=ajaxService.findByGstAjax(gstNo);
		return ajaxGstNo;
	}
	
	@GetMapping(value="/uniqueWebsite/{website:.+}")
	public String onWebsite(@PathVariable String website) {
		String ajaxWebsite=ajaxService.findByWebsiteAjax(website);
		return ajaxWebsite;
	}
	
}
