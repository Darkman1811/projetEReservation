/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.Admin;

import dataNew.Pays;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author darkman
 */

@Stateless
public class CrudPays {
@PersistenceContext
private EntityManager em;


public void ajouterPays(Pays pays)
{   pays.setRegions(null);
 
em.persist(pays);
    
}

public boolean modifier(Pays pays){
    Pays tmp=em.find(Pays.class, pays.getId());
    
    if(tmp!=null){
    //Garder le meme id l'origine modifier tout le reste avec les nouvelles  valeurs
       tmp.setId(pays.getId());
        tmp.setIndicatif_telephonique(pays.getIndicatif_telephonique());
        tmp.setMonaie(pays.getMonaie());
        tmp.setNom_pays(pays.getNom_pays());
       // tmp.setRegions(pays.getRegions());
        tmp.setTaux(pays.getTaux());
        em.merge(tmp);
    return true;
    }
    return false;
}

public boolean delete(Pays pays)
{
   Pays tmp= em.find(Pays.class, pays.getId());
   if(tmp!=null) {
   em.remove(tmp);
   return true;
   }
   return false;
}       

public Pays fromId(int id){
    return em.find(Pays.class, id);
}

public List<Pays> getAll(){
    return em.createNamedQuery("Pays.findAll",Pays.class).getResultList();
}  
}
