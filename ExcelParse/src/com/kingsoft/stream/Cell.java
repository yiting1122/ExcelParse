package com.kingsoft.stream;

import com.kingsoft.value.Value;

public class Cell {
	private Value value;

	// private short styleId;

	public Cell() {

	}

//	public Cell(Value value, short styleId) {
//		this.value = value;
//		this.styleId = styleId;
//	}
	
	

	public Value getValue() {
		return value;
	}

	public Cell(Value value) {
	super();
	this.value = value;
}

	public void setValue(Value value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Cell [value=" + value + "]";
	}

	// public short getStyleId() {
	// return styleId;
	// }
	// public void setStyleId(short styleId) {
	// this.styleId = styleId;
	// }
	// @Override
	// public String toString() {
	// return "Cell [value=" + value + ", styleId="
	// + styleId + "]";
	// }

}
