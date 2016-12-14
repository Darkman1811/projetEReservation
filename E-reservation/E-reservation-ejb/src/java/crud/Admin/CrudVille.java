/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.Admin;


import dataNew.Region;
import dataNew.Ville;
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
public class CrudVille {
    @PersistenceContext
    EntityManager em;
    
    public void ajouterVille( Ville ville){
        ville.setStructures(null);
        em.persist(ville); 
      //  System.out.println("Ville:"+ville);
    } 
     
    
public boolean modifier(Ville ville){
    Ville tmp=em.find(Ville.class, ville.getId());
    
    if(tmp!=null){
    //Garder le meme id l'origine modifier tout le reste avec les nouvelles  valeurs
 
        tmp.setNom_ville(ville.getNom_ville());
        tmp.setRegion(ville.getRegion());
       // tmp.setStructures(ville.getStructures());
       
        em.merge(tmp);
    return true;
    }
    return false;
}
@WebMethod(operationName = "deleteVille")
public boolean delete(Ville ville)
{
   Ville tmp= em.find(Ville.class, ville.getId());
   if(tmp!=null) {
   em.remove(tmp);
   return true;
   }
   return false;
}       

public Ville fromId(int id){
    return em.find(Ville.class, id);
}

public List<Ville> getAll(){
    return em.createNamedQuery("Ville.findAll",Ville.class).getResultList();
} 
}
