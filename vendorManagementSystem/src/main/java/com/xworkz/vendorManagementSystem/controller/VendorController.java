package com.xworkz.vendorManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vendorManagementSystem.entity.VendorEntity;
import com.xworkz.vendorManagementSystem.service.VendorService;

@Controller
@RequestMapping("/")
public class VendorController {

	@Autowired
	private VendorService service;

	public VendorController() {
		// TODO Auto-generated constructor stub
		System.out.println("created vendor controller");
	}

	@PostMapping("/virat")
	public String save(@Valid VendorEntity entity, BindingResult error, Model model) {

		System.out.println("invoking save in controller");
		System.out.println("is vendor entity is valid " + error.hasErrors());

		model.addAttribute("entity", entity);
		if (error.hasErrors()) {

			List<ObjectError> objectErrors = error.getAllErrors();
			objectErrors.forEach(e -> System.out.println(e.getObjectName() + ":message" + e.getDefaultMessage()));
			model.addAttribute("error", objectErrors);

			return "Register.jsp";
		} else {
			String validate = service.isExistByNameOrEmailOrWebsiteInService(entity.getName(), entity.getEmail(),
					entity.getWebsite());
			if (validate != null) {
				model.addAttribute("isExistError", validate);
				System.out.println(validate);
				return "Register.jsp";
			} else {
				this.service.validateAndSave(entity);
				this.service.sendMail(entity.getEmail());				
				return "RegisterSuccess.jsp";

			}

		}

	}

}
