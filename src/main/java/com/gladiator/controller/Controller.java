package com.gladiator.controller;

import org.apache.tomcat.jni.Status;
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
import com.gladiator.dto.ApprovalDto;
import com.gladiator.dto.CropTypeDto;
//import com.gladiator.dto.ForgetPasswordDto;
import com.gladiator.dto.LoginDto;
import com.gladiator.dto.Mailuser;
import com.gladiator.entity.Bidder_Details;
import com.gladiator.entity.CropSell;
import com.gladiator.entity.Farmer_Details;
import com.gladiator.entity.LiveBid;
import com.gladiator.entity.OfficialUser;
import com.gladiator.exceptions.FarmerServiceException;
import com.gladiator.repository.Bidder_Repository;
import com.gladiator.repository.Login_Repository;
import com.gladiator.repository.SellReq_Repository;
import com.gladiator.service.Bidder_Service;
import com.gladiator.service.Generic_Service;
import com.gladiator.repository.Generic_Repository;
import com.gladiator.service.Login_Service;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class Controller {

	@Autowired
	private Login_Service service;
	
	@Autowired
	private Login_Repository lrepo;
	
	@Autowired
	private Bidder_Service bservice;
	
	@Autowired
	private Bidder_Repository brepo;
	
	@Autowired
	private SellReq_Repository sellReq;
	
	@Autowired
	private Generic_Service gService;
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private Generic_Repository gRepo;
	
	@GetMapping("/returnOngoingBids")
	public List<LiveBid> returnBids(){
		
		List<LiveBid> BidList = sellReq.findAllBids();
		return BidList;
	
	}
	
	@GetMapping("/finaliseBid/{bidId}")
	public String finaliseBidById(@PathVariable ("bidId") int id, ApprovalDto approveDto)
	{	
		
		gRepo.finalizeBid(id);
		
		return "Bid Finalized";
	}
	
	
	@GetMapping("/GetFarmerHistory/{fEmail}")
	public List<LiveBid> getFarmerHistory(@PathVariable ("fEmail") String fEmail, Mailuser email)
	{	
		
		List<LiveBid> farminghistory=gRepo.getFarmerHistory(fEmail);
		return farminghistory;
	
	}
	
	@GetMapping("/GetBidderHistory/{bEmail}")
	public List<LiveBid> getBidderHistory(@PathVariable ("bEmail") String bEmail, Mailuser email)
	{	
		
		List<LiveBid> biddinghistory=gRepo.getBidderHistory(bEmail);
		return biddinghistory;
	
	}
	
	
	
	@PostMapping("/placebid")
	public Status placeBid(@RequestBody LiveBid livebid) {
		
		if(gRepo.isBidPresent(livebid.getSellId()))
		{
			Status status = new Status();
			gRepo.UpdateBidChecks(livebid);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Current Bid Updated on this bid");
			return status;		
		}
		else {
			Status status = new Status();
			gRepo.AddBid(livebid);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("You're first on this bid");
			return status;	
		}
	}
	
	
	@GetMapping("/farmerslist")
	public List<Farmer_Details> returnFarmerList(){
		List<Farmer_Details> farmerlist= lrepo.findAll();
		return farmerlist;		
	}
	
	@GetMapping("/bidderlist")
	public List<Bidder_Details> returnBidderList(){
		List<Bidder_Details> bidderlist= brepo.findAll();
		return bidderlist;		
	}
	
	
	@GetMapping("/returnSellRequests")
	public List<CropSell> returnSellReq(){
		
		List<CropSell> sellReqList = sellReq.findAll();
		return sellReqList;
	
	}
	
	@GetMapping("/approvesellrequest/{sellId}")
	public String approveSellRequestById(@PathVariable ("sellId") int id, ApprovalDto approveDto)
	{	
		
		gRepo.approveSellRequest(id);
		
		return "Approved";
	}
	
	@GetMapping("/declinesellrequest/{sellId}")
	public String declineSellRequestById(@PathVariable ("sellId") int id, ApprovalDto approveDto)
	{	
		
		gRepo.declineSellRequest(id);
		
		return "Declined";
	}
	
	
	@GetMapping("/WelcomeBidder")
	public List<CropSell> returnApprovedCrops()
	{
		List<CropSell> approvedCropList=sellReq.findNotApproved(); // METHOD NAME IS MISLEADING. ITS APPROVED 
		return  approvedCropList;
	}
	
	@GetMapping("/SellReqHistory/{email}")
	public List<CropSell> returnRequestCrops(@PathVariable ("email") String email, Mailuser sellreq)
	{
		System.out.println("email "+email);
		List<CropSell> allCropList=sellReq.findAll(email);
		return  allCropList;
	
	}
	
	@PostMapping("/SoldReqHistory")
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
	
	@GetMapping("/getCropNames/{croptype}")
	public List<CropSell> returnCropName(@PathVariable ("croptype") String croptype, CropTypeDto croptypedto)
	{
		System.out.println("email "+croptype);
		List<CropSell> allCropList=sellReq.findCropNames(croptype);
		return  allCropList;
	
	}
	
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