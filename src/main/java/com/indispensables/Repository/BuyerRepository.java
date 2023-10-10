package com.indispensables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indispensables.Entity.BuyerEntity;
@Repository
public interface BuyerRepository extends JpaRepository<BuyerEntity, Integer>{

}
