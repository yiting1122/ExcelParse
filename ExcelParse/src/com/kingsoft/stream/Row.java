package com.kingsoft.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.carrotsearch.hppc.ObjectArrayList;

public class Row {
	//行号
	private int id;
//	private List<Cell> cellsList;
	private ObjectArrayList<Cell>cellsList;
	private static final int DEFAULT_SIZE=10;
	public Row(){
		this(DEFAULT_SIZE);
	}
	public Row(int initSize){
//		cellsList=new ArrayList<Cell>(initSize);
		cellsList=new ObjectArrayList<Cell>(initSize);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public List<Cell> getCellsList() {
//		return cellsList;
//	}
//
//	public void setCellsList(List<Cell> cellsList) {
//		this.cellsList = cellsList;
//	}
	

	public ObjectArrayList<Cell> getCellsList() {
		return cellsList;
	}
	public void setCellsList(ObjectArrayList<Cell> cellsList) {
		this.cellsList = cellsList;
	}
	



	@Override
	public String toString() {
		return "Row [id=" + id +  ", cellMap=" + cellsList
				+ "]";
	}


	public Cell getCell(short column){
		
		if(column<0||column>Short.MAX_VALUE){
			throw new IndexOutOfBoundsException("column is out of BoundsException : "+column );
		}
		else if(column>cellsList.size()-1){
			return null;
		}
		return cellsList.get(column);
	}
	
	public short getCellIndex(Cell cell){
		for(int i=0;i<cellsList.size();i++){
			if(cellsList.get(i)==cell){
				return (short) i;
			}
		}
		return -1;
	}
	
	public void addCell(Cell cell){
		cellsList.add(cell);
	}
	
	public void updateCell(short column,Cell cell){
		if(column<0||column>cellsList.size()-1){
			throw new IndexOutOfBoundsException("column out of boundsException :"+column);
		}
		cellsList.set(column, cell);
	}
	
//	public boolean removeCell(Cell cell){
//		boolean ret=false;
//		if(cell!=null){
//			ret=cellsList.remove(cell);
//		}
//		return ret;
//	}
	
	public Cell removeCell(int pos){
		Cell cell=cellsList.remove(pos);
		return cell;
	}
	
	public int getCellsListSize(){
		return cellsList.size();
	}
	
	
	
	
}
