package com.indispensables.Entity;

import java.time.LocalDateTime;

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

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="rfp_entity")
public class RFPEntity {
	
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="client_id")
	 private String client_id;
	
	    @Id
	    @GenericGenerator(name = "rfp_id", strategy =
	    "com.indispensables.Entity.ClientIdGenerator")
	    @GeneratedValue(generator = "rfp_id")  
	    @Column(name="rfp_id")
	    private String rfpId;
	    
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
	    private LocalDateTime rfpCreationDate;
	    
	    @Column(name = "_bid_opening_date") 
	    private String bidOpeningDate;
	    
	    @Column(name = "_bid_submission_date") 
	    private String bidSubmissionDate;
	    
	    @Column(name="rfp_name")
	    private String name;
	    
	    @Column(name="buyer_name")
	    private String buyerName;
	 
	    @OneToOne(cascade = CascadeType.MERGE)
	    @JoinColumn(name = "_document_header_key")
	    DocumentHeaderEntity documentHeaderEntity;
	    
	    @OneToOne(cascade = CascadeType.MERGE)
	    @JoinColumn(name = "_bid_header_key")
	    BidHeaderEntity bidHeaderEntity;
	    
	    @OneToOne(cascade = CascadeType.MERGE)
	    @JoinColumn(name = "vendor_header_key")
	    VendorHeaderEntity vendorHeaderEntity;
	    
	    @ManyToOne
	    @JoinColumn(name = "buyer_id") // This is the foreign key column in the RfpDetail table
	    private BuyerEntity buyer;
	    
}
