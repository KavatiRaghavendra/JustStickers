package com.example.juststickers.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.juststickers.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Long>{

}
