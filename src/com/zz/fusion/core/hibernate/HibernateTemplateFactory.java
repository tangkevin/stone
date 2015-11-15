package com.zz.fusion.core.hibernate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.zz.fusion.core.TemplateFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class HibernateTemplateFactory implements TemplateFactory{
	
	private Configuration cfg = null;
	private Template template = null;
	private String templateRelativePath;
	
	public HibernateTemplateFactory(){
		
		this.templateRelativePath = "src/com/zz/fusion/core/hibernate";
		
		try {
			cfg = new Configuration();
			cfg.setDirectoryForTemplateLoading(new File(templateRelativePath));
		} catch (IOException e) {
			System.out.println("[Error]:HibernateTemplateFactory.java is failed to create freemarker config");
			e.printStackTrace();
		}
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}
	
	public Template buildTemplate(String templateName) throws IOException{
		template = cfg.getTemplate(templateName);
		return template;
	}

	public List<Template> buildTemplates() throws IOException{
		List<Template> templateList = new ArrayList<Template>();
		
		File directory = new File(templateRelativePath);
		File[] fileArray = directory.listFiles();
		
		for(int i = 0; i<fileArray.length; i++ ){
			int j = fileArray[i].toString().lastIndexOf(".");
			if(j > 0){
				String extension = fileArray[i].toString().substring(j+1);
				if (extension.equals("ftl")){
					template = cfg.getTemplate(fileArray[i].getName());
					templateList.add(template);
				}
			}
		}
		return templateList;
	}

	public void setTemplateRelativePath(String templateRelativePath) {
		this.templateRelativePath = templateRelativePath;
	}
}
