package com.ds.dao;

import com.ds.domain.Domain;

public interface DomainDao {
	public void saveDomain(Domain domain);
	public Domain findDomainByName(String name);
	public Domain findDomainById(int id);
	public void updateDomain(Domain domain);
	public void remove(Domain domain);
}
