package com.shallin.kill.util;

import java.util.UUID;

/**
 * @author shallin
 */
public class UUIDUtil {
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
