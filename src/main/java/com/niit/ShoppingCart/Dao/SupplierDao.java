package com.niit.ShoppingCart.Dao;

import java.util.List;

import com.niit.ShoppingCart.Model.Supplier;

public interface SupplierDao {

	public List<Supplier> list();
	public Supplier getSupplier(String name);
	public Supplier getSupplierById(String id);
	public Supplier updateSupplier(Supplier supplier);
	public void deleteSupplier(String id);
}
