package com.kingsoft.parse;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.SAXException;

import com.kingsoft.handler.WorkBookHandler;
import com.kingsoft.stream.WorkBook;

public class WorkBookParse extends Parse {

	private WorkBook workBook;

	private WorkBookParse(InputStream stream) {
		super(stream);
		// TODO Auto-generated constructor stub
	}
	
	public WorkBookParse(InputStream stream,WorkBook workBook){
		this(stream);
		this.workBook=workBook;
	}

	@Override
	public void handle() {
		// TODO Auto-generated method stub
		extractData(workBook);
	}

	private void extractData(WorkBook workBook) {
		handler = new WorkBookHandler(workBook);
		try {
			parser.parse(stream, handler);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
