package com.kingsoft.value;

public class ErrorValue implements Value {
	
	private String _value;
	
	@Override
	public byte getType() {
		return ValueType.CELL_TYPE_ERROR;
	}

	public String get_value() {
		return _value;
	}

	public void set_value(String _value) {
		this._value = _value;
	}

	
}
