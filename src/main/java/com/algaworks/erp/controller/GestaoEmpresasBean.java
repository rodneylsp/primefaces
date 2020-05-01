package com.algaworks.erp.controller;


import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.TipoEmpresa;
import com.algaworks.erp.repository.Empresas;
import com.algaworks.erp.service.EmpresaService;
import com.algaworks.erp.util.FacesMessages;

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

    @Inject
    private EmpresaService service;

    @Inject
    private FacesMessages messages;

    private List<Empresa> todasEmpresas;
    private Empresa novaEmpresa = new Empresa();

    public void prepararNovoCadastro(){
        novaEmpresa = new Empresa();
    }

    public void consultar(){
        todasEmpresas = empresas.todas();
    }

    public void salvar(){
        service.salvar(novaEmpresa);
        consultar();
        messages.info("Empresa salva com sucesso!");
    }

    public List<Empresa> getTodasEmpresas() {
        return todasEmpresas;
    }

    public TipoEmpresa[] getTiposEmpresas(){
        return TipoEmpresa.values();
    }

    public Empresa getNovaEmpresa() {
        return novaEmpresa;
    }
    public void setNovaEmpresa(Empresa novaEmpresa) {
        this.novaEmpresa = novaEmpresa;
    }

}
