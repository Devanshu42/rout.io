package com.gladiator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.gladiator.controller.Controller.Status.StatusType;
import com.gladiator.dto.ForgetPasswordDto;
import com.gladiator.dto.LoginDto;
import com.gladiator.dto.Mailuser;
import com.gladiator.entity.Bidder_Details;
import com.gladiator.entity.CropSell;
import com.gladiator.entity.Farmer_Details;
import com.gladiator.entity.OfficialUser;
import com.gladiator.exceptions.FarmerServiceException;
import com.gladiator.repository.SellReq_Repository;
import com.gladiator.service.Bidder_Service;
import com.gladiator.service.Generic_Service;
import com.gladiator.service.Login_Service;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class Controller {

	@Autowired
	private Login_Service service;
	
	@Autowired
	private Bidder_Service bservice;
	
	@Autowired
	private SellReq_Repository sellReq;
	
	@Autowired
	private Generic_Service gService;
	
	@Autowired
	private MailSender mailSender;
	
//	@PostMapping("/forgetPassword")
//	public Status forgetPassword(@RequestBody ForgetPasswordDto forgetPassword){
//		try{
//			ForgetPasswordStatus forgetPasswordStatus = new ForgetPasswordStatus();
//		String newPassword= gService.resetPassword(forgetPassword.getId()+forgetPassword.getPassword());
//		forgetPasswordStatus.setPassword(newPassword);
//		forgetPasswordStatus.setStatus(StatusType.SUCCESS);
//		forgetPasswordStatus.setMessage("Password Change Successful")
//		return forgetPasswordStatus;
//		}
//		catch(FarmerServiceException e){
//			Status status = new Status();
//			status.setMessage("Password Change Succesfull");
//			status.setStatus(StatusType.FAILURE);
//			
//			return status;
//		}
//	}
	
	
	@GetMapping("/SellReqHistory/{email}")
	public List<CropSell> returnRequestCrops(@PathVariable ("email") String email, Mailuser sellreq)
	{
		System.out.println("email "+email);
		List<CropSell> allCropList=sellReq.findAll(email);
		return  allCropList;
	
	}
	
	@GetMapping("/SoldReqHistory")
	public List<CropSell> returnApprovedCrops(@RequestBody Mailuser sellreq)
	{
		System.out.println("email "+sellreq.getEmail());
		List<CropSell> approvedCropList=sellReq.findApproved(sellreq.getEmail());
		return  approvedCropList;
	}
	
	@PostMapping("/hello")
	public String hello(@RequestBody Mailuser mail) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("Devanshu.dwivedi@outlook.com");
		message.setTo(mail.getEmail());
		message.setSubject("Welcome to Farmstead! ");
		message.setText("You have succesfully registered with us. Glad to have you!");
		mailSender.send(message);
		
		return "Mail sent";
	}
	
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
	
public static class ForgetPasswordStatus extends Status{
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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