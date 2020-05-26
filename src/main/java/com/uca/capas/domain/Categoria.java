package com.uca.capas.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(schema = "public", name = "cat_categoria")
public class Categoria {

    @Id
    @Column(name = "c_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_categoria;


    @Column(name = "s_categoria")
    @Size(max = 50, message = "El campo no puede estar vacio")
    @NotEmpty(message = "El campo no puede estar vacio")
    private String s_categoria;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    private List<Libro> libroList;

    public Categoria() {}

    public Integer getC_categoria() {
        return c_categoria;
    }

    public void setC_categoria(Integer c_categoria) {
        this.c_categoria = c_categoria;
    }

    public String getS_categoria() {
        return s_categoria;
    }

    public void setS_categoria(String s_categoria) {
        this.s_categoria = s_categoria;
    }

    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }
}
