package com.kingsoft.handler;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.kingsoft.log.ExcelLogger;


public class StringValueHandler extends DefaultHandler {
	private static final String TYPE="t";
	private String preTag=null;
	private List<String> valueList;
	private ExcelLogger logger = (ExcelLogger) ExcelLogger
			.getLogger("com.kingsoft");

	public StringValueHandler(List<String> valueList) {
		super();
		this.valueList=valueList;
	}

	@Override
	public void startDocument() throws SAXException {
	}

	@Override
	public void endDocument() throws SAXException {
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) {
	}

	@Override
	public void endPrefixMapping(String prefix) {
	}

	@Override
	public void startElement(String namespaceURI, String localName,
			String fullName, Attributes attributes) throws SAXException {
		if (TYPE.equals(fullName)) {
			preTag=TYPE;
		}

	}

	@Override
	public void endElement(String namespaceURI, String localName,
			String fullName) throws SAXException {

	}

	@Override
	public void characters(char[] chars, int start, int length)
			throws SAXException {
		if(TYPE.equals(preTag)){
			valueList.add(new String(chars,start,length));
			preTag=null;
		}

	}

	@Override
	public void warning(SAXParseException exception) {

		System.out.println("*******WARNING******");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("********************");
		logger.warn(StringValueHandler.class.getName(),
				exception.getLineNumber() + exception.getMessage());
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		System.out.println("******* ERROR ******");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("********************");
		logger.error(StringValueHandler.class.getName(),
				exception.getLineNumber() + exception.getMessage());
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("******** FATAL ERROR ********");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("*****************************");
		logger.error(StringValueHandler.class.getName(),
				exception.getLineNumber() + exception.getMessage());
	}
}
