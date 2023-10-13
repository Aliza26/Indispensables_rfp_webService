package com.indispensables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indispensables.Entity.BidHeaderEntity;
@Repository
public interface BidHeaderRepo extends JpaRepository<BidHeaderEntity, Integer>{

}
