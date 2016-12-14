/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.Admin;

import dataNew.Pays;
import dataNew.Region;
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
public class CrudRegion {
    @PersistenceContext
private EntityManager em;

    
public void ajouterRegion(Region region)
{   
    region.setVilles(null);
   // region.setPays(new Pays());
    em.persist(region);
}

public boolean modifier(Region region){
    Region tmp=em.find(Region.class, region.getId());
    
    if(tmp!=null){
    //Garder le meme id l'origine modifier tout le reste avec les nouvelles  valeurs
 
        tmp.setNom_region(region.getNom_region());
        tmp.setPays(region.getPays());
       // tmp.setVilles(region.getVilles());
      
        em.merge(tmp);
    return true;
    }
    return false;
}

public boolean delete(Region region)
{
   Region tmp= em.find(Region.class, region.getId());
   if(tmp!=null) {
   em.remove(tmp);
   return true;
   }
   return false;
}       

public Region fromId(int id){
    return em.find(Region.class, id);
}

public List<Region> getAll(){
    return em.createNamedQuery("Region.findAll",Region.class).getResultList();
} 

}
