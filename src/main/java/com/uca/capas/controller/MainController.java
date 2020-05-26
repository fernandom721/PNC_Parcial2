package com.uca.capas.controller;

import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CategoriaDAO categoriaDAO;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private LibroDAO libroDAO;
    @Autowired
    private LibroService libroService;

    @RequestMapping("/index")
    public ModelAndView initMain(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main");
        return mav;
    }

    @RequestMapping("/ins_category")
    public ModelAndView ins_category(@Valid @ModelAttribute Categoria categoria, BindingResult result){
        ModelAndView mav = new ModelAndView();
        if (result.hasErrors()) {
            mav.setViewName("insert_categoria");
            return mav;
        }
        try {
            categoriaService.insertcategoria(categoria);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("categoria", new Categoria());
        mav.setViewName("insert_categoria");
        return mav;
    }

    @RequestMapping("/ins_book")
    public ModelAndView ins_book(@Valid @ModelAttribute Libro libro, BindingResult result){
        ModelAndView mav = new ModelAndView();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        List<Categoria> categorias = null;
        if(result.hasErrors()){
            mav.setViewName("insert_libro");
            return mav;
        }
        try {
            categorias = categoriaService.findAll();
            mav.addObject("categoria", categorias);
            libroService.insertbook(libro);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("libro", new Libro());


        mav.setViewName("insert_libro");
        return mav;
    }

    @RequestMapping("/listado")
    public ModelAndView listado(){
        ModelAndView mav = new ModelAndView();
        List<Libro> libros = null;
        try {
            libros = libroDAO.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("libros", libros);
        mav.setViewName("booklist");
        return mav;
    }

}
