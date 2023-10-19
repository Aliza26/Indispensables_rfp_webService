package com.indispensables.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indispensables.Entity.RFPEntity;

@Repository
public interface RFPRepository extends JpaRepository<RFPEntity, Integer>{
	
	@Query(value="select * from rfp_entity  where buyer_id = :buyer",nativeQuery=true)
    List<RFPEntity> findByBuyerId(@Param("buyer")int buyer);
//
//	@Query(value="select * from rfp_entity  where client_id =:rfp_id",nativeQuery=true)
//	List<RFPEntity> findByClientId(@Param("client_id") int rfp_id);
	
	public Optional<RFPEntity> findById(Integer id);
 

}
