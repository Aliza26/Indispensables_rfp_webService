package com.indispensables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.indispensables.Entity.DocumentHardCoded;
@Repository
public interface DocumentHCodedRepo extends JpaRepository<DocumentHardCoded, Integer>{

}
