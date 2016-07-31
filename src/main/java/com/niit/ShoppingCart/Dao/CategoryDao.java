package com.niit.ShoppingCart.Dao;

import java.util.List;

import com.niit.ShoppingCart.Model.Category;

public interface CategoryDao {

	public List<Category> list();
	public Category getCategory(String name);
	public Category getCategoryById(String id);
	public void SaveorUpdateCategory(Category category);
	public void deleteCategory(String id);
}
