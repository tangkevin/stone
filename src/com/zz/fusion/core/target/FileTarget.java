package com.zz.fusion.core.target;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.zz.fusion.core.Target;

public class FileTarget implements Target{
	private String relativePath;
	private String fileName;
	private File file;
	private Writer out;
	
	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setTarget(String relativePath, String fileName) {
		this.setRelativePath(relativePath);
		this.setFileName(fileName);
		
		try {
			this.makeDirs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTarget(String targetFilePath, String targetFileName) {
		return null;
	}

	public Writer getWriter() {
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	
	public File makeDirs() throws IOException{
		File directory = new File(relativePath);
		if(!directory.exists()){
			directory.mkdirs();
			System.out.println("[Directroy created]:"+relativePath);
		}

		file = new File(relativePath + "/" +fileName);
				
		if(!file.exists()){
			try {
				file.createNewFile();
				System.out.println("[Target]:File doesn't exist and created -> "+file.getAbsolutePath());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("[Target]:File exists and updated =>> "+file.getAbsolutePath());
		}
		return file;
	}
}
