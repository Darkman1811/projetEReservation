/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import UI.ClientUI;
import UI.MainWindow;
import dataNew.Client;
import dataNew.Pays;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static metier.ConnectionEsante.connection;

/**
 *
 * @author darkman
 */
public class ClientMetier {
  public void ajouter(Client client){
      
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
        EntityManager em=factory.createEntityManager();       
        em.getTransaction().begin();        
        em.persist(client);
        em.getTransaction().commit();
        em.close();        
        
   
  } 
  
  public void modifier(Client client){
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
        EntityManager em=factory.createEntityManager();       
        em.getTransaction().begin();        
        em.merge(client);
        em.getTransaction().commit();
        em.close(); 
    
     /*   ClientUI clientUI=new ClientUI();
        MainWindow.mainLayout.setCenter(clientUI.getLayout()); 
    */
  } 
  
  public ObservableList<Client>  getAll(){
      ObservableList<Client> clients=FXCollections.observableArrayList();
      
      EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
      EntityManager em=factory.createEntityManager();       
      
      em.getTransaction().begin();  
      clients.addAll(em.createNamedQuery("Client.findAll").getResultList());
      em.getTransaction().commit();
      em.close(); 
      
    return clients;    
  }
}
