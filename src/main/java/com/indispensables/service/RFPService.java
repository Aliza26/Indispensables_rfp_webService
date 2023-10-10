package com.indispensables.service;

import java.util.List;

import com.indispensables.vo.RFPVo;

public interface RFPService {

	void save(RFPVo vo);
	
	List<RFPVo> getAllRFP(int buyerHeadId);
	
	
}
