package com.sunBank.security.utilities;

public class JWTUtil {
	public static final String SECRET = "Xv2zSb74jazC@sjhdjhd78&23%ZQX&$)(##@)_+|";
	public static final String AUTH_HEADER = "Authorization";
	public static final long EXPIRE_ACCESS_TOKEN = 15 * 60 * 1000; // 15 min
	public static final long EXPIRE_REFRESH_TOKEN = 30L*24*60*60*1000; // 30days
	public static final  String PREFIX = "Bearer ";
}
