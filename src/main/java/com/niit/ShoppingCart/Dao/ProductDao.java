package com.niit.ShoppingCart.Dao;

import java.util.List;
import com.niit.ShoppingCart.Model.Product;

public interface ProductDao {

	public List<Product> list();
	public Product getProduct(String id);
	public void update(Product product);
	public void delete(String id);
}
