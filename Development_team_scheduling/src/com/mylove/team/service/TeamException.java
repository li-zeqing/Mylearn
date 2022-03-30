package com.mylove.team.service;
/**
 * 
 * @Description 自定义异常类
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月30日下午7:40:22
 *
 */
public class TeamException extends Exception{

	static final long serialVersionUID = -3387516993459948L;
	public TeamException() {
		super();
	}
	
	public TeamException(String msg) {
		super(msg);
	}
}
