package com.zz.fusion.core.target;

import java.io.OutputStreamWriter;
import java.io.Writer;

import com.zz.fusion.core.Target;

public class InputTarget implements Target {	
	
	public InputTarget(){
		
	}
	
	@Override
	public void setTarget(String targetFilePath, String targetFileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTarget(String targetFilePath, String targetFileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Writer getWriter() {
		Writer out = new OutputStreamWriter(System.out);
		return out;
	}
}
