/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import UI.JoursBloquesUI;
import UI.RVUI;
import UI.MainWindow;
import dataNew.JoursBloques;
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
public class JoursBloquesMetier {
  public void ajouter(JoursBloques joursBloques){
      
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
        EntityManager em=factory.createEntityManager();       
        em.getTransaction().begin();        
        em.persist(joursBloques);
        em.getTransaction().commit();
        em.close(); 
        
        JoursBloquesUI jfUI=new JoursBloquesUI();
        MainWindow.mainLayout.setCenter(jfUI.getLayout()); 
  } 
  
  public void modifier(JoursBloques joursBloques){
      
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
        EntityManager em=factory.createEntityManager();       
        em.getTransaction().begin();        
        em.merge(joursBloques);
        em.getTransaction().commit();
        em.close(); 
        
        JoursBloquesUI jfUI=new JoursBloquesUI();
        MainWindow.mainLayout.setCenter(jfUI.getLayout()); 
  } 
  
  public ObservableList<JoursBloques>  getAll(){
      ObservableList<JoursBloques> joursBloques=FXCollections.observableArrayList();
        
      EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
      EntityManager em=factory.createEntityManager();       
      
      em.getTransaction().begin();  
      joursBloques.addAll(em.createNamedQuery("JoursBloques.findAll").getResultList());
      em.getTransaction().commit();
      em.close(); 
      
    return joursBloques;    
  }
}
