package com.niit.ShoppingCart.Dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.Model.Supplier;

@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public List<Supplier> list()
	{
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Supplier> supplier=(List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return supplier;
	}
	@SuppressWarnings("null")
	@Transactional
	public Supplier getSupplier(String name)
	{
		String hql="from Supplier where name="+"'"+name+"'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Supplier> supplier=(List<Supplier>)((Criteria) query).list();
		if(supplier!=null||!supplier.isEmpty())
			return (Supplier) supplier;
		return null;
	}
	@SuppressWarnings("null")
	@Transactional
	public Supplier getSupplierById(String id)
	{
		String hql="from Supplier where id="+"'"+id+"'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Supplier> supplier=(List<Supplier>)((Criteria) query).list();
		if(supplier!=null||!supplier.isEmpty())
			return (Supplier) supplier;
		return null;
	}
public void SaveorUpdateSupplier(Supplier supplier)
{
	sessionFactory.getCurrentSession().saveOrUpdate(supplier);
}
public void deleteSupplier(String id)
{
	Supplier supplier=new Supplier();
	supplier.setId(id);
	sessionFactory.getCurrentSession().delete(supplier);
}
}
