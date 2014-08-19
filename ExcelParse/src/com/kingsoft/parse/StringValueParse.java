package com.kingsoft.parse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.xml.sax.SAXException;

import com.carrotsearch.hppc.ObjectArrayList;
import com.kingsoft.handler.SheetHandler;
import com.kingsoft.handler.StringValueHandler;
import com.kingsoft.stream.Cell;
import com.kingsoft.stream.Row;
import com.kingsoft.stream.Sheet;
import com.kingsoft.stream.WorkBook;
import com.kingsoft.util.FileUtil;
import com.kingsoft.value.StringValue;
import com.kingsoft.value.Value;
import com.kingsoft.value.ValueType;


public class StringValueParse extends Parse{
	private List<String> valueList;
	private WorkBook workBook;
	public StringValueParse(InputStream stream,WorkBook workBook) {
		super(stream);
		this.workBook=workBook;
		valueList=new ArrayList<String>();
	}

	@Override
	public void handle() {
		extractData();
		if(valueList!=null&&valueList.size()>0){
			HashMap<String, Sheet> sheetsMap = workBook.getSheets();
			Iterator iter = sheetsMap.keySet().iterator();
			while (iter.hasNext()) {
				Sheet sheet=sheetsMap.get(iter.next());
				TreeMap<Integer, Row> rowMap=sheet.getRowMap();
				Iterator rowiIterator = rowMap.keySet().iterator();
				while (rowiIterator.hasNext()) {
					Row row=rowMap.get(rowiIterator.next());
//					List<Cell> cells=row.getCellsList();
//					for(Cell c:cells){
					
					ObjectArrayList<Cell> cells=row.getCellsList();
					for(int i=0;i<cells.size();i++){
						Cell c=cells.get(i);
						if((c!=null)&&(c.getValue()!=null)&&(c.getValue().getType()==ValueType.CELL_TYPE_STRING)){
							StringValue value=(StringValue) c.getValue();
							value.set_value((valueList.get(Integer.parseInt(value.get_value()))));
							c.setValue(value);
						}
					}
				}
			}
		}
	}
	private void extractData() {
		handler=new StringValueHandler(valueList);
		try {
			parser.parse(stream, handler);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
