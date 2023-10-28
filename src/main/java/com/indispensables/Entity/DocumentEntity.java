package com.indispensables.Entity;

import javax.persistence.CascadeType;
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
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="document_entity")
public class DocumentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name= "doc_name")
	String docName;
	
	
	@Column(name="doc_path")
	String docPath;
	
	 
    @ManyToOne(fetch= FetchType.LAZY)
    
    @JoinColumn(name = "document_id")
    DocumentHeaderEntity doc_id;
}
