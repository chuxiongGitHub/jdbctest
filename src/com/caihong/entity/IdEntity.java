package com.caihong.entity;

public abstract class IdEntity {
	protected long id;
	
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
}
