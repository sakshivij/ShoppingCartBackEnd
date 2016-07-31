package com.niit.ShoppingCart.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.Dao.ProductDao;
import com.niit.ShoppingCart.Model.Product;

public class Test {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		Product p = (Product)context.getBean("product");

		p.setId("p001");
		p.setName("shirt");
		p.setPrice(100);
		p.setSize("M");
		ProductDao productdao=(ProductDao)context.getBean("productDao");
		productdao.SaveorUpdateProduct(p);
		context.close();
	}

}
