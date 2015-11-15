package com.zz.fusion.core;

//import com.zz.fusion.core.hibernate.HibernateCompiler;
//import com.zz.fusion.core.hibernate.HibernateTemplateFactory;
import com.zz.fusion.core.Compilable;


public class Configuration {
	
	TemplateFactory templateFactory;
	Compilable compiler;
	String compileType;
	
	public void configure(){		
//default setting of
//1. The flow of compiling
//2. The path of template and target
	}
	
	public void configure(String configFilePath){
		
	}
	
	
	
	public String getCompileType() {
		return compileType;
	}

	public void setCompileType(String compileType) {
		this.compileType = compileType;
	}
	
//	public TemplateFactory buildTemplateFactory(){
//		switch(compileType){
//			case "Hibernate": templateFactory = new HibernateTemplateFactory();
//			case "Structs": templateFactory = new HibernateTemplateFactory();
//		}
//		return templateFactory;
//	}
//	
//	public Compilable buildCompiler(){
//		switch(compileType){
//			case "Hibernate": compiler = new HibernateCompiler();
//			case "Structs": compiler = new HibernateCompiler();
//		}
//		
//		return compiler;
//	}

	public TemplateFactory buildTemplateFactory(String compileType){
		String packageName = "com.zz.fusion.core.";
		String fullClassName = null;
		
		fullClassName = packageName + compileType.toLowerCase() + "." + compileType + "TemplateFactory";
		
		try {
			Class clazz = Class.forName(fullClassName);
			templateFactory = (TemplateFactory) clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println("[Error]: Failed to find class "+e.getMessage());
			compiler = null;
			e.printStackTrace();
		}
		
		return templateFactory;
	}
	
	public Compilable buildCompiler(String compileType){
		
		String packageName = "com.zz.fusion.core.";
		String fullClassName = null;
		
		fullClassName = packageName + compileType.toLowerCase() + "." + compileType + "Compiler";
		
		try {
			Class clazz = Class.forName(fullClassName);
			compiler = (Compilable) clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("[Error]: Failed to find compiler class "+e.getMessage());
			compiler = null;
			e.printStackTrace();
		}
		
		return compiler;
	}
	
}
