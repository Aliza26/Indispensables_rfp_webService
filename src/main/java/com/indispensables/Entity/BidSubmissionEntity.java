package com.indispensables.Entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BidSubmissionEntity {
	
	@Id
	@Column(name="bid_id")
	private int bidId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rfp_id")
	private RFPEntity rfpEnity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="doc_header_entity")
	private DocumentHeaderEntity docHeaderEntity;
	
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="bid_creation_date_time")
	private LocalDateTime bidCreationDateTime;
	
	@Column(name="bid_sub_date_time")
	private LocalDateTime bidSubmissionDateTime;
	
	@Column(name="bid_opening_date_time")
	private LocalDateTime bidOpeningDateTime;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="is_draft")
	private boolean isDraft;
	
	@Column(name="bid_price")
	private double bidPrice;
	
	
	
}
