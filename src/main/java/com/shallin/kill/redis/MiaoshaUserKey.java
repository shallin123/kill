package com.shallin.kill.redis;

public class MiaoshaUserKey extends BasePrefix{

	public static final int TOKEN_EXPIRE = 3600*24 * 2;
	private MiaoshaUserKey(int expireSecond,String prefix) {
		super(expireSecond,prefix);
	}
	public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE, "tk");
}
