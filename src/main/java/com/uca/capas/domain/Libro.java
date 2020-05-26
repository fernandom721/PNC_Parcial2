package com.uca.capas.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(schema = "public", name = "cat_libro")
public class Libro {

    @Id()
    @Column(name = "c_libro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_libro;

    @Column(name = "s_titulo")
    @Size(message = "el titulo no peude tener mas de 30 caracteres", max = 30)
    private String s_titulo;

    @Column(name = "s_autor")
    @Size(message = "el titulo no peude tener mas de 30 caracteres", max = 30)
    private String s_autor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_categoria")
    private Categoria categoria;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "f_ingreso")
    private Date f_ingreso;

    @Column(name = "b_estado")
    private Boolean b_estado;

    @Column(name = "s_isbn")
    @Size(message = "el titulo no peude tener mas de 10 caracteres", max = 10)
    private String s_isbn;

    public Libro() { }

    public Integer getC_libro() {
        return c_libro;
    }

    public void setC_libro(Integer c_libro) {
        this.c_libro = c_libro;
    }

    public String getS_titulo() {
        return s_titulo;
    }

    public void setS_titulo(String s_titulo) {
        this.s_titulo = s_titulo;
    }

    public String getS_autor() {
        return s_autor;
    }

    public void setS_autor(String s_autor) {
        this.s_autor = s_autor;
    }

    public Categoria getC_categoria() {
        return categoria;
    }

    public void setC_categoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Date getF_ingreso() {
        return f_ingreso;
    }

    public void setF_ingreso(Date f_ingreso) {
        this.f_ingreso = f_ingreso;
    }

    public Boolean getB_estado() {
        return b_estado;
    }

    public void setB_estado(Boolean b_estado) {
        this.b_estado = b_estado;
    }

    public String getS_isbn() {
        return s_isbn;
    }

    public void setS_isbn(String s_isbn) {
        this.s_isbn = s_isbn;
    }
}
