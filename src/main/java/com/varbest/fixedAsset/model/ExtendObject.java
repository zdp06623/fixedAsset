package com.varbest.fixedAsset.model;

import java.io.Serializable;

public class ExtendObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1483645318164602714L;

	private String name;
	
	private String code;
	
	private String value;
	
	private String unit;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getCode(){
		return code;
	}
	
	public void setCode(String code){
		this.code=code;
	}
	
	public String getValue(){
		return value;
	}
	
	public void setValue(String value){
		this.value=value;
	}
	
	public String getUnit(){
		return unit;
	}
	
	public void setUnit(String unit){
		this.unit=unit;
	}
}
