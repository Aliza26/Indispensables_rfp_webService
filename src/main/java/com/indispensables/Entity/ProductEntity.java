package com.indispensables.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="product_entity")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name= "product_name")
	String productName;
	
	
	@Column(name="unit_price")
	Double productPrice;
	
	
	@Column(name="quantity")
	int productQuantity;
	

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "product_id")
    ProductHeaderEntity product_id;
	
}
