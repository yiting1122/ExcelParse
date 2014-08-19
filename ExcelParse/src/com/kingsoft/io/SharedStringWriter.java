package com.kingsoft.io;

import java.io.IOException;

public class SharedStringWriter extends BaseWriter{
	private int pos=0;

	public SharedStringWriter(String filePath) {
		super(filePath);
	}
		
	
	public void writeSharedString(String value) throws IOException{
		out.write("<si>\n");
		out.write("<t>");
		out.write(value);
		out.write("</t>\n");
		out.write("</si>\n");
		pos++;
	}


	public int getPos() {
		return pos;
	}
	

}
