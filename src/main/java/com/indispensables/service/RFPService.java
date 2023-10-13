package com.indispensables.service;

import java.util.List;

import com.indispensables.vo.Document;
import com.indispensables.vo.RFPVo;
import com.indispensables.vo.Vendor;

public interface RFPService {

	void save(RFPVo vo);
	
	List<RFPVo> getAllRFP(int buyerHeadId);
	
	List<Vendor> getAllVendor(int buyerHeadId);
	
	List<Vendor> getAllActiveVendor();
	
	List<Document> getAllDocument();
	
	RFPVo findRFPById(int id);
	
	List<RFPVo> getAllRFPList();
	
	
	
	
	
}
