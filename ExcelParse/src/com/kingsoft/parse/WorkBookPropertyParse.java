package com.kingsoft.parse;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.xml.sax.SAXException;

import com.kingsoft.handler.SheetHandler;
import com.kingsoft.handler.WorkBookHandler;
import com.kingsoft.handler.WorkBookPropertyHandler;
import com.kingsoft.stream.Sheet;
import com.kingsoft.stream.WorkBook;

public class WorkBookPropertyParse extends Parse {
	private WorkBook workBook;

	private WorkBookPropertyParse(InputStream stream) {
		super(stream);
	}

	public WorkBookPropertyParse(InputStream stream, WorkBook workBook) {
		this(stream);
		this.workBook=workBook;
	}

	@Override
	public void handle() {
		extractData();

	}

	private void extractData() {
		handler = new WorkBookPropertyHandler(workBook);
		try {
			parser.parse(stream, handler);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
