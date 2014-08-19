package com.kingsoft.value;

public class NumericValue implements Value{
	private double _value;
	
	@Override
	public byte getType() {
		return ValueType.CELL_TYPE_NUMERIC;
	}

	public double get_value() {
		return _value;
	}

	public void set_value(double _value) {
		this._value = _value;
	}

	
}
