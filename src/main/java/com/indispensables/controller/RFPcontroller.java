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

import com.indispensables.service.RFPService;
import com.indispensables.vo.RFPVo;

@CrossOrigin("*")
@RestController
public class RFPcontroller {
	
	@Autowired
	RFPService rfpService;
	
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

}
