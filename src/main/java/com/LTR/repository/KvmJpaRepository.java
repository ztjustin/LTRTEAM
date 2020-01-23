package com.LTR.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.LTR.entity.Kvm;
import com.LTR.entity.Platform;

@Repository("kvmJpaRepository")
public interface KvmJpaRepository extends JpaRepository<Kvm, Serializable> {
    
        public abstract Kvm findByPlatform(Platform platform);

        @Query(value = "from Kvm where platform = null")
        public abstract List<Kvm> findByPlatformNuLL();	
        
}
