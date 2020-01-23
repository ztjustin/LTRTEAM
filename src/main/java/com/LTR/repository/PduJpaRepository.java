package com.LTR.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.LTR.entity.Pdu;
import com.LTR.entity.Platform;

@Repository("pduJpaRepository")
public interface PduJpaRepository extends JpaRepository<Pdu, Serializable> {
	
	public abstract Pdu findByPlatform(Platform platform);

	@Query(value = "from Pdu where platform = null")
    public abstract List<Pdu> findByPlatformNuLL();	

}
