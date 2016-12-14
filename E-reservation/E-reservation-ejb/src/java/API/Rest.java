/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Sync.DataSync;
import crud.Admin.CrudClient;
import crud.Admin.CrudJoursBloques;
import crud.Admin.CrudJoursFeries;
import crud.Admin.CrudPlanning;
import crud.Admin.CrudPratiquant;
import crud.Admin.CrudRV;
import dataNew.Client;
import dataNew.JoursBloques;
import dataNew.JoursFeries;
import dataNew.Planning;
import dataNew.Pratiquant;
import dataNew.RV;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author darkman
 */
@Path("/sync")
@Stateless
public class Rest {
    @Inject
    CrudClient clientMetier;
    @Inject
    CrudPratiquant pratiquantMetier;
    @Inject
    CrudPlanning planningMetier;
    @Inject
    CrudJoursBloques joursBloquesMetier;
    @Inject
    CrudJoursFeries joursFeriesMetier;
    @Inject
    CrudRV rvMetier;
            
    
    
    @GET
    @Path("/tester")
    @Produces(MediaType.TEXT_PLAIN)
    public String tester(){
        return "Test effectif";
    }
    
    /*
    @PUT
    @Path("/synctest")
    @Produces(MediaType.TEXT_PLAIN)
    public void syncJoursBloques(@QueryParam("jours") String para){
        System.out.println("para:"+para);
    }
   */
    @PUT
    @Path("/JoursBloques")
    @Produces(MediaType.APPLICATION_XML)
    public void syncJoursBloques(JoursBloques jb){
        System.out.println(jb.getId());
        System.out.println(jb.getDate_bloque());
        System.out.println(jb.getDebut_debut_bloque());
        System.out.println(jb.getDate_fin_bloque());
        System.out.println(jb.getRaison()); 
    }
    
    @PUT
    @Path("/ListJoursBloques")
    @Produces(MediaType.APPLICATION_XML)
  //  public void syncListJoursBloques(List<JoursBloques>  listeJoursBloques){
 public void syncListJoursBloques(DataSync  dataSync){
        System.out.println("Syncing data...");
        Iterator it;
        
        System.out.println("Clients...");
              
        HashSet<Client> clients=new HashSet<>();
           /* 
           L'ordre d'insertion dans le hashset est trés important.
           C'est elle qui définit le point de vérité entre le client et le serveur 
           */
        clients.addAll(clientMetier.getAll());
        clients.addAll(dataSync.getClient());
        clientMetier.fusionner(clients);       
        
        /*
        System.out.println("Rendez-vous...");
        HashSet<RV> rvs=new HashSet<>();
        rvs.addAll(rvMetier.getAll());
        rvs.addAll(dataSync.getRv());
       
      */
        
        System.out.println("Pratiquant...");
        HashSet<Pratiquant> pratiquants=new HashSet<>();
        pratiquants.addAll(pratiquantMetier.getAll());
        pratiquants.addAll(dataSync.getPratiquant());
        pratiquantMetier.fusionner(pratiquants);
       
        System.out.println("Planning...");
        HashSet<Planning> plannings=new HashSet<>();
        plannings.addAll(planningMetier.getAll());
        plannings.addAll(dataSync.getPlanning());
        planningMetier.fusionner(plannings);
        
        
        /* it=dataSync.getPlanning().iterator();
        while (it.hasNext()){
            Planning element=(Planning)it.next();           
            System.out.println(element.getId()); 
        }
        
        System.out.println("Jours Bloques...");
        it=dataSync.getJoursBloques().iterator();
        while (it.hasNext()){
            JoursBloques element=(JoursBloques)it.next();           
            System.out.println(element.getId()); 
        }
                
        System.out.println("Jours Fériés...");
        it=dataSync.getJoursFeries().iterator();
        while (it.hasNext()){
            JoursFeries element=(JoursFeries)it.next();           
            System.out.println(element.getId()); 
        }
        */
    }
          
}
