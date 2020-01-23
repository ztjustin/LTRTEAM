package com.LTR.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="network")
public class Network implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="networkId", unique = true, nullable = false)
	private Long networkId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="platform_id", nullable=false)
	private Platform platformId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="host_id", nullable=true)
	private Host hostId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="kvm_id", nullable=true)
	private Kvm kvmId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pdu_id", nullable=true)
	private Pdu pduId;
	
	public Network() {
		super();
	}

	public Network(Long networkId, Platform platformId, Host hostId, Kvm kvmId, Pdu pduId) {
		super();
		this.networkId = networkId;
		this.platformId = platformId;
		this.hostId = hostId;
		this.kvmId = kvmId;
		this.pduId = pduId;
	}



	public Long getNetworkId() {
		return networkId;
	}

	public void setNetworkId(Long networkId) {
		this.networkId = networkId;
	}

	public Platform getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Platform platformId) {
		this.platformId = platformId;
	}

	public Host getHostId() {
		return hostId;
	}

	public void setHostId(Host hostId) {
		this.hostId = hostId;
	}

	public Kvm getKvmId() {
		return kvmId;
	}

	public void setKvmId(Kvm kvmId) {
		this.kvmId = kvmId;
	}

	public Pdu getPduId() {
		return pduId;
	}

	public void setPduId(Pdu pduId) {
		this.pduId = pduId;
	}

	@Override
	public String toString() {
		return "Network [networkId=" + networkId + ", platformId=" + platformId + ", hostId=" + hostId + ", kvmId="
				+ kvmId + ", pduId=" + pduId + "]";
	}


	
}
