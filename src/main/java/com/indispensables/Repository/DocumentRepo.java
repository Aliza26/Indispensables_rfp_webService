package com.indispensables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indispensables.Entity.DocumentEntity;

@Repository
public interface DocumentRepo extends JpaRepository<DocumentEntity, Integer> {

}
