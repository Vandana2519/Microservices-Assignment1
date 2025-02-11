package com.productCatalog.prodCatalog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productCatalog.prodCatalog.dao.ProductDao;
import com.productCatalog.prodCatalog.dao.ReviewDao;
import com.productCatalog.prodCatalog.entity.Product;
import com.productCatalog.prodCatalog.entity.Review;
import com.productCatalog.prodCatalog.service.ProductService;
import com.productCatalog.prodCatalog.service.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private ProductServiceImpl prodService;
	
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return productDao.findAll();
		
	}
	
	@GetMapping("/products/{id}")
	public Product findByProductId(@PathVariable("id") int id){
		return prodService.getProductById(id);	
	}

	@GetMapping("/products/byName/{letter}")
	public List<Product> findByNameAndLetter(@PathVariable("letter") String letter) {
		List<Product> prodList = prodService.getProductsByNameWithLetter(letter);
		return prodList;

	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		productDao.save(new Product(product.getName(), product.getPrice(), product.getDescription()));
		Product productList = prodService.getProductByNameAndPrice(product.getName(), product.getPrice());
		return productList;
	}
	
	@PostMapping("/products/all")
	public List<Product> addMoreProducts(@RequestBody List<Product> productsList){
		for(Product product :productsList){
			productDao.save(new Product(product.getName(), product.getPrice(), product.getDescription()));
		}
		List<Product> productList = new ArrayList<>();
		for(Product product :productsList){
			Product prod = prodService.getProductByNameAndPrice(product.getName(), product.getPrice());
			productList.add(prod);
		}
		return productList;
		
	}
	
	@GetMapping("/products/{id}/reviews")
	public List<Review> getReview(@PathVariable("id") int id){
		List<Review> review = prodService.getProductReview(id);
		return review;
	}
	
	@PostMapping("/products/{id}/reviews")
	public Review addReview(@PathVariable("id") int id,@RequestBody Review review){
		Optional<Product> prod = productDao.findById(id);
		Product product = prod.get();
		review.setProduct(product);
		reviewDao.save(new Review(review.getAuthor(),review.getBody(),review.getStars(),review.getProduct()));
		
		Review rvw = prodService.getProductReviewByAll(review.getAuthor(),review.getBody(),review.getStars(),id);
		
		return rvw;
	}
}
