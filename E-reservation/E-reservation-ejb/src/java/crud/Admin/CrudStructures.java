/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.Admin;

import dataNew.Structure;
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
public class CrudStructures {
    @PersistenceContext
    EntityManager em;
   
    public void ajouterStructure( Structure structure){
      
        em.persist(structure); 
        System.out.println("Structure:"+structure);
    } 
    
    
public boolean modifier(Structure structure){
    Structure tmp=em.find(Structure.class, structure.getId());
    
    if(tmp!=null){
    //Garder le meme id l'origine modifier tout le reste avec les nouvelles  valeurs
 
        tmp.setNom_structure(structure.getNom_structure());
        tmp.setAdresse(structure.getAdresse());
        tmp.setBlog(structure.getBlog());
        tmp.setEmail(structure.getEmail());
        tmp.setLatitude(structure.getLatitude());
        tmp.setLongitude(structure.getLongitude());
        tmp.setTelephone(structure.getTelephone());
        tmp.setSiteWeb(structure.getSiteWeb());
        tmp.setVille(structure.getVille());
        
       // tmp.setServices(structure.getServices());
       
        em.merge(tmp);
    return true;
    }
    return false;
}

public boolean delete(Structure structure)
{
   Structure tmp= em.find(Structure.class, structure.getId());
   if(tmp!=null) {
      em.remove(tmp);
   return true;
   }
   return false;
}       

public Structure fromId(int id){
    return em.find(Structure.class, id);
}

public List<Structure> getAll(){
    return em.createNamedQuery("Structure.findAll",Structure.class).getResultList();
} 
}
