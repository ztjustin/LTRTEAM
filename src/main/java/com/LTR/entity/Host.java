package com.LTR.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="host")
public class Host implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="host_id", unique = true, nullable = false)
	private Long hostId;
	
	@Column(name="name",nullable=false,length=80,unique = false)
	private String name;
	
	@Column(name="ip_host",nullable=false,length=50,unique = true)
	private String ipHost;

	@Column(name="ip_vm",nullable=false,length=50,unique = true)
	private String ipVm;	
	
	@Column(name="dal")
	private Boolean dal;

	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "platform_id")
    private Platform platform;

		
	public Host() {
		super();
	}

	public Host(Long hostId, String name, String ipHost, String ipVm, Boolean dal, Platform platform) {
		this.hostId = hostId;
		this.name = name;
		this.ipHost = ipHost;
		this.ipVm = ipVm;
		this.dal = dal;
		this.platform = platform;
	}


	public Platform getPlatform() {
		return this.platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Long getHostId() {
		return hostId;
	}

	public void setHostId(Long hostId) {
		this.hostId = hostId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDal() {
		return dal;
	}

	public void setDal(Boolean dal) {
		this.dal = dal;
	}

	public String getIpHost() {
		return ipHost;
	}

	public void setIpHost(String ipHost) {
		this.ipHost = ipHost;
	}

	public String getIpVm() {
		return ipVm;
	}

	public void setIpVm(String ipVm) {
		this.ipVm = ipVm;
	}
		
}
