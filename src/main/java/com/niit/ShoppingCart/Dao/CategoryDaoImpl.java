package com.niit.ShoppingCart.Dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.ShoppingCart.Dao.CategoryDao;
import com.niit.ShoppingCart.Model.Category;
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public List<Category> list()
	{
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Category> category=(List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return category;
	}
	@SuppressWarnings("null")
	@Transactional
	public Category getCategory(String name)
	{
		String hql="from Category where name="+"'"+name+"'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> category=(List<Category>)((Criteria) query).list();
		if(category!=null||!category.isEmpty())
			return (Category) category;
		return null;
	}
	@SuppressWarnings("null")
	@Transactional
	public Category getCategoryById(String id)
	{
		String hql="from Category where id="+"'"+id+"'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> category=(List<Category>)((Criteria) query).list();
		if(category!=null||!category.isEmpty())
			return (Category) category;
		return null;
	}
public void SaveorUpdateCategory(Category category)
{
	sessionFactory.getCurrentSession().saveOrUpdate(category);
}
public void deleteCategory(String id)
{
	Category category=new Category();
	category.setId(id);
	sessionFactory.getCurrentSession().delete(category);
}
}
