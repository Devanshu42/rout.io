package com.gladiator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.gladiator.controller.Controller.Status.StatusType;
import com.gladiator.dto.LoginDto;
import com.gladiator.entity.Bidder_Details;
import com.gladiator.entity.CropSell;
import com.gladiator.entity.Farmer_Details;
import com.gladiator.entity.OfficialUser;
import com.gladiator.exceptions.FarmerServiceException;
import com.gladiator.repository.Generic_Repository;
import com.gladiator.repository.SellReq_Repository;
import com.gladiator.service.Bidder_Service;
import com.gladiator.service.Generic_Service;
import com.gladiator.service.Login_Service;

@RestController
@CrossOrigin
public class Controller {

	@Autowired
	private Login_Service service;
	
	@Autowired
	private Bidder_Service bservice;
	
	@Autowired
	private SellReq_Repository sellReq;
	
	@Autowired
	private Generic_Service gService;
	
//	@GetMapping("/SellReqHistory")
//	{
//	
//	}
//	
//	@Autowired
//	private MailSender mailSender;
//	
//	//User user=new User();
//	@CrossOrigin
//	@RequestMapping("/hello")
//	public String hello(@RequestBody User user) {
//		
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom("Devanshu.dwivedi@lntiinfotech.com");
//		message.setTo(user.getEmail());
//		message.setSubject("Welcome ");
//		message.setText("Congratulations you have been successfully registered with Air Fuselage");
//		mailSender.send(message);
//		
//		return "Welcome to Spring REST";
//	}
	
	@PostMapping("/adminlogin")
	public LoginStatus loginAdmin(@RequestBody LoginDto loginDto) {
		try {
			OfficialUser user= gService.login(loginDto.getEmail(),loginDto.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.SUCCESS);
			loginStatus.setMessage("Login Successful");
			loginStatus.setEmail(user.getEmail());

			return loginStatus;
		}
		catch(FarmerServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.FAILURE);
			loginStatus.setMessage(e.getMessage());
			return loginStatus;
		}
		
	}
	
	@PostMapping("/addSellRequest")
	public Status addSellRequest(@RequestBody CropSell cropsell)
	{
		
		try {
			sellReq.save(cropsell);
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Crop Sell Req Added");
			return status;
		}
		catch (FarmerServiceException e) {
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Failed to add Request. Please try again");
			return status;
		}
}
	
	
	@PostMapping("/register")
	public Status registerFarmer(@RequestBody Farmer_Details fdetails)
	{
		try {
			service.register(fdetails);
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successful");
			return status;
		}
		catch (FarmerServiceException e) {
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
}
	@PostMapping("/login")
	public LoginStatus loginfarmer(@RequestBody LoginDto loginDto) {
		try {
			Farmer_Details fdetails = service.login(loginDto.getEmail(),loginDto.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.SUCCESS);
			loginStatus.setMessage("Login Successful");
			loginStatus.setEmail(fdetails.getfEmail());
			loginStatus.setName(fdetails.getfName());
			return loginStatus;
		}
		catch(FarmerServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.FAILURE);
			loginStatus.setMessage(e.getMessage());
			return loginStatus;
		}
		
	}
	
	@PostMapping("/bidderregister")
	public Status registerBidder(@RequestBody Bidder_Details bdetails)
	{
		try {
			bservice.register(bdetails);
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successful");
			return status;
		}
		catch (FarmerServiceException e) {
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
}
	
	@PostMapping("/bidderlogin")
	public LoginStatus loginBidder(@RequestBody LoginDto loginDtobid) {
		try {
			Bidder_Details bdetails = bservice.login(loginDtobid.getEmail(),loginDtobid.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.SUCCESS);
			loginStatus.setMessage("Login Successful");
			loginStatus.setEmail(bdetails.getbEmail());
			loginStatus.setName(bdetails.getbName());
			return loginStatus;
		}
		catch(FarmerServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.FAILURE);
			loginStatus.setMessage(e.getMessage());
			return loginStatus;
		}
		
	}
	

public static class LoginStatus extends Status {
	private String Email;
	private String name;
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}


public static class Status {

private StatusType status;
private String message;

public static enum StatusType {
	SUCCESS,FAILURE;
}

public StatusType getStatus() {
	return status;
}

public void setStatus(StatusType status) {
	this.status = status;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

}
}