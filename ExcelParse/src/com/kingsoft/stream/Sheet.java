package com.kingsoft.stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.kingsoft.util.RegxConvertor;

public class Sheet {
	private String name;
	private String rid;
	private String sheetId;
	private float footer;
	private float header;
	private float bottom;
	private float top;
	private float right;
	private float left;
	private String dimension;
	// defaultRowHeight
	private float RowHeight;
	// sheetview:selection 当前选中节点
	private String activeCell;

	private TreeMap<Integer, Row> rowMap;
	//创建style映射边，减少cell中存储styleId，这样可以通过行列号进行查询
	private HashMap<String, Integer> styleTable;

	private WorkBook workBook;

	public Sheet() {
		rowMap = new TreeMap<Integer, Row>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int val1 = o1.intValue();
				int val2 = o2.intValue();
				return (val1 < val2 ? -1 : (val1 == val2 ? 0 : 1));
			}

		});
		styleTable = new HashMap<String, Integer>();
	}

	public void addStyle(String cellPos, int styleId) {
		if (cellPos == null) {
			return;
		}
		styleTable.put(cellPos, styleId);
	}

	public int getStyleId(String cellPos) {
		if (cellPos == null) {
			throw new NullPointerException("NullPointerException for cellPos");
		}
		return styleTable.get(cellPos);
	}

	
	public HashMap<String, Integer> getStyleTable() {
		return styleTable;
	}

	public void setStyleTable(HashMap<String, Integer> styleTable) {
		this.styleTable = styleTable;
	}

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

	public float getRowHeight() {
		return RowHeight;
	}

	public void setRowHeight(float rowHeight) {
		RowHeight = rowHeight;
	}

	public String getActiveCell() {
		return activeCell;
	}

	public void setActiveCell(String activeCell) {
		this.activeCell = activeCell;
	}

	public TreeMap<Integer, Row> getRowMap() {
		return rowMap;
	}

	public WorkBook getWorkBook() {
		return workBook;
	}

	public void setWorkBook(WorkBook workBook) {
		this.workBook = workBook;
	}

	public void addRow(int id, Row row) {
		rowMap.put(id, row);
	}

	public Row getRow(int rowNum) {
		if (rowNum < 0 || rowNum > Integer.MAX_VALUE) {
			throw new IndexOutOfBoundsException(
					"rowNum is out of Bounds Exception " + rowNum);
		}
		return rowMap.get(rowNum);
	}

	public Row getFirstRow() {
		return rowMap.size() == 0 ? null : rowMap.firstEntry().getValue();
	}

	public Row getLastRow() {
		return rowMap.size() == 0 ? null : rowMap.lastEntry().getValue();
	}

	public int getFirstNum() {
		return rowMap.size() == 0 ? 0 : rowMap.firstKey();
	}

	public int getLastNum() {
		return rowMap.size() == 0 ? 0 : rowMap.lastKey();
	}

	public void changeRowNumber(Row row, int newRowNum) {
		removeRow(row);
		rowMap.put(newRowNum, row);
	}

	public void removeRow(Row row) {
		Iterator<Map.Entry<Integer, Row>> iterator = rowMap.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getValue() == row) {
				iterator.remove();
				return;
			}
		}
	}

	public void removeRow(int rowNum) {
		if (rowNum < 0 || rowNum > Integer.MAX_VALUE) {
			throw new IndexOutOfBoundsException(
					"rowNum is out of Bounds Exception " + rowNum);
		}

		Iterator<Integer> iterator = rowMap.keySet().iterator();
		while (iterator.hasNext()) {
			if (rowNum == iterator.next().intValue()) {
				rowMap.remove(rowNum);
			}
		}
	}

	public Cell getCell(int rowNum, short column) {
		Row row = getRow(rowNum);
		if (row == null) {
			return null;
		}
		return row.getCell(column);
	}

	@Override
	public String toString() {
		return "Sheet [name=" + name + ", rid=" + rid + ", sheetId=" + sheetId
				+ ", footer=" + footer + ", header=" + header + ", bottom="
				+ bottom + ", top=" + top + ", right=" + right + ", left="
				+ left + ", dimension=" + dimension + ", RowHeight="
				+ RowHeight + ", activeCell=" + activeCell + ", rowMap="
				+ rowMap + ", styleTable size=" + styleTable.size() + ", workBook="
				+ workBook + "]";
	}

	

}
