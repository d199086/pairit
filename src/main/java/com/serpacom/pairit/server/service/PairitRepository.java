package com.serpacom.pairit.server.service;

import com.serpacom.pairit.server.dto.PairEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by deepakga on 1/2/2018.
 */
@Repository
public interface PairitRepository extends JpaRepository<PairEntity, UUID> {

    @Transactional
    @Modifying
    @Query(value = "delete from PAIR_ENTITY p where p.user_id=:userId", nativeQuery = true)
    Integer deleteAllUserPairs(@Param("userId") UUID userId);


    @Query(value = "select * from PAIR_ENTITY p where p.user_id=:userId", nativeQuery = true)
    List<PairEntity> findPairsByUserId(@Param("userId") UUID userId);
}
