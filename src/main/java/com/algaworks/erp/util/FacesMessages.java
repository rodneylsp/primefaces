package com.algaworks.erp.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

public class FacesMessages implements Serializable {

    private void add(String message, FacesMessage.Severity severity){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(message);
        msg.setSeverity(severity);
        context.addMessage(null, msg);
    }

    public void info(String message){
        add(message, FacesMessage.SEVERITY_INFO);
    }

    public void error(String message){
        add(message, FacesMessage.SEVERITY_ERROR);
    }
}
