package com.indispensables.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indispensables.Entity.BuyerEntity;
import com.indispensables.Entity.RFPEntity;
import com.indispensables.Entity.VendorEntity;
import com.indispensables.Entity.VendorHeaderEntity;
import com.indispensables.Repository.BuyerRepository;
import com.indispensables.Repository.RFPRepository;
import com.indispensables.Repository.VendorHeaderRepository;
import com.indispensables.Repository.VendorRepo;
import com.indispensables.service.RFPService;
import com.indispensables.vo.BuyerVo;
import com.indispensables.vo.RFPVo;
import com.indispensables.vo.Vendor;
@Service
public class RFPServiceImpl implements RFPService{

	@Autowired
	RFPRepository rfpRepo;
	@Autowired
	VendorHeaderRepository vendorHRepo;
	@Autowired
	VendorRepo venderRepo;
	@Autowired
	BuyerRepository buyerRepo;
	int count = 5;
	@Override
	public void save(RFPVo vo) {
		// TODO Auto-generated method stub
		RFPEntity rfpEntity = new RFPEntity();
		rfpEntity.setEstimatedPrice(vo.getEstimatedPrice());
		rfpEntity.setPublish(vo.isPublish());
		rfpEntity.setBidOpeningDate(vo.getBidOpeningDate());
		
		rfpEntity.setBidSubmissionDate(vo.getBidSubmissionDate());
		rfpEntity.setDraft(vo.isDraft());
		rfpEntity.setRemarks(vo.getRemarks());
		rfpEntity.setBuyer(buyerRepo.getById(1));
		
		VendorHeaderEntity vhe = new VendorHeaderEntity(1,"Ven");
		List<VendorEntity> vendorList = new ArrayList<>();
		for(Vendor v :vo.getLi()) {
			VendorEntity vendorEntity = new VendorEntity();
			vendorEntity.setVendorHeaderId(vhe);
			vendorEntity.setVendorName(v.getName());
			vendorList.add(vendorEntity);
		}
		vhe.setVendorsList(vendorList);
		vendorHRepo.save(vhe);
		rfpEntity.setVendorHeaderEntity(vhe);
		rfpRepo.save(rfpEntity);
	}
	@Override
	public List<RFPVo> getAllRFP(int buyerHeadId) {
		// TODO Auto-generated method stub
		List<RFPEntity> rfpEntity = rfpRepo.findByBuyerId(buyerHeadId); 
		List<RFPVo> rfpList = new ArrayList<>();
		
		for(RFPEntity rfp : rfpEntity) {
			RFPVo rfpvo = new RFPVo();
			rfpvo.setBidOpeningDate(rfp.getBidOpeningDate());
			rfpvo.setBidSubmissionDate(rfp.getBidSubmissionDate());
			rfpvo.setDraft(rfp.isDraft());
			rfpvo.setId(rfp.getId());
			rfpvo.setEstimatedPrice(rfp.getEstimatedPrice());
			rfpvo.setRemarks(rfp.getRemarks());
			rfpvo.setSplitable(rfp.isSplitable());
			rfpvo.setPublish(rfp.isPublish());
			
			rfpList.add(rfpvo);
		}
		return rfpList;
	}
	
	
}
