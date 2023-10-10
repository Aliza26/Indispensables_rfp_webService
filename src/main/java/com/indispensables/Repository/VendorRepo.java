package com.indispensables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indispensables.Entity.VendorEntity;
@Repository
public interface VendorRepo extends JpaRepository<VendorEntity, Integer>{

}
