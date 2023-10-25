package com.indispensables.service;

import java.util.List;
import java.util.Optional;

import com.indispensables.vo.Document;
import com.indispensables.vo.RFPVo;
import com.indispensables.vo.Vendor;
import com.indispensables.vo.BidSubmission.BidVo;

public interface RFPService {

	void save(RFPVo vo);
	
	List<RFPVo> getAllRFP(int buyerHeadId);
	
	List<Vendor> getAllVendor(int buyerHeadId);
	
	List<Vendor> getAllActiveVendor();
	
	List<Document> getAllDocument();
	
	RFPVo findRFPById(int id);
	
	List<RFPVo> getAllRFPList();

	RFPVo getRFPById(int rfpId);

	List<BidVo> getAllBids(int id);
	
	
	
	
	
}
