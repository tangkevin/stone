<?xml version="1.0"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
                                   "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping package="com.ds.domain">
 <class name="Domain" table="domain">
  <id name="id">
   <generator class="native"/>
  </id>
  <property generated="never" lazy="false" name="domain_name" unique="true"/>
  <property generated="never" lazy="false" name="domain_desc"/>
 </class>
</hibernate-mapping>