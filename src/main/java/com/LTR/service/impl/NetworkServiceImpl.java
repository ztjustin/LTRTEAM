package com.LTR.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.LTR.entity.Network;
import com.LTR.entity.Platform;
import com.LTR.repository.NetworkJpaRepository;
import com.LTR.service.NetworkService;

@Service("networkServiceImpl")
public class NetworkServiceImpl implements NetworkService {
	
	@Autowired
	@Qualifier("networkJpaRepository")
	private NetworkJpaRepository networkJpaRepository;

	@Override
	public List<Network> getAll() {
		return networkJpaRepository.findAll();
	}

	@Override
	public Network getOne(Long networkId) {
		return networkJpaRepository.getOne(networkId);
	}

	@Override
	public Network addOne(Network network) {
		return networkJpaRepository.save(network);
	}

	@Override
	public void delete(Long networkId) {
		networkJpaRepository.deleteById(networkId);
		
	}

	@Override
	public Network getOneByPlatform(Platform platform) {
		return networkJpaRepository.findByplatformId(platform);
	}
	
	

}
