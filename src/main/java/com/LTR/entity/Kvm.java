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
@Table(name="kvm")
public class Kvm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="kvm_id", unique = true, nullable = false)
	private Long kvmId;
	
	@Column(name="name",nullable=false,length=80,unique = false)
	private String name;
	
	@Column(name="ip",nullable=false,length=50)
	private String ip;

	@Column(name="port",nullable=false)
	private int port;	

	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "platform_id")
    private Platform platform;

	public Kvm() {
		super();
	}

	public Kvm(Long kvmId, String name, String ip, int port, Platform platform) {
		this.kvmId = kvmId;
		this.name = name;
		this.ip = ip;
		this.port = port;
		this.platform = platform;
	}

	public Long getKvmId() {
		return kvmId;
	}

	public void setKvmId(Long kvmId) {
		this.kvmId = kvmId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	
}
