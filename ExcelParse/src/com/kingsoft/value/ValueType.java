package com.kingsoft.value;

public final class ValueType {
	//value类型存储的实际值
	public final static byte CELL_TYPE_NUMERIC = 0;
	public final static byte CELL_TYPE_STRING = 1;
	public final static byte CELL_TYPE_FORMULA = 2;
	public final static byte CELL_TYPE_BOOLEAN = 3;
	public final static byte CELL_TYPE_ERROR = 4;

	// value 类型（xml中的类型表示）
	public final static String CELL_BOOLEAN = "b";
	public final static String CELL_STRING = "s";
	public final static String CELL_NUMERIC = "n";
	public final static String CELL_FORMULA = "f";
	public final static String CELL_ERROR = "e";
	public final static String CELL_NULL=null;
}
