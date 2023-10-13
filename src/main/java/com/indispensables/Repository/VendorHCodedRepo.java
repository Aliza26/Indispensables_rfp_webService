package com.indispensables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indispensables.Entity.VendorhardCoded;
@Repository
public interface VendorHCodedRepo extends JpaRepository<VendorhardCoded, Integer>{

}
