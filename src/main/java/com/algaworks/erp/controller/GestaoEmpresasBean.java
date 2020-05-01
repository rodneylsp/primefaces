package com.algaworks.erp.controller;


import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.repository.Empresas;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

    @Inject
    private Empresas empresas;

    private List<Empresa> todasEmpresas;

    public void consultar(){

        todasEmpresas = empresas.todas();
    }

    public List<Empresa> getTodasEmpresas() {
        return todasEmpresas;
    }
}
