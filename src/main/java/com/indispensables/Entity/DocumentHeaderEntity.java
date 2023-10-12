package com.indispensables.Entity;

import java.util.ArrayList;
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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Document_header_entity")

public class DocumentHeaderEntity {

	@Id
	int id;
	
	@Column(name="name")
	String document_name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "doc_id")
    List<DocumentEntity> document;
}
