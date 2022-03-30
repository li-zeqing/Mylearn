package com.mylove.team.service;

/**
 * 
 * @Description 表示员工状态
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月29日下午11:28:13
 *
 */
public class Status {

	private final String NAME;

	public Status(String name) {
		super();
		NAME = name;
	}
	
	public String getNAME() {
		return NAME;
	}

	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VOCATION = new Status("VOCATION");

	@Override
	public String toString() {
		return NAME;
	}
}
