/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.Admin;

import dataNew.Service;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author darkman
 */
@Stateless
public class CrudServices {
    @PersistenceContext
    EntityManager em;
   
    public void ajouterService( Service service){
        /*service.setServices(null);
        service.setRegion(new Region());*/
        em.persist(service); 
        System.out.println("Service:"+service);
    } 
    
    
public boolean modifier(Service service){
    Service tmp=em.find(Service.class, service.getId());
    
    if(tmp!=null){
    //Garder le meme id l'origine modifier tout le reste avec les nouvelles  valeurs
 
        tmp.setService(service.getService());
        tmp.setSpecialite(service.getSpecialite());
        tmp.setTarif(service.getTarif());
      //  tmp.setStructure(service. getStructure());
        
       
        em.merge(tmp);
    return true;
    }
    return false;
}

public boolean delete(Service service)
{
   Service tmp= em.find(Service.class, service.getId());
   if(tmp!=null) {
      em.remove(tmp);
   return true;
   }
   return false;
}       

public Service fromId(int id){
    return em.find(Service.class, id);
}
public List<Service> getAll(){
    return em.createNamedQuery("Service.findAll",Service.class).getResultList();
} 
}
