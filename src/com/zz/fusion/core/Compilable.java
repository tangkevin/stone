package com.zz.fusion.core;

import java.io.IOException;

import com.zz.fusion.core.target.FileTarget;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public interface Compilable {
	public void compile(Object model) throws TemplateException, IOException;
}
