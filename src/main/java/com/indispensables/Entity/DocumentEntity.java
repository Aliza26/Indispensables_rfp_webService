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
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="document_entity")
public class DocumentEntity {

	@Id
	int id;
	
	@Column(name= "doc_name")
	String docName;
	
	 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id")
    DocumentHeaderEntity doc_id;
}
