package com.unir.buscador.service;

import java.util.List;

import com.unir.buscador.model.pojo.Product;
import com.unir.buscador.model.request.CreateProductRequest;

public interface ProductsService {
	
	List<Product> getProducts();
	
	Product getProduct(String productId);
	
	Boolean removeProduct(String productId);
	
	Product createProduct(CreateProductRequest request);

}
