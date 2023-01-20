package com.OFOS.generic;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String readDataFromPropertyFile(String Key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(IPathConstantUtility.filepath);
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(Key);
		return data;
	}

}
