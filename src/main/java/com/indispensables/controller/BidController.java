package com.indispensables.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.indispensables.service.BidService;
import com.indispensables.vo.RFPVo;
import com.indispensables.vo.BidSubmission.BidVo;

@CrossOrigin("*")
@RestController
public class BidController {
	
	@Autowired
	BidService bidService;
	
	@PostMapping("fillbid")
	ResponseEntity<String> saveBid(@RequestBody  BidVo bidVo)
	{
		
		bidService.saveBid(bidVo);	
		
		return ResponseEntity.ok("Bid Data Saved Successfully");
	}
	
	@GetMapping("fillbid")
	String sayHi() {
		return "Hi Vendor's Leader use id to get Your Bid List";
	}
	
	@GetMapping("/fillbid/{id}")
	ResponseEntity<List<BidVo>> findAll(@PathVariable int id)
	{
		return ResponseEntity.ok(bidService.getAllBid(id));
	}
}
