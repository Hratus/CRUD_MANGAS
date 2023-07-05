package com.example.phmangas.Services;

import com.example.phmangas.Controler.MangaController;
import com.example.phmangas.entitys.ProductModel;
import com.example.phmangas.repositories.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductModelService {

@Autowired
MangaRepository mangaRepository;

public ProductModel buscarManga(Long id){
    return mangaRepository.findById(id).orElse(null);
}
public ProductModel cadastrarManga(ProductModel productModel){
    return mangaRepository.save(productModel);
}
public ProductModel atualizarManga(Long id, ProductModel productModel){
    productModel.setIdMANGA(id);
    return mangaRepository.save(productModel);
}

public void excluirManga(Long id){
mangaRepository.deleteById(id);
}

}
