package com.indispensables.vo.BidSubmission;

import java.time.LocalDateTime;
import java.util.List;

import com.indispensables.vo.RFPVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BidVo{
	
	private int bidId;
	private String vendorName;
	private String remarks;
	
	private String bidCreationDateTime;
	
	private String bidSubmissionDateTime;
	
	private String bidOpeningDateTime;
	
	private boolean isActive;
	
	private boolean isDraft;
	
	private double bidPrice;
	private boolean bidStatus;
	
	private int bid_head_id;
	
	List<RFPVo> rfpList;
}
