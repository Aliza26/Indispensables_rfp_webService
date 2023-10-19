package com.indispensables.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.indispensables.service.BidService;
import com.indispensables.service.RFPService;
import com.indispensables.vo.Document;
import com.indispensables.vo.RFPVo;
import com.indispensables.vo.Vendor;
import com.indispensables.vo.BidSubmission.BidVo;

@CrossOrigin("*")
@RestController
public class RFPcontroller {
	
	@Autowired
	RFPService rfpService;
	
	@Autowired
	BidService bidService;
	
	@PostMapping("/fillrfp")
	ResponseEntity<String> saveRfp(@RequestBody  RFPVo rfpVo)
	{
		
		rfpService.save(rfpVo);	
		
		return ResponseEntity.ok("Data Saved Successfully");
	
	}
	
	@GetMapping("/rfplist/{id}")
	ResponseEntity<List<RFPVo>> findAll(@PathVariable int id)
	{
	 
		return ResponseEntity.ok(rfpService.getAllRFP(id));
	}
	
	@GetMapping("/rfp1/{id}")
	ResponseEntity<RFPVo> findOnEntity(@PathVariable int id)
	{
	 
		return ResponseEntity.ok(rfpService.getRFPById(id));
	}
	
	@GetMapping("/rfpvendorlist/{id}")
	ResponseEntity<List<Vendor>> findAllVendor(@PathVariable int id)
	{
	 
		return ResponseEntity.ok(rfpService.getAllVendor(id));
	}
	

	@GetMapping("/rfp/{id}")
	ResponseEntity<RFPVo> findRFP(@PathVariable int id)
	{
	 
		return ResponseEntity.ok(rfpService.findRFPById(id));
	}
	
	@GetMapping("/vendorlist")
	ResponseEntity<List<Vendor>> findAllVendorList()
	{
	    System.out.println("hello1");
		return ResponseEntity.ok(rfpService.getAllActiveVendor());
	}
	
	@GetMapping("/doclist")
	ResponseEntity<List<Document>> findAllDocumentList()
	{
	 
		return ResponseEntity.ok(rfpService.getAllDocument());
	}
	
	@GetMapping("/allrfplist")
	ResponseEntity<List<RFPVo>> findAllRFPList()
	{
	 
		return ResponseEntity.ok(rfpService.getAllRFPList());
	}
	
	
	
	@PostMapping("/fillbid")
	ResponseEntity<String> saveBid(@RequestBody  BidVo bidVo)
	{
	    System.out.println("Hello");
		bidService.saveBid(bidVo);	
		
		return ResponseEntity.ok("Bid Data Saved Successfully");
	}
	
	
	@GetMapping("/fillbid/{id}")
	ResponseEntity<List<BidVo>> findAllBids(@PathVariable int id)
	{
		return ResponseEntity.ok(bidService.getAllBid(id));
	}


}
