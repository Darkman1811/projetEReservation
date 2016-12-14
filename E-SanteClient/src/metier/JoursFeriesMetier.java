/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import UI.JoursFeriesUI;
import UI.RVUI;
import UI.MainWindow;
import dataNew.JoursFeries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
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
public class JoursFeriesMetier {
  public void ajouter(JoursFeries joursFeries){
      
         EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
        EntityManager em=factory.createEntityManager();       
        em.getTransaction().begin();        
        em.persist(joursFeries);
        em.getTransaction().commit();
        em.close();
        
        JoursFeriesUI jfUI=new JoursFeriesUI();
        MainWindow.mainLayout.setCenter(jfUI.getLayout()); 
  } 
  
  public void modifier(JoursFeries joursFeries){
      
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
        EntityManager em=factory.createEntityManager();       
        em.getTransaction().begin();        
        em.merge(joursFeries);
        em.getTransaction().commit();
        em.close();
        
        JoursFeriesUI jfUI=new JoursFeriesUI();
        MainWindow.mainLayout.setCenter(jfUI.getLayout()); 
  } 
  
  public ObservableList<JoursFeries>  getAll(){
      ObservableList<JoursFeries> joursFeries=FXCollections.observableArrayList();
        
       EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
      EntityManager em=factory.createEntityManager();       
      
      em.getTransaction().begin();  
      joursFeries.addAll(em.createNamedQuery("JoursFeries.findAll").getResultList());
      em.getTransaction().commit();
      em.close(); 
        
    return joursFeries;    
  }
}
