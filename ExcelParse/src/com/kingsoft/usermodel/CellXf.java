package com.kingsoft.usermodel;

public class CellXf {
	private int numFmtId;
	private int borderId;
	private int fillId;
	private int fontId;
	private int xfId;
	private boolean applyNumberFormat;
	private boolean applyAlignment;
	private boolean applyFill;
	private boolean applyBorder;

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

	public int getXfId() {
		return xfId;
	}

	public void setXfId(int xfId) {
		this.xfId = xfId;
	}

	public boolean getApplyNumberFormat() {
		return applyNumberFormat;
	}

	public void setApplyNumberFormat(boolean applyNumberFormat) {
		this.applyNumberFormat = applyNumberFormat;
	}

	public boolean getApplyAlignment() {
		return applyAlignment;
	}

	public void setApplyAlignment(boolean applyAlignment) {
		this.applyAlignment = applyAlignment;
	}

	public boolean getApplyFill() {
		return applyFill;
	}

	public void setApplyFill(boolean applyFill) {
		this.applyFill = applyFill;
	}

	public boolean getApplyBorder() {
		return applyBorder;
	}

	public void setApplyBorder(boolean applyBorder) {
		this.applyBorder = applyBorder;
	}


	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}
	
	@Override
	public String toString() {
		return "CellXF [numFmtId=" + numFmtId + ", borderId=" + borderId
				+ ", fillId=" + fillId + ", fontId=" + fontId + ", xfId="
				+ xfId + ", applyNumberFormat=" + applyNumberFormat
				+ ", applyAligment=" + applyAlignment + ", applyFill="
				+ applyFill + ", applyBorder=" + applyBorder
				+ ", alignment=" + alignment.toString()+"]";
	}

	

}
