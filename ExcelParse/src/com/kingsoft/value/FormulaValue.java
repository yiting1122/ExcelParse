package com.kingsoft.value;

public class FormulaValue implements Value {
	private String _value;
	@Override
	public byte getType() {
		return ValueType.CELL_TYPE_NUMERIC;
	}
	public String get_value() {
		return _value;
	}
	public void set_value(String _value) {
		this._value = _value;
	}
	
	

}
