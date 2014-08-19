package com.kingsoft.parse;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.xml.sax.SAXException;

import com.kingsoft.handler.SheetHandler;
import com.kingsoft.handler.WorkBookHandler;
import com.kingsoft.stream.Sheet;
import com.kingsoft.stream.WorkBook;

public class SheetParse extends Parse {
	private Sheet sheet;

	private SheetParse(InputStream stream) {
		super(stream);
	}

	public SheetParse(InputStream stream, Sheet sheet) {
		this(stream);
		this.sheet = sheet;
	}

	@Override
	public void handle() {
		extractData();

	}

	private void extractData() {
		handler = new SheetHandler(sheet);
		try {
			parser.parse(stream, handler);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
