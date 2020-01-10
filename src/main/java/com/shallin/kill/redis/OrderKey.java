package com.shallin.kill.redis;

/**
 * @author shallin
 */
public class OrderKey extends BasePrefix {

	public OrderKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}

}
