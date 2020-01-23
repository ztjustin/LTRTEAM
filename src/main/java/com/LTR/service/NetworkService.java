package com.LTR.service;

import java.util.List;

import com.LTR.entity.Network;
import com.LTR.entity.Platform;

public interface NetworkService {
	
	public abstract List<Network> getAll();
	
	public abstract Network getOne(Long networkId);
	
	public abstract Network getOneByPlatform(Platform platform);
	
	public abstract Network addOne(Network network);
	
	public abstract void delete(Long networkId);

}
