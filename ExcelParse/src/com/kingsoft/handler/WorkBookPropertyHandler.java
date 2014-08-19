package com.kingsoft.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.kingsoft.log.ExcelLogger;
import com.kingsoft.log.ExcelLoggerTest;
import com.kingsoft.stream.Sheet;
import com.kingsoft.stream.WorkBook;

public class WorkBookPropertyHandler extends DefaultHandler {
	private static final String RELATIONSHIP = "Relationship";
	private static final String TARGET = "Target";
	private static final String ID = "Id";
	private WorkBook workBook;
	private ExcelLogger logger = (ExcelLogger) ExcelLogger
			.getLogger("com.kingsoft");

	public WorkBookPropertyHandler(WorkBook workBook) {
		super();
		this.workBook = workBook;
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
		if (RELATIONSHIP.equals(fullName)) {
			String value = attributes.getValue(TARGET);
			String id = attributes.getValue(ID);		
			workBook.addTarget(id, value);
		}

	}

	@Override
	public void endElement(String namespaceURI, String localName,
			String fullName) throws SAXException {

	}

	@Override
	public void characters(char[] chars, int start, int length)
			throws SAXException {

	}

	@Override
	public void warning(SAXParseException exception) {

		System.out.println("*******WARNING******");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("********************");
		logger.warn(WorkBookPropertyHandler.class.getName(),
				exception.getLineNumber() + exception.getMessage());
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		System.out.println("******* ERROR ******");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("********************");
		logger.error(WorkBookPropertyHandler.class.getName(),
				exception.getLineNumber() + exception.getMessage());
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("******** FATAL ERROR ********");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("*****************************");
		logger.error(WorkBookPropertyHandler.class.getName(),
				exception.getLineNumber() + exception.getMessage());
	}
}
