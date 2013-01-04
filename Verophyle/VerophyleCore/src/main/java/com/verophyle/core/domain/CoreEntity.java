package com.verophyle.core.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

public class CoreEntity<I> {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private I id;
	
	@Version
	@Column(name = "version")
	private Integer version;
	
	public I getId() {
		return id;
	}
	
	public Integer getVersion() {
		return version;
	}
	
}
