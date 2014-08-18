package com.kingsoft.stream;

import java.util.HashMap;


public class WorkBook {
	
	
	/**
	 * <bookViews>=>bookeview 
	 */
	private int activeTab;
	private int windowHeight;
	private int windowWidth;
	private int yWindow;
	private int xWindow;
	
	/**
	 * <sheets>
	 */
	private HashMap<String, Sheet> sheets;
	
	/**
	 * <calcPr calcId>
	 */
	private String calcId;

	public WorkBook(){
		sheets=new HashMap<String, Sheet>();
	}
	
	
	public int getActiveTab() {
		return activeTab;
	}

	public void setActiveTab(int activeTab) {
		this.activeTab = activeTab;
	}

	public int getWindowHeight() {
		return windowHeight;
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


	public String getCalcId() {
		return calcId;
	}

	public void setCalcId(String calcId) {
		this.calcId = calcId;
	}
	
	
	public void addSheet(String sheetName,Sheet sheet){
		sheets.put(sheetName, sheet);
	}


	@Override
	public String toString() {
	
		return "WorkBook [activeTab=" + activeTab + ", windowHeight="
				+ windowHeight + ", windowWidth=" + windowWidth + ", yWindow="
				+ yWindow + ", xWindow=" + xWindow + ", sheet¸öÊý" + sheets.size()
				+ ", calcId=" + calcId + "]";
	}
	
	
	
}
