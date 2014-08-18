package com.kingsoft.stream;

import java.util.Iterator;
import java.util.List;



public class Sheet implements Iterable{
	private String name;
	private String rid;
	private String sheetId;
	//sheet的位置信息
	private float footer;
	private float header;
	private float bottom;
	private float top;
	private float right;
	private float left;
	//sheet中文字所在的区域（操作区域）
	private String dimension; 
	//defaultRowHeight
	private String RowHeight;
	//sheetview:selection  当前sheet选中的cell
	private String activeCell;
	
	private List<Row> rows;
	private WorkBook workBook;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getSheetId() {
		return sheetId;
	}

	public void setSheetId(String sheetId) {
		this.sheetId = sheetId;
	}

	public float getFooter() {
		return footer;
	}

	public void setFooter(float footer) {
		this.footer = footer;
	}

	public float getHeader() {
		return header;
	}

	public void setHeader(float header) {
		this.header = header;
	}

	public float getBottom() {
		return bottom;
	}

	public void setBottom(float bottom) {
		this.bottom = bottom;
	}

	public float getTop() {
		return top;
	}

	public void setTop(float top) {
		this.top = top;
	}

	public float getRight() {
		return right;
	}

	public void setRight(float right) {
		this.right = right;
	}

	public float getLeft() {
		return left;
	}

	public void setLeft(float left) {
		this.left = left;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getRowHeight() {
		return RowHeight;
	}

	public void setRowHeight(String rowHeight) {
		RowHeight = rowHeight;
	}

	public String getActiveCell() {
		return activeCell;
	}

	public void setActiveCell(String activeCell) {
		this.activeCell = activeCell;
	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	public WorkBook getWorkBook() {
		return workBook;
	}

	public void setWorkBook(WorkBook workBook) {
		this.workBook = workBook;
	}

	@Override
	public Iterator iterator() {
		return null;
	}
	
	
	
}
