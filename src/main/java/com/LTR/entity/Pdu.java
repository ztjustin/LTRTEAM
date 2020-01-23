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
@Table(name="pdu")
public class Pdu implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pdu_id", unique = true, nullable = false)
	private Long pduId;
	
	@Column(name="name",nullable=false,length=80,unique = true)
	private String name;
	
	@Column(name="ip",nullable=false,length=50)
	private String ip;

	@Column(name="port",nullable=false,length=50)
	private int port;

	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "platform_id")
    private Platform platform;

	public Pdu() {
		super();
	}

	public Pdu(Long pduId, String name, String ip, int port, Platform platform) {
		this.pduId = pduId;
		this.name = name;
		this.ip = ip;
		this.port = port;
		this.platform = platform;
	}

	public Long getPduId() {
		return pduId;
	}

	public void setPduId(Long pduId) {
		this.pduId = pduId;
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
