package com.zz.fusion.core.hibernate;

//import java.io.File;
import java.io.IOException;
import java.util.List;

import com.zz.fusion.core.Compilable;
import com.zz.fusion.core.Target;
import com.zz.fusion.core.TemplateFactory;
import com.zz.fusion.core.target.*;

//import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
//import freemarker.template.TemplateExceptionHandler;

public class HibernateCompiler implements Compilable {

//	private Template template;
//
//	public void setTemplate(String templateName) throws IOException{
//		Configuration cfg = new Configuration();
//		cfg.setDirectoryForTemplateLoading(new File("src/com/zz/fusion/template"));
//		cfg.setDefaultEncoding("UTF-8");
//		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//		template = cfg.getTemplate(templateName);
//	}
	
	public void compile(Object model) throws TemplateException, IOException{
		System.out.println("[HibernateCompiler]:Start");
		com.zz.fusion.core.Configuration cfg = new com.zz.fusion.core.Configuration();
		TemplateFactory tfc = cfg.buildTemplateFactory("Hibernate");

		List<Template> templates = tfc.buildTemplates();
		System.out.println("[Template]:Size:"+templates.size());
		
		for(int i = 0; i<templates.size(); i++ ){
			Target target = new FileTarget();
			Template template = (Template)templates.get(i);
			System.out.println("[Template]:"+template.getName());
			
			int j = template.getName().lastIndexOf("."); 
			if (j>0){
				//create directory using the relative path, and file name as the same as it's template name
				target.setTarget("src/com/ds/deploy", template.getName().substring(0, j));
			}
			System.out.println("[Model]:"+model);
			template.process(model, target.getWriter());
			System.out.println("[HibernateCompiler]: Fused Successfully");
		}
	}
}
