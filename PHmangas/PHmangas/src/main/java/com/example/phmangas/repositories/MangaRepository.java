package com.example.phmangas.repositories;

import com.example.phmangas.entitys.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MangaRepository extends JpaRepository<ProductModel,Long> {

}
