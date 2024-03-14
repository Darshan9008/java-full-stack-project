package com.xworkz.vendorManagementSystem.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.sun.istack.NotNull;

import lombok.CustomLog;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Setter
@Getter
@Entity
@Table(name="registration")
@NamedQuery(name="IsExistByNameOrGstNoOrWebsite",query="select ve from VendorEntity ve where ve.name=:name or ve.email=:email or ve.website=:website")
@NamedQuery(name="FindAll",query="select ve from VendorEntity ve")
@NamedQuery(name="updatedOtpByEmail",query="select et from VendorEntity et where et.email=:email")
@NamedQuery(name="isExistByEmailOtp" ,query="select et from VendorEntity as et where et.email=:email or et.otp=:otp")

public class VendorEntity {
	
	public VendorEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@Column(name="r_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min=3,max=20,message="name should be length between 3 and 20")
	@Column(name="r_name")
	private String name;
	
	@NotNull
	@Size(min=3,max=20,message="location should be length between 3 and 20")
	@Column(name="r_location")
	private String location;
	
	@NotNull
	@Range(message="gst no should be length between 6 and 10 ")
	@Column(name="r_gst_no")
	private String gstNo;
	
	@NotNull
	@Column(name="r_start_date")
	private String date; 
	 
	@NotNull
	@Size(min=3,max=20,message="owner name should be between 3 and 20")
	@Column(name="r_owner_name")
	private String ownerName;
	
	@NotNull
	@Size(min=3,max=20,message="service type should be between 3 and 20")
	@Column(name="r_service_type")
	private String serviceType; 
	
	@NotNull
	@Column(name="r_contact_number")
	private Long contactNumber;
	
	@NotNull
	@Column(name="r_alternate_number")
	private Long alternateNumber;
	
	@NotNull
	@Email
	@Column(name="r_email")
	private String email;
	
	@Email
	@Column(name="v_email_id1")
	private String email1;
	
	@Column(name="v_otpGenerator")
	private String otpGenerator;
	
	@Column(name="v_otp")
	private String otp;
	
	@NotNull
	@Size(min=3,max=40,message="owner name should be between 3 and 20")
	@Column(name="r_website")
	private String website;
	
	@NotNull
	@Column(name="r_created_by")
	private LocalDate createdBy;
	
	@NotNull
	@Column(name="r_created_date")
	private LocalDate createdDate;
	
	@NotNull
	@Column(name="r_updated_by")
	private LocalDate updatedBy;
	
	
	@NotNull
	@Column(name="r_updated_date")
	private LocalDate updatedDate;
	
	
	
	

	
	
}
