package ${header.package};

public class ${header.name?cap_first} {

	<#list properties as property>
	private ${property.type} ${property.name};
	</#list>
	
	<#list properties as property>
	public ${property.type} get${property.name?cap_first}() {
		return ${property.name};
	}
	
	public void set${property.name?cap_first}(${property.type} ${property.name}) {
		this.${property.name} = ${property.name};
	}
	
	</#list>
}