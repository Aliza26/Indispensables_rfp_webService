package com.indispensables.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="vendor_header")
public class VendorHeaderEntity {
	@Id
	@Column(name="vendor_header_id")
	int VHId;
	
	@Column(name="vendor_h_name")
	String VendorHName;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "vendorHeaderId")
	List<VendorEntity> vendorsList;
	

}
