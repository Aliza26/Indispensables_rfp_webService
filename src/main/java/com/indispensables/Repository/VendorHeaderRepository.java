package com.indispensables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indispensables.Entity.VendorHeaderEntity;
@Repository
public interface VendorHeaderRepository extends JpaRepository<VendorHeaderEntity, Integer>{

}
