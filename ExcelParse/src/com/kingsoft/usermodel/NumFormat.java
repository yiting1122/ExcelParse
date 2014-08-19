package com.kingsoft.usermodel;

public class NumFormat {
	private String numFormatCode;
	private int numFormatId;
	public String getNumFormatCode() {
		return numFormatCode;
	}
	public void setNumFormatCode(String numFormatCode) {
		this.numFormatCode = numFormatCode;
	}
	public int getNumFormatId() {
		return numFormatId;
	}
	public void setNumFormatId(int numFormatId) {
		this.numFormatId = numFormatId;
	}
	@Override
	public String toString() {
		return "NumFormat [numFormatCode=" + numFormatCode + ", numFormatId="
				+ numFormatId + "]";
	}
	
	
}
