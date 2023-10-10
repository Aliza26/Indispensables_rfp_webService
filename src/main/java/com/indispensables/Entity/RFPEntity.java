package com.indispensables.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="rfp_entity")
public class RFPEntity {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 
	    @Column(name = "_estimated_price")
	    private double estimatedPrice;
	 
	    @Column(name = "_is_Splitable") 
	    private boolean isSplitable;
	    
	    @Column(name = "_is_publish") 
	    private boolean isPublish;
	     
	    @Column(name = "_is_draft") 
	    private boolean isDraft;
	 
	    @Column(name = "remarks") 
	    private String remarks;
	    
	    @Column(name = "_rfp_creation_date") 
	    private String rfpCreationDate;
	    
	    @Column(name = "_bid_opening_date") 
	    private String bidOpeningDate;
	    
	    @Column(name = "_bid_submission_date") 
	    private String bidSubmissionDate;
	 
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "_document_header_key")
	    DocumentHeaderEntity documentHeaderEntity;
	    
	    
	    @OneToOne(cascade = CascadeType.MERGE)
	    @JoinColumn(name = "vendor_header_key")
	    VendorHeaderEntity vendorHeaderEntity;
	    
	    @ManyToOne
	    @JoinColumn(name = "buyer_id") // This is the foreign key column in the RfpDetail table
	    private BuyerEntity buyer;
	    
}
