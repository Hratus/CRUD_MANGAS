package com.example.phmangas.entitys;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "Mangas")
public class ProductModel extends RepresentationModel<ProductModel> implements Serializable {


        @Serial
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idMANGA;
        private String name;
        private String autor;
        private String genero;




        private int qtd_cap;

        private Integer ano_lancamento;




        public ProductModel(){
            super();
        }



    public Long getIdMANGA() {
        return idMANGA;
    }

    public void setIdMANGA(Long idMANGA) {
        this.idMANGA = idMANGA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }



    public int getQtd_cap() {
        return qtd_cap;
    }

    public void setQtd_cap(int qtd_cap) {
        this.qtd_cap = qtd_cap;
    }

    public Integer getAno_lancamento() {
        return ano_lancamento;
    }

    public void setAno_lancamento(Integer ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ProductModel(Long idMANGA,String name, String autor,String genero, int qtd_cap, int ano_lancamento){
        this.name= name;
        this.autor= autor;
        this.genero=autor;
        this.idMANGA=idMANGA;


        this.qtd_cap= qtd_cap;
        this.ano_lancamento= ano_lancamento;

    }


    @Override
    public String toString() {
        return "ProductModel{" +
                "idMANGA=" + idMANGA +
                ", name='" + name + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", qtd_cap=" + qtd_cap +
                ", ano_lancamento=" + ano_lancamento +
                '}';
    }
}


