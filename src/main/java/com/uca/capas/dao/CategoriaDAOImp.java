package com.uca.capas.dao;


import com.uca.capas.domain.Categoria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategoriaDAOImp implements CategoriaDAO{

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public List<Categoria> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from public.cat_categoria");
        Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
        List<Categoria> resulset = query.getResultList();
        return resulset;
    }

    @Transactional
    @Override
    public void insertcategoria(Categoria categoria) throws DataAccessException {
        try {
            if (categoria.getC_categoria()==null){
                entityManager.persist(categoria);
            }else {
                entityManager.merge(categoria);
                entityManager.flush();
            }
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

}
