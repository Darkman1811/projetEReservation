/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publique;

import admin.*;
import crud.Admin.CrudClient;
import dataNew.Client;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author darkman
 */
@ManagedBean
@SessionScoped
public class ClientMB {
    @EJB
    CrudClient crudClient;
    
   private Client client=new Client();
   private List<Client> listeClient;

    public String ajouterClient(){
        crudClient.ajouterClient(client);
        return "client.xhtml";
    }
      
    public String editerClient(){
     //  int idClient=(int)FacesContext.getCurrentInstance().getAttributes().get("idClient");
        String idClient=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idClient");
       client.setId(Integer.valueOf(idClient));
       client=crudClient.fromId(client.getId());
        return "clientModif.xhtml";
    }
    
   public String modifierClient(){
        crudClient.modifier(client);
        return("client.xhtml");
    }
    
    public String supprimerClient(){
         String idClient=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idClient");
         client.setId(Integer.valueOf(idClient)); 
        crudClient.delete(client);
        return("client.xhtml");
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

  
    public List<Client> getListeClient() {
        //return listeClient;
        return crudClient.getAll();
    }

    public void setListeClient(List<Client> listeClient) {
        this.listeClient = listeClient;
    }
    
    
}
