package com.LTR.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LTR.entity.Network;
import com.LTR.entity.Platform;

@Repository("networkJpaRepository") 
public interface NetworkJpaRepository extends JpaRepository<Network, Serializable> {
	
	public abstract Network findByplatformId(Platform platform);

}
