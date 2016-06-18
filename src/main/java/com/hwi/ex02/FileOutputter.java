package com.hwi.ex02;

import java.io.*;

public class FileOutputter implements Outputter{
	
	private String filePath;
	
	public void output(String message) throws IOException{
		FileWriter out = new FileWriter(filePath);
		out.write(message);
		out.close();
	}
	
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
}
