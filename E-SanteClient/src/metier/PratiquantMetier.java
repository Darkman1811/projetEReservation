/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import UI.PratiquantUI;
import UI.MainWindow;
import dataNew.Pratiquant;
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
public class PratiquantMetier {
  public void ajouter(Pratiquant pratiquant){
      
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
        EntityManager em=factory.createEntityManager();       
        em.getTransaction().begin();        
        em.persist(pratiquant);
        em.getTransaction().commit();
        em.close(); 
        
        PratiquantUI pratiquantUI=new PratiquantUI();
        MainWindow.mainLayout.setCenter(pratiquantUI.getLayout()); 
  } 
  
  public void modifier(Pratiquant pratiquant){
      
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
        EntityManager em=factory.createEntityManager();       
        em.getTransaction().begin();        
        em.merge(pratiquant);
        em.getTransaction().commit();
        em.close(); 
        
        PratiquantUI pratiquantUI=new PratiquantUI();
        MainWindow.mainLayout.setCenter(pratiquantUI.getLayout()); 
  } 
  
  public ObservableList<Pratiquant>  getAll(){
      ObservableList<Pratiquant> pratiquants=FXCollections.observableArrayList();
        
     EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
      EntityManager em=factory.createEntityManager();       
      
      em.getTransaction().begin();  
      pratiquants.addAll(em.createNamedQuery("Pratiquant.findAll").getResultList());
      em.getTransaction().commit();
      em.close(); 
        
        
    return pratiquants;    
  }
}
