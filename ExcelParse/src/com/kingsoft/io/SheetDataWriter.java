package com.kingsoft.io;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.kingsoft.stream.Cell;
import com.kingsoft.stream.Row;
import com.kingsoft.stream.Sheet;
import com.kingsoft.util.RegxConvertor;
import com.kingsoft.value.BooleanValue;
import com.kingsoft.value.ErrorValue;
import com.kingsoft.value.FormulaValue;
import com.kingsoft.value.NumericValue;
import com.kingsoft.value.StringValue;
import com.kingsoft.value.Value;
import com.kingsoft.value.ValueType;

public class SheetDataWriter extends BaseWriter {

	private SharedStringWriter sharedStringOut;

	public SheetDataWriter(String sheetFilePath, String sharedStringPath) {
		super(sheetFilePath);
		sharedStringOut = new SharedStringWriter(sharedStringPath);

	}

	public void writeSheet(Sheet sheet) throws IOException {
		TreeMap<Integer, Row> map = sheet.getRowMap();
		Iterator<Map.Entry<Integer, Row>> iterator = map.entrySet().iterator();
		System.out.print(map.size());
		int rowNum;
		while (iterator.hasNext()) {
			Map.Entry<Integer, Row> row = iterator.next();
			rowNum = row.getKey();
			writeRow(rowNum, row.getValue());
		}
	}

	public void writeRow(int rowNum, Row row) throws IOException {
		writeBeginRow(rowNum, row);
		//<"改写">
//		for (Cell cell : row.getCellsList()) {
//			if (cell.getValue() != null) {
//				writeCell(cell, rowNum);
//			}
//		}
		writeEndRow();
	}

	private void writeBeginRow(int rowNum, Row row) throws IOException {
		out.write("<row r=\"" + rowNum + "\"");
	
		// �˴���Ӹ������
		out.write(">\n");
	}

	private void writeCell(Cell cell, int rowNum) throws IOException {

//			String column = RegxConvertor.getColumnChar(cell.getColumn())
//					+ (rowNum + 1);
//			out.write("<c r=\"" + column + "\"");

			switch (cell.getValue().getType()) {
			case ValueType.CELL_TYPE_BOOLEAN:
				out.write(" t=\"" + ValueType.CELL_BOOLEAN + "\">");
				break;
			case ValueType.CELL_TYPE_FORMULA:
				out.write(" t=\"" + ValueType.CELL_FORMULA + "\">");
				break;
			case ValueType.CELL_TYPE_NUMERIC:
				out.write(" t=\"" + ValueType.CELL_NUMERIC + "\">");
				break;
			case ValueType.CELL_TYPE_STRING:
				out.write(" t=\"" + ValueType.CELL_STRING + "\">");
				break;
			case ValueType.CELL_TYPE_ERROR:
				out.write(" t=\"" + ValueType.CELL_ERROR + "\">");
				break;
			default:
				break;
			}

			out.write("\n");
			out.write("<v>");
			writeValue(cell.getValue());
			out.write("</v>\n");
			out.write("</c>");
			out.write("\n");

	}

	private void writeValue(Value value) throws IOException {
		if (value instanceof BooleanValue) {
			if (((BooleanValue) value).get_value() == true) {
				out.write("1");
			} else {
				out.write("0");
			}
		} else if (value instanceof NumericValue) {
			out.write(String.valueOf(((NumericValue) value).get_value()));
		} else if (value instanceof FormulaValue) {
			out.write(((FormulaValue) value).get_value());
		} else if (value instanceof StringValue) {
			int pos = sharedStringOut.getPos();
			out.write(String.valueOf(pos));
			System.out.println("pos :" + pos);
			sharedStringOut
					.writeSharedString(((StringValue) value).get_value());
		} else if (value instanceof ErrorValue) {
			out.write(((ErrorValue) value).get_value());
		}
	}

	private void writeEndRow() throws IOException {
		out.write("</row>\n");
	}

	@Override
	public void close() {
		sharedStringOut.close();
		super.close();
	}

}
