package com.productCatalog.prodCatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productCatalog.prodCatalog.dao.ProductDao;
import com.productCatalog.prodCatalog.dao.ReviewDao;
import com.productCatalog.prodCatalog.entity.Product;
import com.productCatalog.prodCatalog.entity.Review;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	public Product getProductById(int id) {
		Product productInfo = productDao.getProductById(id);
		if (productInfo == null) {
			return null; 
		}
		return productInfo;
	}

	@Override
	public Product getProductByNameAndPrice(String name, double price) {
		Product productInfo = productDao.getProductByNameAndPrice(name, price);
		return productInfo;
	}

	@Override
	public List<Review> getProductReview(int id) {
		List<Review> reviews = reviewDao.getProductReview(id);
		return reviews;
	}

	@Override
	public Review getProductReviewByAll(String author, String body, int stars,int id) {
		Review rvw = reviewDao.getProductReviewByAll(author, body, stars, id);
		return rvw;
	}

	@Override
	public List<Product> getProductsByNameWithLetter(String letter) {
		List<Product> productList =productDao.getProductsByNameWithLetter(letter);
		return productList;
	}

}
