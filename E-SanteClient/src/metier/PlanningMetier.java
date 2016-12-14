/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import UI.PlanningUI;
import UI.MainWindow;
import dataNew.Planning;
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
public class PlanningMetier {
  public void ajouter(Planning Planning){
      
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
        EntityManager em=factory.createEntityManager();       
        em.getTransaction().begin();        
        em.persist(Planning);
        em.getTransaction().commit();
        em.close();
        
        PlanningUI PlanningUI=new PlanningUI();
        MainWindow.mainLayout.setCenter(PlanningUI.getLayout()); 
  } 
  
  public void modifier(Planning planning){
      
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
        EntityManager em=factory.createEntityManager();       
        em.getTransaction().begin();        
        em.merge(planning);
        em.getTransaction().commit();
        em.close();
        
        PlanningUI PlanningUI=new PlanningUI();
        MainWindow.mainLayout.setCenter(PlanningUI.getLayout()); 
  } 
  
  public ObservableList<Planning>  getAll(){
      ObservableList<Planning> plannings=FXCollections.observableArrayList();
        
      EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
      EntityManager em=factory.createEntityManager();       
      
      em.getTransaction().begin();  
      plannings.addAll(em.createNamedQuery("Planning.findAll").getResultList());
      em.getTransaction().commit();
      em.close(); 
      
    return plannings;    
  }
}
