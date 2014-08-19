package com.kingsoft.parse;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.SAXException;


import com.kingsoft.handler.SheetStyleHandler;
import com.kingsoft.stream.SheetStyle;

public class SheetStyleParse extends Parse {
	private SheetStyle sheetStyle;
	public SheetStyleParse(InputStream stream,SheetStyle sheetStyle) {
		super(stream);
		this.sheetStyle=sheetStyle;
	}

	@Override
	public void handle() {
		extractData();
	}
	
	private void extractData() {
		handler = new SheetStyleHandler(sheetStyle);
		try {
			parser.parse(stream, handler);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
