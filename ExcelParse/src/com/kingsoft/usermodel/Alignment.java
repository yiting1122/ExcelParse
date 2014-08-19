package com.kingsoft.usermodel;

public class Alignment {
	public enum Type{
		left,
		right,
		center,
		justify
	}
	
	private int vertical;
	private int horizontal;
	private byte readingOrder;
	private byte indent;
	public int getVertical() {
		return vertical;
	}
	public void setVertical(int vertical) {
		this.vertical = vertical;
	}
	public int getHorizontal() {
		return horizontal;
	}
	public void setHorizontal(int horizontal) {
		this.horizontal = horizontal;
	}
	public int getReadingOrder() {
		return readingOrder;
	}
	
	public byte getIndent() {
		return indent;
	}
	public void setIndent(byte indent) {
		this.indent = indent;
	}
	public void setReadingOrder(byte readingOrder) {
		this.readingOrder = readingOrder;
	}
	@Override
	public String toString() {
		return "Alignment [vertical=" + vertical + ", horizontal=" + horizontal
				+ ", readingOrder=" + readingOrder + ", indent=" + indent + "]";
	}
	
	

	
	
}



