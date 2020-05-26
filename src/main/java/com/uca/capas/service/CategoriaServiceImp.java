package com.uca.capas.service;

import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImp implements CategoriaService{

    @Autowired
    CategoriaDAO categoriaDAO;

    @Override
    public List<Categoria> findAll() throws DataAccessException {
        return categoriaDAO.findAll();
    }

    @Override
    public void insertcategoria(Categoria categoria) throws DataAccessException {
        categoriaDAO.insertcategoria(categoria);
    }
}
