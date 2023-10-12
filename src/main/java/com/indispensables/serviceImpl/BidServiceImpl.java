package com.indispensables.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indispensables.Entity.BidSubmissionEntity;
import com.indispensables.Entity.RFPEntity;
import com.indispensables.Entity.VendorEntity;
import com.indispensables.Entity.VendorHeaderEntity;
import com.indispensables.Repository.BidSubRepo;
import com.indispensables.Repository.DocumentHeaderRepo;
import com.indispensables.Repository.DocumentRepo;
import com.indispensables.service.BidService;
import com.indispensables.vo.RFPVo;
import com.indispensables.vo.Vendor;
import com.indispensables.vo.BidSubmission.BidVo;


@Service
public class BidServiceImpl implements BidService{

	@Autowired
	BidSubRepo bidSubRepo;
	
	@Autowired
	DocumentRepo documentRepo;
	
	@Autowired
	DocumentHeaderRepo documentHeaderRepo;
	
	@Override
	public void saveBid(BidVo bidVo) {
		
		BidSubmissionEntity bidSubmissionEntity = new BidSubmissionEntity();
		
		bidSubmissionEntity.setBidId(bidVo.getBidId());
		bidSubmissionEntity.setVendorName(bidVo.getVendorName());
		bidSubmissionEntity.setBidPrice(bidVo.getBidPrice());
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

//        LocalDateTime localDateTime = LocalDateTime.parse();

		bidSubmissionEntity.setBidCreationDateTime( LocalDateTime.parse(bidVo.getBidCreationDateTime()));
		bidSubmissionEntity.setBidSubmissionDateTime(LocalDateTime.parse(bidVo.getBidSubmissionDateTime())); // this should be default 
		bidSubmissionEntity.setBidOpeningDateTime(LocalDateTime.parse(bidVo.getBidOpeningDateTime()));
		
		bidSubmissionEntity.setBidStatus(true);
		bidSubmissionEntity.setActive(true);
		bidSubmissionEntity.setRemarks(bidVo.getRemarks());
		bidSubmissionEntity.setDraft(false);	
		//		bidSubmissionEntity
		
		bidSubRepo.save(bidSubmissionEntity);
	}

	@Override
	public List<BidVo> getAllBid(int vendorHeaderId) {
		
		List<BidSubmissionEntity> bidSubEntityList = bidSubRepo.findByVendorHeaderId(vendorHeaderId);
		List<BidVo> bidVoList = new ArrayList<>();
		
		for(BidSubmissionEntity bidE: bidSubEntityList) {

			BidVo bidVo = new BidVo();
			
			bidVo.setBidId(bidE.getBidId());
			bidVo.setBidPrice(bidE.getBidPrice());
			bidVo.setBidCreationDateTime(bidE.getBidCreationDateTime().toString());
			bidVo.setBidSubmissionDateTime(bidE.getBidSubmissionDateTime().toString());
			bidVo.setBidOpeningDateTime(bidE.getBidOpeningDateTime().toString());
			bidVo.setBidStatus(bidE.isBidStatus());
			
			bidVoList.add(bidVo);
		}
		return bidVoList;
	}
	
	
	
	
	
}
