package com.xworkz.vendorManagementSystem.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vendorManagementSystem.entity.VendorEntity;
import com.xworkz.vendorManagementSystem.repository.VendorRepository;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	private VendorRepository repo;
	
	public VendorServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("invoking VendorServiceImpl ");
	}

	@Override
	public boolean validateAndSave(VendorEntity entity) {
		// TODO Auto-generated method stub
		System.out.println("invoking validate and save");
		System.out.println("entity is"+entity);
		this.repo.save(entity);
		return true;
		
	}

	@Override
	public String isExistByNameOrEmailOrWebsiteInService(String name, String email, String website) {
		// TODO Auto-generated method stub
	VendorEntity entity=repo.isExistByNameOrEmailOrWebsite(name, email, website);
		if(entity!=null)
		{
			if(entity.getName().equals(name)) {
			  	return "name already exist";
			}
			else if(entity.getEmail().equals(email)) {
				return "email already exist";
			}
			else if(entity.getWebsite().equals(website)) {
				return "website already exist";
				
			}
			
			
		}
		else {
			return null;
		}
		return null;

	}

	@Override
	public boolean sendMail(String email) {
		// TODO Auto-generated method stub
		

			
			int portNumber = 587;
			String hostName = "smtp.office365.com";
			String fromEmail = "darshanrr9008@outlook.com";
			String password = "9008@Darshan";
			String to = email;

			Properties prop = new Properties();
		
			prop.put("mail.smtp.host", hostName);
			prop.put("mail.smtp.port", portNumber);
			prop.put("mail.smtp.starttls.enable", true);
			prop.put("mail.debug", true);
			prop.put("mail.smtp.auth", true);
			prop.put("mail.transport.protocol", "smtp");

			Session session = Session.getInstance(prop, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			});

			MimeMessage message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress(fromEmail));
				message.setSubject("registration ");
				message.setText("thank you for registration");

				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				Transport.send(message);
				
				return true;

			}

			catch (MessagingException e) {
				e.printStackTrace();
			}
			

			return false;
		}
		
	@Override
	public String isExist(String email, String otp) {

		VendorEntity entity=repo.isExistByEmailOtp(email, otp);
		if(entity !=null) {
			if(entity.getEmail().equals(email)) {
				return "email already exist";
				
			}
			else if(entity.getOtp().equals(otp)) {
				return "otp already exist";
			}
		}
		
		
		
		return null;
	}
	
	

}
