package com.skytouch.productservice.repository;

import com.skytouch.productservice.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, String> {
    @Transactional
    @Modifying
    @Query(value = "call create_product(:name_p, :cost_p, :storename);", nativeQuery = true)
    void createProduct(@Param("name_p") String name, @Param("cost_p") BigDecimal cost, @Param("storename") String storeName);

    @Query(value = "select * from list_product()", nativeQuery = true)
    List<Products> listProducts();

}
