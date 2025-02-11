package com.productCatalog.prodCatalog;

import org.assertj.core.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.productCatalog.prodCatalog.dao.ProductDao;
import com.productCatalog.prodCatalog.dao.ReviewDao;
import com.productCatalog.prodCatalog.entity.Product;
import com.productCatalog.prodCatalog.entity.Review;

@SpringBootApplication
public class ProductCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogServiceApplication.class, args);
		/*ApplicationContext ac = SpringApplication.run(ProductCatalogServiceApplication.class, args);
		ProductDao prodDao = ac.getBean(ProductDao.class);
		ReviewDao reviewDao = ac.getBean(ReviewDao.class);
		
		Product p1 = new Product("Pen",25,"Red Ink");
		Product p2 = new Product("Mobile",16000,"Samsung A31 Mobile");
		Product p3 = new Product("Laptop",75000,"Dell Laptop with I5");
		Product p4 = new Product("Bottle",225,"Water Bottle 1Ltr");
		Product p5 = new Product("Mobile",60000,"One Plus 8 pro");
		Product p6 = new Product("USB Drive",500,"USB Drive 3.0 16GB");
		
		prodDao.save(p1);
		prodDao.save(p2);
		prodDao.save(p3);
		prodDao.save(p4);
		prodDao.save(p5);
		prodDao.save(p6);
		
		Review rvw1 = new Review("Hema","Very Good Mobile",5,p2);
		Review rvw2 = new Review("Vandana","Poor Display",4,p2);
		Review rvw3 = new Review("Kavya","Nice Pen",5,p1);
		Review rvw4 = new Review("Geeta","Doesn't have good grip",3,p1);
		Review rvw5 = new Review("Mohan","Good quality in this price range",4,p1);
		Review rvw6 = new Review("Vandana","Good quality in this price range",4,p6);
		
		reviewDao.save(rvw1);
		reviewDao.save(rvw2);
		reviewDao.save(rvw3);
		reviewDao.save(rvw4);
		reviewDao.save(rvw5);
		reviewDao.save(rvw6);*/
	}

}
