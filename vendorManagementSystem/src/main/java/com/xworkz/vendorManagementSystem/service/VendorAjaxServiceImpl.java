package com.xworkz.vendorManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vendorManagementSystem.entity.VendorEntity;
import com.xworkz.vendorManagementSystem.repository.VendorRepository;

@Service
public class VendorAjaxServiceImpl implements VendorAjaxService {

	@Autowired
	private VendorRepository repository;

	@Override
	public String findByWebsiteAjax(String website) {

		List<VendorEntity> list = this.repository.findAllByAjax();
		if(list!=null) {
		for (VendorEntity vendorEntity : list) {
			System.out.println(vendorEntity.getWebsite() + " " + website);

			if (vendorEntity.getWebsite().equals(website)) {
				System.out.println(("equals."));
				return "website exist";

			} else {
				System.out.println("website not exist");
			}
		}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findByGstAjax(String gstNo) {
		// TODO Auto-generated method stub
		List<VendorEntity> list1 = this.repository.findAllByAjax();
		if(list1!=null) {
		for (VendorEntity vendorEntity : list1) {
			System.out.println(vendorEntity.getGstNo() + " " + gstNo);

			if (vendorEntity.getGstNo().equals(gstNo)) {

				System.out.println("equals.");
				return "gst no exist";
			} else {
				System.out.println("gstNo does not exist");
			}

		}
		}
		return null;

	}

	@Override
	public String findByEmail(String email) {
		// TODO Auto-generated method stub
		List<VendorEntity> list2=this.repository.findAllByAjax();
		if(list2!=null) {
		for(VendorEntity vendorEntity :list2) {
			System.out.println(vendorEntity.getEmail()+" "+email);
			if(vendorEntity.getEmail().equals(email)) {
				System.out.println("equals.");
				return "email exist";
				
			}
			else {
				System.out.println("email does not exist");
			}
		}
		}
		return null;
	}

	@Override
	public String findByContactAjax(Long contactNumber) {
		// TODO Auto-generated method stub
		List<VendorEntity> list3=this.repository.findAllByAjax();
		if(list3!=null) {
		
		for(VendorEntity vendorEntity:list3) {
			
			System.out.println(vendorEntity.getContactNumber()+" "+contactNumber);
			if(vendorEntity.getContactNumber().equals(contactNumber)) {
				System.out.println("equals.");
				return "contact number exist";
				}
			else {
				System.out.println("contact number does not exist");
			}
		}
		}
		return null;
	}
	

}
