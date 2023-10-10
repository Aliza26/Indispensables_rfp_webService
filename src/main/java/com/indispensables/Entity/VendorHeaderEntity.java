package com.indispensables.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="vendor_h_name")
	String VendorHName;
	
	public VendorHeaderEntity(int id, String name) {
		super();
		this.id = id;
		this.VendorHName = name;
	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "vendorHeaderId")
	List<VendorEntity> vendorsList;
	

}
