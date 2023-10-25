package com.indispensables.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indispensables.Entity.BidHeaderEntity;
import com.indispensables.Entity.BidSubmissionEntity;
import com.indispensables.Entity.RFPEntity;
import com.indispensables.Entity.VendorEntity;
import com.indispensables.Entity.VendorHeaderEntity;
import com.indispensables.Repository.BidHeaderRepo;
import com.indispensables.Repository.BidSubRepo;
import com.indispensables.Repository.DocumentHeaderRepo;
import com.indispensables.Repository.DocumentRepo;
import com.indispensables.Repository.RFPRepository;
import com.indispensables.service.BidService;
import com.indispensables.vo.RFPVo;
import com.indispensables.vo.Vendor;
import com.indispensables.vo.BidSubmission.BidVo;

@Service
public class BidServiceImpl implements BidService {

	@Autowired
	BidSubRepo bidSubRepo;

	@Autowired
	DocumentRepo documentRepo;

	@Autowired
	BidHeaderRepo bidHeaderRepo;

	@Autowired
	DocumentHeaderRepo documentHeaderRepo;
	
	@Autowired
	RFPRepository refRepo;

	@Override
	public void saveBid(BidVo bidVo) {

		BidSubmissionEntity bidSubmissionEntity = new BidSubmissionEntity();
		
        bidSubmissionEntity.setBid_id(refRepo.getById(bidVo.getRfp_id()).getBidHeaderEntity());
		bidSubmissionEntity.setBidSubId(bidVo.getBidId());
		bidSubmissionEntity.setVendorName(bidVo.getVendorName());
		bidSubmissionEntity.setBidPrice(bidVo.getBidPrice());
		
		
	
		
	  
     	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//
//        
        LocalDateTime now = LocalDateTime.now();
		bidSubmissionEntity.setBidCreationDateTime(now);
//				bidVo.getBidCreationDateTime()));
		System.out.println(bidVo.getBidSubmissionDateTime());
		bidSubmissionEntity.setBidSubmissionDateTime
		(LocalDateTime.parse(bidVo.getBidSubmissionDateTime().substring(0, 19),formatter)); // this should be default 
		bidSubmissionEntity.setBidOpeningDateTime(LocalDateTime.parse
				(bidVo.getBidOpeningDateTime().substring(0, 19),formatter));
//		
		bidSubmissionEntity.setBidStatus(bidVo.isBidStatus());
		bidSubmissionEntity.setActive(bidVo.isActive());
		bidSubmissionEntity.setRemarks(bidVo.getRemarks());
		bidSubmissionEntity.setDraft(bidVo.isDraft());
		// bidSubmissionEntity

		bidSubRepo.save(bidSubmissionEntity);
	}

	@Override
	public List<BidVo> getAllBid(int vendorHeaderId) {

		List<BidSubmissionEntity> bidSubEntityList = bidSubRepo.findByVendorHeaderId(vendorHeaderId);
		List<BidVo> bidVoList = new ArrayList<>();

		for (BidSubmissionEntity bidE : bidSubEntityList) {

			BidVo bidVo = new BidVo();

			bidVo.setBidId(bidE.getBidSubId());
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
