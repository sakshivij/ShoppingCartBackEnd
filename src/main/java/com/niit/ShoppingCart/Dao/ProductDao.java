package com.niit.ShoppingCart.Dao;

import java.util.List;
import com.niit.ShoppingCart.Model.Product;

public interface ProductDao {

	public List<Product> list();
	public Product getProduct(String name);
	public Product getProductById(String id);
	public void SaveorUpdateProduct(Product product);
	public void deleteProduct(String id);
}
