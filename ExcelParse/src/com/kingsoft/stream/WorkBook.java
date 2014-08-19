package com.kingsoft.stream;

import java.util.HashMap;


public class WorkBook {
	
	
	
	/**
	 * <bookViews>=>bookeview 
	 */
	private byte activeTab;
	private int windowHeight;
	private int windowWidth;
	private int yWindow;
	private int xWindow;
	
	private SheetStyle sheetStyle;
	
	/**
	 * <calcPr calcId>
	 */
	private int calcId;

	
	/**
	 * <sheets>
	 */
	private HashMap<String, Sheet> sheets;
	
	private HashMap<String, String> targets;

	public WorkBook(){
		sheets=new HashMap<String, Sheet>(3); 
		targets=new HashMap<String, String>(8);
	}
		
	public short getActiveTab() {
		return activeTab;
	}



	public void setActiveTab(byte activeTab) {
		this.activeTab = activeTab;
	}

	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}

	public int getyWindow() {
		return yWindow;
	}

	public void setyWindow(int yWindow) {
		this.yWindow = yWindow;
	}

	public int getxWindow() {
		return xWindow;
	}

	public void setxWindow(int xWindow) {
		this.xWindow = xWindow;
	}

	public HashMap<String, Sheet> getSheets() {
		return sheets;
	}
	public void addSheet(String sheetName,Sheet sheet){
		sheets.put(sheetName, sheet);
	}

	public int getCalcId() {
		return calcId;
	}

	public void setCalcId(int calcId) {
		this.calcId = calcId;
	}


	public HashMap<String, String> getTargets() {
		return targets;
	}

	public void addTarget(String key,String value){
		targets.put(key,value);
	}

	public Sheet getSheet(String sheetId){
		return sheets.get(sheetId);
	}

	
	
	
	public SheetStyle getSheetStyle() {
		return sheetStyle;
	}

	public void setSheetStyle(SheetStyle sheetStyle) {
		this.sheetStyle = sheetStyle;
	}

	@Override
	public String toString() {
	
		return "WorkBook [activeTab=" + activeTab + ", windowHeight="
				+ windowHeight + ", windowWidth=" + windowWidth + ", yWindow="
				+ yWindow + ", xWindow=" + xWindow + ", sheet个数" + sheets.size()+",target个数"+targets.size()
				+ ", calcId=" + calcId + "]";
	}
	
	
	
}
