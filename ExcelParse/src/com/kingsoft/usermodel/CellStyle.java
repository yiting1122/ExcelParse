package com.kingsoft.usermodel;

public class CellStyle {
	public final static short DEFAULT=0; 
	private int xfId;
	private int builtinId;
	private String name;
	public int getXfId() {
		return xfId;
	}
	public void setXfId(int xfId) {
		this.xfId = xfId;
	}
	public int getBuiltinId() {
		return builtinId;
	}
	public void setBuiltinId(int builtinId) {
		this.builtinId = builtinId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CellStyle [xfId=" + xfId + ", builtinId=" + builtinId
				+ ", name=" + name + "]";
	}
	
	
}
