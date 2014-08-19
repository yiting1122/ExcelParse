package com.kingsoft.value;

public class ValueFactory {
	private static ValueFactory factory = new ValueFactory();

	private ValueFactory() {
	}

	public static ValueFactory getInstance() {
		return factory;
	}

	public Value newCellValue(String cellType) {
		Value value=null;
		if (ValueType.CELL_BOOLEAN.equals(cellType)) {
			value = new BooleanValue(false);
		} else if (ValueType.CELL_FORMULA.equals(cellType)) {
			value = new FormulaValue();
		} else if (ValueType.CELL_NUMERIC.equals(cellType)) {
			value = new NumericValue();
		} else if (ValueType.CELL_STRING.equals(cellType)) {
			value = new StringValue();
		}else if(ValueType.CELL_ERROR.equals(cellType)){
			value=new ErrorValue();
		}
		
//		else {
//			System.out.println("error cellType :"+cellType);
//			throw new NoClassDefFoundError("this is not a corret type :"+cellType);
//		}
		return value;
	}

}
