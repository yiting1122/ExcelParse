package com.kingsoft.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public abstract class BaseWriter {
	public File fd;
	public Writer out;
	public BaseWriter(String filePath) {
		fd = createTempFile(filePath);
		out = createWrite(fd);
	}

	private File createTempFile(String filePath) {
		// File file=null;
		// try {
		// file=File.createTempFile(prefix, suffix);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// return file;
		File file = new File(filePath);
		return file;
	}

	private Writer createWrite(File fd) {
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(fd));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer;
	}

	public File getTempFile() {
		return fd;
	}

	public void close() {
		try {
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

	
	
	

}
