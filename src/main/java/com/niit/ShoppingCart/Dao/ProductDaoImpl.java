package com.niit.ShoppingCart.Dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.Dao.ProductDao;
import com.niit.ShoppingCart.Model.Product;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public List<Product> list()
	{
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Product> listproduct=(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();	
	return listproduct;
	}
	@SuppressWarnings("null")
	@Transactional
	public Product getProduct(String name)
	{
		String hql="from Product where name="+"'"+"name"+"'";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> pr =(List<Product>) ((Criteria) query).list();
		if(pr!=null || !pr.isEmpty())
			return pr.get(0);
		return null;
	}
	@SuppressWarnings("null")
	@Transactional
	public Product getProductById(String id)
	{
		String hql="from Product where id="+"'"+"id"+"'";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> pr =(List<Product>) ((Criteria) query).list();
		if(pr!=null || !pr.isEmpty())
			return pr.get(0);
		return null;
	}
	@Transactional
	public void SaveorUpdateProduct(Product product)
	{  
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}
@Transactional
public void deleteProduct(String id)
{	Product product=new Product();
	product.setId(id);
	sessionFactory.getCurrentSession().delete(product);
}
}

