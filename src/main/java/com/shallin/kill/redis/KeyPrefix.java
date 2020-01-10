package com.shallin.kill.redis;

/**
 * @author shallin
 */
public interface KeyPrefix {
		
	public int expireSeconds();
	
	public String getPrefix();
	
}
