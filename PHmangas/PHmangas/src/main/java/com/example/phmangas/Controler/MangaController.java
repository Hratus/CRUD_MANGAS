package com.example.phmangas.Controler;

import com.example.phmangas.dto.mangaRecordDto;
import com.example.phmangas.entitys.ProductModel;
import com.example.phmangas.repositories.MangaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class MangaController {



    @Autowired

    MangaRepository mangaRepository;

    @PostMapping("/mangas")
    public ResponseEntity<ProductModel>saveManga(@RequestBody @Valid mangaRecordDto MangaRecordDto ){
    var productModel = new ProductModel();



        BeanUtils.copyProperties(MangaRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(mangaRepository.save(productModel));

    }

    @GetMapping("/mangas")
    public ResponseEntity<List<ProductModel>>getAllManga(){
        List<ProductModel> mangaList= mangaRepository.findAll();
        if (!mangaList.isEmpty()){
            for (ProductModel product : mangaList){
                    Long id = product.getIdMANGA();
                product.add(linkTo(methodOn(MangaController.class).getOneManga(id)).withSelfRel());
            }
        }
        return  ResponseEntity.status(HttpStatus.OK).body(mangaList);
    }

    @GetMapping("/mangas/{id}")
    public ResponseEntity<Object>getOneManga(@PathVariable(value ="id")Long id){
        Optional<ProductModel> product0 = mangaRepository.findById(id);
        if (product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MANGA NOT FOUND");
        }
        product0.get().add(linkTo(methodOn(MangaController.class).getAllManga()).withRel("Manga List"));
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }

    @PutMapping("mangas/{id}")
    public ResponseEntity<Object>updateManga(@PathVariable(value="id")Long id, @RequestBody @Valid mangaRecordDto Mangarecorddto){
        Optional<ProductModel>product0 = mangaRepository.findById(id);
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MANGA NOT FOUND");
        }
        var productModel = product0.get();
        BeanUtils.copyProperties(Mangarecorddto,productModel);
        return ResponseEntity.status(HttpStatus.OK).body(mangaRepository.save(productModel));

    }
    @DeleteMapping("/mangas/{id}")
    public  ResponseEntity<Object>deleteManga(@PathVariable(value = "id")Long id){
        Optional<ProductModel>product0 = mangaRepository.findById(id);
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Manga NOT FOUND");
        }
        mangaRepository.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body("MANGA DELETE");
    }



}
