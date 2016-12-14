/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import UI.RVUI;
import UI.MainWindow;
import dataNew.RV;
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
public class RVMetier {
  public void ajouter(RV rv){
      
       EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
       EntityManager em=factory.createEntityManager();       
       em.getTransaction().begin();        
       em.persist(rv);
       em.getTransaction().commit();
       em.close();  
       
       RVUI pratiquantUI=new RVUI();
       MainWindow.mainLayout.setCenter(pratiquantUI.getLayout()); 
  } 
  
  public void modifier(RV rv){
      
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
        EntityManager em=factory.createEntityManager();       
        em.getTransaction().begin();        
        em.merge(rv);
        em.getTransaction().commit();
        em.close();  
        
        RVUI pratiquantUI=new RVUI();
        MainWindow.mainLayout.setCenter(pratiquantUI.getLayout()); 
  } 
  
  public ObservableList<RV>  getAll(){
      ObservableList<RV> rvs=FXCollections.observableArrayList();
        
      EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
      EntityManager em=factory.createEntityManager();       
      
      em.getTransaction().begin();  
      rvs.addAll(em.createNamedQuery("RV.findAll").getResultList());
      em.getTransaction().commit();
      em.close(); 
        
        
    return rvs;    
  }
}
