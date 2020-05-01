package com.algaworks.erp.service;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.repository.Empresas;
import com.algaworks.erp.util.Transactional;

import javax.inject.Inject;
import java.io.Serializable;

public class EmpresaService implements Serializable {

    @Inject
    private Empresas empresas;

    @Transactional
    public void salvar(Empresa empresa){
        empresas.guardar(empresa);
    }

    @Transactional
    public void excluir(Empresa empresa){
        empresas.remover(empresa);
    }
}
