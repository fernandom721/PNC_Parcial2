package com.uca.capas.service;

import com.uca.capas.domain.Libro;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface LibroService {

    public List<Libro> findAll() throws DataAccessException;

    public void insertbook (Libro libro) throws DataAccessException;

}
