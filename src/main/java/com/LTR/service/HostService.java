package com.LTR.service;

import java.util.List;

import com.LTR.entity.Host;
import com.LTR.entity.Platform;

public interface HostService {
	
	public abstract List<Host> getAll();
	
	public abstract Host getOne(Long hostId);

	public abstract Host getOneByPlatform(Platform platform);

	public abstract List<Host> getByPlatformNull();
	
	public abstract Host addOne(Host host);
	
	public abstract void delete(Long hostId);

}
