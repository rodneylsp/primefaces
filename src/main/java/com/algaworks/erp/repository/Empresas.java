package com.algaworks.erp.repository;

import com.algaworks.erp.model.Empresa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class Empresas implements Serializable {

    @Inject
    private EntityManager manager;

    public Empresa porId(Long id){
        return manager.find(Empresa.class, id);
    }

    public List<Empresa> todas(){
        return manager.createQuery("from Empresa", Empresa.class).getResultList();
    }

    public Empresa guardar(Empresa empresa){
        return manager.merge(empresa);
    }

    public void remover(Empresa empresa){
        manager.remove(empresa);
    }
}
