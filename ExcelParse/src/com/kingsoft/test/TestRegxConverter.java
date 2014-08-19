package com.kingsoft.test;


import com.kingsoft.util.RegxConvertor;

import junit.framework.TestCase;

public class TestRegxConverter extends TestCase {
	
	public void testGetColumnNumber(){
		System.out.println(RegxConvertor.getColumnNumber("A"));
		System.out.println(RegxConvertor.getColumnNumber("AA"));
		System.out.println(RegxConvertor.getColumnNumber("AAA"));
		System.out.println(RegxConvertor.getColumnNumber("AAAA"));

	}
	
	
	public void testGetColumnChar(){
		System.out.println(RegxConvertor.getColumnChar(0));
		System.out.println(RegxConvertor.getColumnChar(25));
		System.out.println(RegxConvertor.getColumnChar(701));
		System.out.println(RegxConvertor.getColumnChar(702));
		System.out.println(RegxConvertor.getColumnChar(18277));
		System.out.println(RegxConvertor.getColumnChar(18278));
		
		System.out.println('A'+0);

	}
	
	
	public void testCellPos(){
		System.out.println(RegxConvertor.getCellPos("A1"));
		System.out.println(RegxConvertor.getCellPos("B1"));
		System.out.println(RegxConvertor.getCellPos("C1"));
		System.out.println(RegxConvertor.getCellPos("A2"));
		
		System.out.println(RegxConvertor.getRowSize("1:8"));
	}
	
	

	
}
