package com.zz.fusion.core;

import java.io.Writer;

public interface Target {
	public void setTarget(String targetFilePath, String targetFileName);
	public String getTarget(String targetFilePath, String targetFileName);
	public Writer getWriter();
}
