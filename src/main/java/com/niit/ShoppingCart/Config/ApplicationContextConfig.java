package com.niit.ShoppingCart.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.h2.engine.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ShoppingCart.Dao.CategoryDao;
import com.niit.ShoppingCart.Dao.CategoryDaoImpl;
import com.niit.ShoppingCart.Dao.ProductDao;
import com.niit.ShoppingCart.Dao.ProductDaoImpl;
import com.niit.ShoppingCart.Dao.SupplierDao;
import com.niit.ShoppingCart.Dao.SupplierDaoImpl;
//import com.niit.ShoppingCart.Model.Category;
import com.niit.ShoppingCart.Model.Product;
import com.niit.ShoppingCart.Model.Supplier;


//@SuppressWarnings("deprecation")
@SuppressWarnings("deprecation")
@Configuration
@ComponentScan("com.niit.shoppingcart")
@EnableTransactionManagement

public class ApplicationContextConfig {
	@Bean(name = "datasource")
	public DriverManagerDataSource getH2DataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:~/test");
	dataSource.setUsername("sa");
	dataSource.setPassword("");
	return dataSource;

	}
	 private Properties getHibernateProperties() {
	    	Properties properties = new Properties();
	    	properties.put("hibernate.show_sql", "true");
	    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    	return properties;
	    }
	 @Autowired
	 @Bean(name="sessionFactory")
	 public SessionFactory getSessionFactory(DataSource dataSource){
		 LocalSessionFactoryBuilder sessionbuilder=new LocalSessionFactoryBuilder(dataSource);
		 sessionbuilder.addProperties(getHibernateProperties());
		 sessionbuilder.addAnnotatedClass(Product.class);
		 sessionbuilder.addAnnotatedClass(Supplier.class);
		 sessionbuilder.addAnnotatedClass(User.class);
		 return sessionbuilder.buildSessionFactory();
		 
	 }
	 @Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
				SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(
					sessionFactory);

			return transactionManager;
		}
	 
@Autowired
@Bean(name="categoryDao")
public CategoryDao getCategoryDao(SessionFactory sessionFactory)
{
	return new CategoryDaoImpl(sessionFactory);
}
@Autowired
@Bean(name="productDao")
public ProductDao getProductDao(SessionFactory sessionFactory)
{
	return new ProductDaoImpl(sessionFactory);
	
}
@Autowired
@Bean(name="supplierDao")
public SupplierDao getSupplierDao(SessionFactory sessionFactory)
{
	return new SupplierDaoImpl(sessionFactory);
}
}
