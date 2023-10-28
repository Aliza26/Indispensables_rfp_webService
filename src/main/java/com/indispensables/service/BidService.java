package com.indispensables.service;

import java.util.List;
import com.indispensables.vo.BidSubmission.BidVo;

public interface BidService {
	
	void saveBid(BidVo bidvo);
	
	List<BidVo> getAllBid(int id);
	
	BidVo getBidDetails(int id);
}
