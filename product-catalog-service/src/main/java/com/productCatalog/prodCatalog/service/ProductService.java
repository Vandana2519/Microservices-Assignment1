package com.productCatalog.prodCatalog.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.productCatalog.prodCatalog.entity.Product;
import com.productCatalog.prodCatalog.entity.Review;

public interface ProductService {
	
	Product getProductById(int id);
	
	Product getProductByNameAndPrice(String name,double price);
	
	List<Product> getProductsByNameWithLetter(String letter);
	
	List<Review> getProductReview(int id);

	Review getProductReviewByAll(String author, String body, int stars,int id);
}
