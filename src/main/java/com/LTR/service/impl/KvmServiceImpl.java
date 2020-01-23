package com.LTR.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.LTR.entity.Kvm;
import com.LTR.entity.Platform;
import com.LTR.repository.KvmJpaRepository;
import com.LTR.service.KvmService;

@Service("kvmServiceImpl")
public class KvmServiceImpl implements KvmService {

	@Autowired
	@Qualifier("kvmJpaRepository")
	private KvmJpaRepository kvmJpaRepository;

	@Override
	public List<Kvm> getAll() {
		return kvmJpaRepository.findAll();
	}

	@Override
	public Kvm getOne(Long kvmId) {
		return kvmJpaRepository.getOne(kvmId);
	}

	@Override
	public Kvm addOne(Kvm kvm) {
		return kvmJpaRepository.save(kvm);
	}

	@Override
	public void delete(Long kvmId) {

		kvmJpaRepository.deleteById(kvmId);
	}

	@Override
	public Kvm getOneByPlatform(Platform platform) {

		return kvmJpaRepository.findByPlatform(platform);


	}

	@Override
	public List<Kvm> findAllWherePlatformNull() {
		return kvmJpaRepository.findByPlatformNuLL();
	}
	

}
