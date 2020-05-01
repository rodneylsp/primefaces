package com.algaworks.erp.util;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

@Interceptor
@Transactional
@Priority(Interceptor.Priority.APPLICATION + 1)
public class TransactionalInterceptor implements Serializable {

    @Inject
    private EntityManager manager;

    public Object invoke(InvocationContext context) throws Exception {

        EntityTransaction trx = manager.getTransaction();
        boolean criador = false;

        try{

            if(!trx.isActive()){

                trx.begin();
                trx.rollback();

                trx.begin();
                criador = true;
            }
            return context.proceed();

        }catch (Exception e){
            if(trx != null && criador){
                trx.rollback();
            }
            throw e;
        }finally {
            if(trx != null && trx.isActive() && criador){
                trx.commit();
            }
        }

    }
}
