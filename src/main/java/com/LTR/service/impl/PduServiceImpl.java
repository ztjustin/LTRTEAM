package com.LTR.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.LTR.entity.Pdu;
import com.LTR.entity.Platform;
import com.LTR.repository.PduJpaRepository;
import com.LTR.service.PduService;

@Service("pduServiceImpl")
public class PduServiceImpl implements PduService {

	@Autowired
	@Qualifier("pduJpaRepository")
	private PduJpaRepository pduJpaRepository;

	@Override
	public List<Pdu> getAll() {
		return pduJpaRepository.findAll();
	}

	@Override
	public Pdu getOne(Long pduId) {
		return pduJpaRepository.getOne(pduId);
	}

	@Override
	public Pdu addOne(Pdu pdu) {
		return pduJpaRepository.save(pdu);
	}

	@Override
	public void delete(Long pduId) {
		pduJpaRepository.deleteById(pduId);

	}

	@Override
	public Pdu getOneByPlatform(Platform platform) {
		return pduJpaRepository.findByPlatform(platform);
	}

	@Override
	public List<Pdu> findAllWherePlatformNull() {
		return pduJpaRepository.findByPlatformNuLL();
	}
	
}
