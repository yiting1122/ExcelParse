package com.kingsoft.util;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class FileUtil {
	public static ZipFile unZipFile(String filePath) {
		ZipFile xlsxFile = null;
		try {
			xlsxFile = new ZipFile(new File(filePath));
		} catch (ZipException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return xlsxFile;
	}
	
	public static InputStream getFileInputStream(ZipFile file,String filePath){
		ZipEntry entry = file.getEntry(filePath);
		InputStream stream=null;
		try {
			stream=file.getInputStream(entry);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stream;
	}
	
	public static List<String> getZipFilesPath(ZipFile file){
		List<String> filePaths=new ArrayList<String>();
		Enumeration<? extends ZipEntry> zipFile=file.entries();
		while(zipFile.hasMoreElements()){
			filePaths.add(zipFile.nextElement().getName());
		}
		return filePaths;
	}
}
