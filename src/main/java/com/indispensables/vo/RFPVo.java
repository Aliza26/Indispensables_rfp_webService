package com.indispensables.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RFPVo {

	private int id;

	private double estimatedPrice;

	private boolean isSplitable;

	private boolean isPublish;

	private boolean isDraft;

	private String remarks;

	private String rfpCreationDate;

	private String bidOpeningDate;

	private String bidSubmissionDate;
	
	private List<Vendor> li;

}
