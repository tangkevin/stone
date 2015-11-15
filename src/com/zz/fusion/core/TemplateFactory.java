package com.zz.fusion.core;

import java.util.List;
import java.io.IOException;

import freemarker.template.Template;

public interface TemplateFactory {
	
	public Template buildTemplate(String templateName) throws IOException;

	public List<Template> buildTemplates() throws IOException;

}
