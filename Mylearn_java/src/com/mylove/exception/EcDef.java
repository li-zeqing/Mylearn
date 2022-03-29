package com.mylove.exception;
//自定义异常类
public class EcDef extends Exception{
	static final long serialVersionUID = -338542561262156523L;
	
	public EcDef() {
		
	}
	
	public EcDef(String msg) {
		super(msg);
	}
}
