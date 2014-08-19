package com.kingsoft.handler;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.kingsoft.log.ExcelLogger;
import com.kingsoft.log.ExcelLoggerTest;

import com.kingsoft.stream.Cell;
import com.kingsoft.stream.Row;
import com.kingsoft.stream.Sheet;
import com.kingsoft.usermodel.CellStyle;
import com.kingsoft.util.RegxConvertor;
import com.kingsoft.value.BooleanValue;
import com.kingsoft.value.ErrorValue;
import com.kingsoft.value.FormulaValue;
import com.kingsoft.value.NumericValue;
import com.kingsoft.value.StringValue;
import com.kingsoft.value.Value;
import com.kingsoft.value.ValueFactory;
import com.kingsoft.value.ValueType;

public class SheetHandler extends DefaultHandler {
	private static final String DIMENSION = "dimension";
	private static final String REF = "ref";
	// private static final String SHEETVIEW = "sheetView";
	// private static final String SHEETDATA = "sheetData";
	private static final String SELECTION = "selection";
	private static final String ACTIVECELL = "activeCell";
	private static final String SHEETFORMATPR = "sheetFormatPr";
	private static final String DEFAULTROWHEIGHT = "defaultRowHeight";
	private static final String ROW = "row";
	private static final String R = "r";
	private static final String SPANS = "spans";
	private static final String C = "c";
	private static final String T = "t";
	private static final String S = "s";
	private static final String V = "v";
	private static final String PAGEMARGINS = "pageMargins";
	private static final String FOOTER = "footer";
	private static final String HEADER = "header";
	private static final String BOTTOM = "bottom";
	private static final String TOP = "top";
	private static final String RIGHT = "right";
	private static final String LEFT = "left";
	
	private static final byte ROW_VALUE=0;
	private static final byte C_VALUE=1;
	private static final byte V_VALUE=2;
	private static final byte DIMENSION_VALUE=3;
	private static final byte SELCTION_VALUE=4;
	private static final byte SHEETFORMATPR_VALUE=5;
	private static final byte PAGEMARGINS_VALUE=6;

	private Sheet sheet;
	private Row row;
	private Cell cell;
	private Value value;
	private String preTag;
	private int column;
	private ExcelLogger logger = (ExcelLogger) ExcelLogger
			.getLogger("com.kingsoft");
	private HashMap<String, Byte> tableMap;

	public SheetHandler(Sheet sheet) {
		this.sheet = sheet;
		initHashMap();
	}

	private void initHashMap() {
		tableMap = new HashMap<String, Byte>(7);
		tableMap.put(ROW, ROW_VALUE);
		tableMap.put(C, C_VALUE);
		tableMap.put(V, (byte) V_VALUE);
		tableMap.put(DIMENSION, DIMENSION_VALUE);
		tableMap.put(SELECTION, SELCTION_VALUE);
		tableMap.put(SHEETFORMATPR, SHEETFORMATPR_VALUE);
		tableMap.put(PAGEMARGINS, PAGEMARGINS_VALUE);
	}

	@Override
	public void startElement(String namespaceURI, String localName,
			String fullName, Attributes attributes) throws SAXException {
		if(!tableMap.containsKey(fullName)){
			return;
		}
		int tableValue = tableMap.get(fullName);
		switch (tableValue) {
		case ROW_VALUE:
			if (attributes.getValue(SPANS) != null) {
				String spans = attributes.getValue(SPANS);
				row = new Row(RegxConvertor.getRowSize(spans));
			} else {
				row = new Row();
			}
			row.setId(Integer.parseInt(attributes.getValue(R)) - 1);
			break;
		case C_VALUE:
			cell = new Cell();
			column = RegxConvertor.getColumnNumber(attributes.getValue(R));
			String cellType = attributes.getValue(T) == null ? ValueType.CELL_NUMERIC
					: attributes.getValue(T);
			value = ValueFactory.getInstance().newCellValue(cellType);
			if (attributes.getValue(S) != null) {
				sheet.addStyle(attributes.getValue(R),
						Integer.parseInt(attributes.getValue(S)));
			}
			break;
		case V_VALUE:
			preTag = V;
			break;
		case DIMENSION_VALUE:
			sheet.setDimension(attributes.getValue(REF));
			break;
		case SELCTION_VALUE:
			sheet.setActiveCell(attributes.getValue(ACTIVECELL));
			break;
		case SHEETFORMATPR_VALUE:
			sheet.setRowHeight(Float.parseFloat(attributes
					.getValue(DEFAULTROWHEIGHT)));
			break;
		case PAGEMARGINS_VALUE:
			sheet.setHeader(Float.parseFloat(attributes.getValue(HEADER)));
			sheet.setTop(Float.parseFloat(attributes.getValue(TOP)));
			sheet.setRight(Float.parseFloat(attributes.getValue(RIGHT)));
			sheet.setLeft(Float.parseFloat(attributes.getValue(LEFT)));
			sheet.setBottom(Float.parseFloat(attributes.getValue(BOTTOM)));
			sheet.setFooter(Float.parseFloat(attributes.getValue(FOOTER)));
			break;

		default:
			break;
		}

//		if (DIMENSION.equals(fullName)) {
//			sheet.setDimension(attributes.getValue(REF));
//
//		} else if (SELECTION.equals(fullName)) {
//			sheet.setActiveCell(attributes.getValue(ACTIVECELL));
//		} else if (SHEETFORMATPR.equals(fullName)) {
//			sheet.setRowHeight(Float.parseFloat(attributes
//					.getValue(DEFAULTROWHEIGHT)));
//
//		} else if (ROW.equals(fullName)) {
//			if (attributes.getValue(SPANS) != null) {
//				String spans = attributes.getValue(SPANS);
//				row = new Row(RegxConvertor.getRowSize(spans));
//			} else {
//				row = new Row();
//			}
//
//			row.setId(Integer.parseInt(attributes.getValue(R)) - 1);
//		} else if (C.equals(fullName)) {
//			cell = new Cell();
//			column = RegxConvertor.getColumnNumber(attributes.getValue(R));
//			String cellType = attributes.getValue(T) == null ? ValueType.CELL_NUMERIC
//					: attributes.getValue(T);
//			value = ValueFactory.getInstance().newCellValue(cellType);
//			if (attributes.getValue(S) != null) {
//				sheet.addStyle(attributes.getValue(R),
//						Integer.parseInt(attributes.getValue(S)));
//			}
//
//		} else if (V.equals(fullName)) {
//			preTag = V;
//		} else if (PAGEMARGINS.equals(fullName)) {
//			sheet.setHeader(Float.parseFloat(attributes.getValue(HEADER)));
//			sheet.setTop(Float.parseFloat(attributes.getValue(TOP)));
//			sheet.setRight(Float.parseFloat(attributes.getValue(RIGHT)));
//			sheet.setLeft(Float.parseFloat(attributes.getValue(LEFT)));
//			sheet.setBottom(Float.parseFloat(attributes.getValue(BOTTOM)));
//			sheet.setFooter(Float.parseFloat(attributes.getValue(FOOTER)));
//
//		}

	}

	@Override
	public void endElement(String namespaceURI, String localName,
			String fullName) throws SAXException {
		if (ROW.equals(fullName.toLowerCase()) && row != null) {
			sheet.addRow(row.getId(), row);

		}

	}

	@Override
	public void characters(char[] chars, int start, int length)
			throws SAXException {
		if (V.equals(preTag)) {
			String ret = new String(chars, start, length);
			if (value instanceof StringValue) {
				((StringValue) value).set_value(ret);
			} else if (value instanceof NumericValue) {
				((NumericValue) value).set_value(Double.parseDouble(ret));
			} else if (value instanceof FormulaValue) {
				((FormulaValue) value).set_value(ret);
			} else if (value instanceof BooleanValue) {
				if ("1".equals(ret)) {
					((BooleanValue) value).set_value(true);
				}
			} else if (value instanceof ErrorValue) {
				((ErrorValue) value).set_value(ret);
			}
			cell.setValue(value);
			for (int i = row.getCellsListSize(); i < column; i++) {
				row.addCell(null); //
			}
			row.addCell(cell);
			preTag = null;
			value = null;
		}
	}

	@Override
	public void warning(SAXParseException exception) {

		System.out.println("*******WARNING******");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("********************");
		logger.warn(SheetHandler.class.getName(), exception.getLineNumber()
				+ exception.getMessage());
	}

	public void error(SAXParseException exception) throws SAXException {
		System.out.println("******* ERROR ******");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("********************");
		logger.error(SheetHandler.class.getName(), exception.getLineNumber()
				+ exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("******** FATAL ERROR ********");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("*****************************");
		logger.error(SheetHandler.class.getName(), exception.getLineNumber()
				+ exception.getMessage());
	}

}
