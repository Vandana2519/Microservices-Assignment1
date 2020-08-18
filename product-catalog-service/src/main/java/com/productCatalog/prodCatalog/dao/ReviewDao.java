package com.productCatalog.prodCatalog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productCatalog.prodCatalog.entity.Product;
import com.productCatalog.prodCatalog.entity.Review;

@Repository
public interface ReviewDao extends JpaRepository<Review,Integer>{

	@Query(value="select * from Review as r inner join Product as p on r.id=p.id where p.id=?1",nativeQuery=true)
	List<Review> getProductReview(int id);
	
	@Query(value="select * from Review as r inner join Product as p on r.id=p.id where r.author=?1 and r.body=?2 and r.stars=?3 and p.id=?4",nativeQuery=true)
	Review getProductReviewByAll(String author, String body, int stars,int id);
}
