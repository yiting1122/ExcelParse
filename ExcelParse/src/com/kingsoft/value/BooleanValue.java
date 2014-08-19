package com.kingsoft.value;

public class BooleanValue implements Value{
	private boolean _value;
	
	public BooleanValue(boolean _value){
		this._value=_value;
	}
	
	@Override
	public byte getType() {
		return ValueType.CELL_TYPE_BOOLEAN;
	}

	public boolean get_value() {
		return _value;
	}

	public void set_value(boolean _value) {
		this._value = _value;
	}

	
	

}
