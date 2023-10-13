package com.indispensables.vo;

import java.util.List;

//import com.indispensables.Entity.VendorListHardCoded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RFPVo {

	private String id;

	private double estimatedPrice;

	private boolean isSplitable;

	private boolean isPublish;

	private boolean isDraft;

	private String remarks;

	private String rfpCreationDate;

	private String bidOpeningDate;

	private String bidSubmissionDate;
	
	private String buyerName;
	
	private int buyer;
	
	private List<Vendor> li;
	
	private List<Integer> doc;
	
	private List<String> docNameList;
	
	private List<String> vendoList;

}
