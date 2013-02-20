/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.core.server.domain;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.OnSave;

@Entity
public class CoreEntity {
	
	@Id
	Long id;
	
	Integer version = 0;

	@OnSave
	void onSave() {
		version++;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
