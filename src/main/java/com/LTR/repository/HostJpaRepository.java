package com.LTR.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.LTR.entity.Host;
import com.LTR.entity.Platform;

@Repository("hostJpaRepository")
public interface HostJpaRepository  extends JpaRepository<Host, Serializable>{
	
  public abstract Host findByPlatform(Platform platform);

  
	@Query(value = "from Host where platform = null")
  public abstract List<Host> findByPlatformNuLL();	

}
