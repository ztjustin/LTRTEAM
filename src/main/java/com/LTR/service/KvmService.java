package com.LTR.service;

import java.util.List;

import com.LTR.entity.Kvm;
import com.LTR.entity.Platform;

public interface KvmService {
	
	public abstract List<Kvm> getAll();
	
	public abstract Kvm getOne(Long kvmId);

	public abstract Kvm getOneByPlatform(Platform platform);

	public abstract List<Kvm> findAllWherePlatformNull();
	
	public abstract Kvm addOne(Kvm kvm);
	
	public abstract void delete(Long kvmId);

}
