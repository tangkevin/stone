package com.zz.fusion.core;

import java.util.Map;

import freemarker.template.TemplateModel;

public class Model implements TemplateModel{
	private Map root;
	
	public Map addHash(String name, Object o){
		root.put(name, o);
		return root;
	}
	
	public Map addScalar(String name, Object o){
		root.put(name, o);
		return root;
	}
	
	public Map addSequence(String name, Object o){
		root.put(name, o);
		return root;
	}
	
	public String toString(){
		System.out.println("Root:"+root);
		String rootString = root.toString();
		return rootString;
	}
}
