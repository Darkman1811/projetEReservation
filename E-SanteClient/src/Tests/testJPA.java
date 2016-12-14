/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Sync.DataSync;
import dataNew.JoursBloques;
import dataNew.Pays;
import dataNew.Planning;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import metier.JoursBloquesMetier;
import org.osgi.service.jpa.EntityManagerFactoryBuilder;
/**
 *
 * @author Super
 */

public class testJPA extends Application {
    Stage window;
    
  
    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {
    window=primarystage;
    window.setTitle("JavaFX - thenewboston");
    
     Label msg=new Label("Text");
    Button btn=new Button("Tester");
    btn.setOnAction(e->{
     // msg.setText(testerRest());
        testerRest3();
        
      /*  EntityManagerFactory factory=Persistence.createEntityManagerFactory("ESanteClientPU");
        EntityManager em=factory.createEntityManager();
        
        em.getTransaction().begin();
        
        Pays pays=new Pays();
        pays.setIndicatif_telephonique("+221");
        pays.setMonaie("Fcfa");
        pays.setNom_pays("Sénégal");
        pays.setTaux(new Float(655));
        pays.setRegions(null);
        em.persist(pays);
        em.getTransaction().commit();
        em.close();
        */
        
    });
              
   
    VBox vBox=new VBox(10,btn,msg);
    vBox.setAlignment(Pos.CENTER);
    
    
    Scene scene= new Scene(vBox,300,200);    
    window.setScene(scene); 
    window.show();
    }

    public String testerRest(){
             Client client = ClientBuilder.newClient();
                Response response=client.target("http://localhost:8080/E-santeWeb/rs").path("struct").path("tester").request(MediaType.TEXT_PLAIN).get();
            String res=response.readEntity(String.class);
            return(res);
    }
  
    public String testerRest2(){
   
            Client client = ClientBuilder.newClient();
            JoursBloques jb=new JoursBloques();
            jb.setId(2);
            jb.setDate_bloque(LocalDate.now());
            jb.setDate_fin_bloque(LocalTime.now());
            jb.setDebut_debut_bloque(LocalTime.now());
            jb.setRaison("pas de raison");
            StringWriter sw=new StringWriter();
          
            Response response=client.target("http://localhost:8080/E-santeWeb/rs").path("sync").path("JoursBloques").request(MediaType.APPLICATION_XML).put(Entity.xml(jb));
        
        return("dodo");
    }
  
    
      public String testerRest3
        (){
            JoursBloquesMetier cm=new JoursBloquesMetier();
            List<JoursBloques> lst=new ArrayList<JoursBloques>();
            lst.addAll(cm.getAll());
            
            DataSync sync=new DataSync();
            sync.setJoursBloques(lst);
            Client client = ClientBuilder.newClient();
            
            Response response=client.target("http://localhost:8080/E-santeWeb/rs").path("sync").path("ListJoursBloques").request(MediaType.APPLICATION_XML).put(Entity.xml(sync));
      
        return("dodo");
    }
  
}
