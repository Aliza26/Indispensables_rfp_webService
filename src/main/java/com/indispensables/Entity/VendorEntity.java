package com.indispensables.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="vendors")
public class VendorEntity {
	
	@Id
	@Column(name="vendor_id")
	int VID;
	
	@Column(name="vendor_Name")
	String VendorName;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendorHeader_id")
    VendorHeaderEntity vendorHeaderId;
	
	
}
