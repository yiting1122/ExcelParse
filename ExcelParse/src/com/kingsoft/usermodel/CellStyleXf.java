package com.kingsoft.usermodel;

public class CellStyleXf {
	private int numFmtId;
	private int borderId;
	private int fillId;
	private int fontId;

	private Alignment alignment;

	public int getNumFmtId() {
		return numFmtId;
	}

	public void setNumFmtId(int numFmtId) {
		this.numFmtId = numFmtId;
	}

	public int getBorderId() {
		return borderId;
	}

	public void setBorderId(int borderId) {
		this.borderId = borderId;
	}

	public int getFillId() {
		return fillId;
	}

	public void setFillId(int fillId) {
		this.fillId = fillId;
	}

	public int getFontId() {
		return fontId;
	}

	public void setFontId(int fontId) {
		this.fontId = fontId;
	}

	

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	@Override
	public String toString() {
		return "CellStyleXf [numFmtId=" + numFmtId + ", borderId=" + borderId
				+ ", fillId=" + fillId + ", fontId=" + fontId
				+ ", alignmentVertical=" + alignment.toString() + "]";
	}

	
}
