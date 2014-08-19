package com.kingsoft.usermodel;

public class ColorStyle {
	
	public enum ColorStyleType{
		theme,indexed,rgb;
	}
	
	private int type;
	private int value;
	
	
//	private short theme;
//	private short indexed;
//	private int rgb;
	private String tint;
//	public short getTheme() {
//		return theme;
//	}
//	public void setTheme(short theme) {
//		this.theme = theme;
//	}
//	public short getIndexed() {
//		return indexed;
//	}
//	public void setIndexed(short indexed) {
//		this.indexed = indexed;
//	}
//	public int getRgb() {
//		return rgb;
//	}
//	public void setRgb(int rgb) {
//		this.rgb = rgb;
//	}
	public String getTint() {
		return tint;
	}
	public void setTint(String tint) {
		this.tint = tint;
	}

	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ColorStyle [type=" + type + ", value=" + value + ", tint="
				+ tint + "]";
	}
	
	
	
}
