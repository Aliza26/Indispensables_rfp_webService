package com.indispensables.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.indispensables.Entity.BidSubmissionEntity;

@Repository
public interface BidSubRepo extends JpaRepository<BidSubmissionEntity,Integer>{

	@Query(value="select * from bid_sub_entity where vendorHeader_id = :vendorHeaderId",nativeQuery=true)
    List<BidSubmissionEntity> findByVendorHeaderId(@Param("vendorHeaderId")int vendorHeaderId);
	
}
