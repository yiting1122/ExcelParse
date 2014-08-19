package com.kingsoft.util;

public class ColorConvertor {
	public static String toHex(int value){
		
		return  "FF"+Integer.toHexString(value);
	}
	
	public static int toInt(String value){
		
		return Integer.valueOf(value.substring(2), 16);
	}
}
