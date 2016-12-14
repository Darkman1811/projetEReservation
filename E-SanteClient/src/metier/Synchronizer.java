/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import Sync.DataSync;
import dataNew.JoursBloques;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author darkman
 */
public class Synchronizer {
 
    public static DataSync sendData (){
          
       /* ClientMetier clientMetier=new ClientMetier();
        PratiquantMetier pratiquantMetier=new PratiquantMetier();
        JoursBloquesMetier joursBloquesMetier=new JoursBloquesMetier();
        JoursFeriesMetier joursFeriesMetier=new JoursFeriesMetier();
        PlanningMetier plm=new PlanningMetier();
       */ 
        DataSync sync=new DataSync();   
        sync.setClient(new ClientMetier().getAll());
        sync.setPratiquant(new PratiquantMetier().getAll());
        sync.setPlanning(new PlanningMetier().getAll());
        sync.setJoursBloques(new JoursBloquesMetier().getAll());
        sync.setRv(new RVMetier().getAll());
        sync.setJoursFeries(new JoursFeriesMetier().getAll());
            
      
            
            Client client = ClientBuilder.newClient();
            
            Response response=client.target("http://localhost:8080/E-santeWeb/rs").path("sync").path("ListJoursBloques").request(MediaType.APPLICATION_XML).put(Entity.xml(sync));
      return new DataSync();
    }
    
}
