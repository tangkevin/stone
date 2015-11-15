package com.zz.fusion.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zz.fusion.core.hibernate.HibernateCompiler;

import freemarker.template.TemplateException;

public class Processor {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	public static void main(String[] args) throws IOException, TemplateException {
		
		
		Map<String, Object> root = new HashMap<String, Object>();
		Map<String, String> header = new HashMap<String, String>();
		List<Map<String, String>> properties = new ArrayList<Map<String, String>>();
			
		root.put("header", header);
		root.put("properties", properties);
		
		header.put("name", "domain");
		header.put("package", "com.ds.deploy");
		
		Map<String, String> property1 = new HashMap<String, String>();
		property1.put("name", "id");
		property1.put("type", "String");
		properties.add(property1);
		
		Map<String, String> property2 = new HashMap<String, String>();
		property2.put("name", "desc");
		property2.put("type", "String");
		properties.add(property2);
				
		Configuration cfg = new Configuration();
		Compilable compiler = cfg.buildCompiler("Hibernate");
		compiler.compile(root);
		
		compiler = cfg.buildCompiler("Struts");
		compiler.compile(root);

	}
	
	public void addStep(){
		
	}
	
	public void excecute(){
		
	}
}
