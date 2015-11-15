package com.ds;

import com.ds.dao.DomainDao;
import com.ds.dao.impl.DomainDaoHibernateImpl;
import com.ds.domain.Domain;

public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DomainDao dao = new DomainDaoHibernateImpl();
		Domain domain = new Domain();
		
		domain.setId(1);
		domain.setDomain_name("test");
		domain.setDomain_desc("Test desc");
		dao.saveDomain(domain);
		
		domain.setDomain_desc("What the hell");
		dao.updateDomain(domain);
		
		Domain domain1 = dao.findDomainByName(domain.getDomain_name());
		dao.remove(domain1);
	}
}
