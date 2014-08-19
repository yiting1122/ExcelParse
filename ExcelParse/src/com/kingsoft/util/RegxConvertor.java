package com.kingsoft.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//�е�ת��  ����  A=��1��ת��  ͬ��Ҳ����27=��AA��ת��

public class RegxConvertor {
	public static short getColumnNumber(String pos) {
		String regEx = "[^A-Z]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(pos);
		String temp = m.replaceAll("").trim();
		int ret = 0;
		char[] array = temp.toCharArray();
		for (int i = 0; i < array.length; i++) {
			int value = (array[i] - 'A' + 1);
			ret = ret * 26 + value;
		}
		ret--;
		return Short.parseShort(String.valueOf(ret));
	}

	public static String getColumnChar(int pos) {
		pos++;
		StringBuffer buffer = new StringBuffer();

		while (true) {
			char temp;
			int ret = pos % 26;
			if (ret == 0) {
				ret = 25;
				temp = (char) ('A' + ret );
			}else {
				temp = (char) ('A' + ret - 1);
			}
			pos = (pos - ret) / 26;

			
			buffer.append(temp);
			if (pos <= 0) {
				break;
			}
		}
		return buffer.reverse().toString();
	}

	
	public static short getRowNumber(String pos) {
		String regEx = "[A-Z]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(pos);
		String temp = m.replaceAll("").trim();
		return Short.parseShort(temp);
	}
	

	public static int getCellPos(String pos){
		int rowNum=getRowNumber(pos);
		int colNum=getColumnNumber(pos);
		return (rowNum-1)+colNum;
	}
	
	public static int getRowSize(String spans){
		if(spans==null){
			throw new IllegalArgumentException("spans cannot be null");
		}
		String[] contents=spans.split(":");
		return Integer.parseInt(contents[1])-Integer.parseInt(contents[0])+1;
	}
	
	
	
//	public static int getInt(String dimension){
//		String[] contents=dimension.split(":");
//		for(int i=0;i<contents.length;i++){
//			String regEx = "[A-Z]";
//			Pattern p = Pattern.compile(regEx);
//			Matcher m = p.matcher(contents[i]);
//			contents[i]= m.replaceAll("").trim();
//		}
//		
//		return Integer.parseInt(contents[1])-Integer.parseInt(contents[0]);
//	}
	

}
