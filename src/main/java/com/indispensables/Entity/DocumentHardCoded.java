package com.indispensables.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="document_hard_coded")
public class DocumentHardCoded {
	@Id
	int id;
	
	@Column(name= "doc_name")
	String docName;
	
}
