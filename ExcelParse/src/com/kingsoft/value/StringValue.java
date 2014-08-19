package com.kingsoft.value;

public class StringValue implements Value {
	public String _value;
	
	@Override
	public byte getType() {
		return ValueType.CELL_TYPE_STRING;
	}
	public String get_value() {
		return _value;
	}
	public void set_value(String _value) {
		this._value = _value;
	}

	
}
