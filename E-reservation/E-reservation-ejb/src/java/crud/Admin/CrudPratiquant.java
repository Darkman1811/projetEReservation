/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.Admin;


import dataNew.Client;
import dataNew.Pratiquant;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author darkman
 */

@Stateless
public class CrudPratiquant {
    @PersistenceContext
    EntityManager em;
    
    public void ajouterPratiquant( Pratiquant pratiquant){        
        em.persist(pratiquant);
    } 
    
    
public boolean modifier(Pratiquant pratiquant){
    Pratiquant tmp=em.find(Pratiquant.class, pratiquant.getId());
    
    if(tmp!=null){
    //Garder le meme id l'origine modifier tout le reste avec les nouvelles  valeurs
        
        tmp.setAge(pratiquant.getAge());
        tmp.setCivilite(pratiquant.getCivilite());
        tmp.setNom(pratiquant.getNom());
        tmp.setPrenom(pratiquant.getPrenom());
        tmp.setSpecialite(pratiquant.getSpecialite());
        tmp.setTitre(pratiquant.getTitre());       
        em.merge(tmp);
    return true;
    }
    return false;
}

public boolean delete(Pratiquant pratiquant)
{
   Pratiquant tmp= em.find(Pratiquant.class, pratiquant.getId());
   if(tmp!=null) {
   em.remove(tmp);
   return true;
   }
   return false;
}       

public void fusionner(Set<Pratiquant> list){
    Iterator<Pratiquant> it=list.iterator();
   while(it.hasNext()){
       Pratiquant element=it.next();
       Client tmp=em.find(Client.class, element.getId());
       if(tmp==null){
           this.ajouterPratiquant(element);
       }
       else{
           this.modifier(element);           
       }
   }
}
public Pratiquant fromId(int id){
    return em.find(Pratiquant.class, id);
}
public List<Pratiquant> getAll(){
    return em.createNamedQuery("Pratiquant.findAll",Pratiquant.class).getResultList();
} 
}
