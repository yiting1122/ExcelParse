package com.kingsoft.stream;

import java.util.List;

public class Row {
	//行号
	private int rowNumber;
	//行的占位
	private String spans;
	
	private Sheet sheet;
	
	private  WorkBook workBook;
	
	List<Cell> cells;

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getSpans() {
		return spans;
	}

	public void setSpans(String spans) {
		this.spans = spans;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public WorkBook getWorkBook() {
		return workBook;
	}

	public void setWorkBook(WorkBook workBook) {
		this.workBook = workBook;
	}

	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}
	
	
	
	
}
