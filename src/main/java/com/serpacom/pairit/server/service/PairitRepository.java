package com.serpacom.pairit.server.service;

import com.serpacom.pairit.server.dto.PairEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by deepakga on 1/2/2018.
 */
@Repository
public interface PairitRepository extends JpaRepository<PairEntity, UUID> {

    @Query(value = "select p.name from PairEntity p where p.user_id=:userId", nativeQuery = true)
    void deleteAllUserPairs(@Param("userId") UUID userId);
}
