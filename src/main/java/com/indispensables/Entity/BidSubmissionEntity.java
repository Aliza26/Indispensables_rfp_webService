package com.indispensables.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.indispensables.vo.RFPVo;
import com.indispensables.vo.BidSubmission.BidVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bid_sub_entity")
public class BidSubmissionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bid_sub_id")
	private int bidSubId;

	@Column(name = "vendor_name")
	private String vendorName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doc_header_key")
	private DocumentHeaderEntity docHeaderEntity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor_header_key")
	private VendorHeaderEntity vendorHeaderEntity;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "bid_creation_date_time")
	private LocalDateTime bidCreationDateTime;

	@Column(name = "bid_sub_date_time")
	private LocalDateTime bidSubmissionDateTime;

	@Column(name = "bid_opening_date_time")
	private LocalDateTime bidOpeningDateTime;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "is_draft")
	private boolean isDraft;

	@Column(name = "bid_price")
	private double bidPrice;

	@Column(name = "bid_status")
	private boolean bidStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bid_id")
	BidHeaderEntity bid_id;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_header_key")
	private ProductHeaderEntity productHeaderEntity;
	
	

}
