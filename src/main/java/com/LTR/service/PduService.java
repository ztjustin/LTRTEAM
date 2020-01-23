package com.LTR.service;

import java.util.List;

import com.LTR.entity.Pdu;
import com.LTR.entity.Platform;

public interface PduService {
	
	public abstract List<Pdu> getAll();
	
	public abstract Pdu getOne(Long pduId);

	public abstract Pdu getOneByPlatform(Platform platform);
	
	public abstract Pdu addOne(Pdu pdu);

	public abstract List<Pdu> findAllWherePlatformNull();
	
	public abstract void delete(Long pduId);

}
