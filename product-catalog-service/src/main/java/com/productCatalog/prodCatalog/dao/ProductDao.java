package com.productCatalog.prodCatalog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productCatalog.prodCatalog.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	
	@Query(value="select * from Product where id=?1",nativeQuery=true)
	Product getProductById(int id);
	
	@Query(value="select * from Product where name=?1 and price=?2",nativeQuery=true)
	Product getProductByNameAndPrice(String name,double price);
	
	@Query(value="select * from Product p where p.name like CONCAT('%',?1,'%')",nativeQuery=true)
	List<Product> getProductsByNameWithLetter(String letter); 
	
	
}
