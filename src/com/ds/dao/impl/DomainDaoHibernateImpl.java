package com.ds.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ds.dao.DomainDao;
import com.ds.dao.HibernateUtil;
import com.ds.domain.Domain;

public class DomainDaoHibernateImpl implements DomainDao {

	@Override
	public void saveDomain(Domain domain) {
		Session s = null; 
		Transaction tx = null;
		try{
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.save(domain);
			tx.commit();
		}finally{
			if(s !=null)
				s.close();
		}
	}

	public Domain findDomainByName(String name) {
		Session s = null;
		try{
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(Domain.class);
			c.add(Restrictions.eq("domain_name", name));
			Domain domain = (Domain) c.uniqueResult();
			return domain;
		}finally{
			if(s !=null)
				s.close();
		}
	}

	public Domain findDomainById(int id) {
		Session s = null;
		try{
			s = HibernateUtil.getSession();
			Domain domain = (Domain)s.get(Domain.class, id);
			return domain;
		}finally{
			if(s !=null)
				s.close();
		}
	}

	public void updateDomain(Domain domain) {
		Session s = null; 
		Transaction tx = null;
		try{
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.update(domain);
			tx.commit();
		}finally{
			if(s !=null)
				s.close();
		}
	}

	public void remove(Domain domain) {
		Session s = null; 
		Transaction tx = null;
		try{
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.delete(domain);
			tx.commit();
		}finally{
			if(s !=null)
				s.close();
		}
	}

}
