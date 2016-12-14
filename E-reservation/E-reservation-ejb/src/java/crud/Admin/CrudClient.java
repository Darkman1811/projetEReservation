/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.Admin;



import dataNew.Client;
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
public class CrudClient {
    @PersistenceContext
    EntityManager em;
    
    public void ajouterClient( Client client){
        
        em.persist(client);
    } 
    
    
public boolean modifier(Client client){
    Client tmp=em.find(Client.class, client.getId());
    
    if(tmp!=null){
    //Garder le meme id l'origine modifier tout le reste avec les nouvelles  valeurs
        
        tmp.setAge(client.getAge());
        tmp.setCivilite(client.getCivilite());
        tmp.setNom(client.getNom());
        tmp.setPrenom(client.getPrenom());
        tmp.setEmail(client.getEmail());
        tmp.setPhone(client.getPhone());
             
        em.merge(tmp);
    return true;
    }
    return false;
}

public boolean delete(Client client)
{
   Client tmp= em.find(Client.class, client.getId());
   if(tmp!=null) {
   em.remove(tmp);
   return true;
   }
   return false;
}       

public void fusionner(Set<Client> list){
    Iterator<Client> it=list.iterator();
   while(it.hasNext()){
       Client client=it.next();
       Client tmp=em.find(Client.class, client.getId());
       if(tmp==null){
           this.ajouterClient(client);
       }
       else{
           this.modifier(client);           
       }
   }
}
public Client fromId(int id){
    return em.find(Client.class, id);
}

public List<Client> getAll(){
    return em.createNamedQuery("Client.findAll",Client.class).getResultList();
} 
}
