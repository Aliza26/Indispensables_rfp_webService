package com.indispensables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indispensables.Entity.DocumentHeaderEntity;

@Repository
public interface DocumentHeaderRepo extends JpaRepository<DocumentHeaderEntity, Integer>{

}
