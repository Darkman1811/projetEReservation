/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import metier.ConnectionEsante;
import metier.Synchronizer;

/**
 *
 * @author darkman
 */
public class MainWindow extends Application {
    static public Stage window;
     static public  BorderPane mainLayout;
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
           @Override
    public void start(Stage primaryStage) {
     window=primaryStage;
     window.setTitle("E-Sante");
     
      mainLayout=new BorderPane();
           
            Label labeltop=new Label("top");
            Label labelbottom=new Label("bottom");
            Label labelWelcome=new Label("Bienvenue sur E-Sante");
            Label labelright=new Label("right");
            Label labelleft=new Label("Menu");
            
//------------------------------------------------------------------------------BANNER LAYOUT            
            HBox bannerLayout=new HBox();
            bannerLayout.setAlignment(Pos.CENTER);
            
            Button btnSynchronizer=new Button("Synchronizer");
            btnSynchronizer.setOnAction(e->{
            Synchronizer.sendData();
            });
            bannerLayout.getChildren().addAll(labeltop,btnSynchronizer);
            
 //-----------------------------------------------------------------------------MENU          
            VBox menuLayout=new VBox();
            menuLayout.setAlignment(Pos.TOP_LEFT);
            
            Button menuBtnClient=new Button("Gestion des Clients");
            menuBtnClient.setMinWidth(150);
            menuBtnClient.setOnAction(e->{
            ClientUI clientUI=new ClientUI();
            mainLayout.setCenter(clientUI.getLayout());
            });
            
            Button menuBtnPratiquant=new Button("Gestion des Pratiquants");
            menuBtnPratiquant.setMinWidth(150);
            menuBtnPratiquant.setOnAction(e->{
            PratiquantUI pratiquantUI=new PratiquantUI();
            mainLayout.setCenter(pratiquantUI.getLayout());
            });
            
            Button menuBtnPlanning=new Button("Gestion des Plannings");
            menuBtnPlanning.setMinWidth(150);
            menuBtnPlanning.setOnAction(e->{
            PlanningUI planningUI=new PlanningUI();
            mainLayout.setCenter(planningUI.getLayout());
            });
            
            Button menuBtnRV=new Button("Gestion des Rendez-vous");
            menuBtnRV.setMinWidth(150);
            menuBtnRV.setOnAction(e->{
            RVUI rvUI=new RVUI();
            mainLayout.setCenter(rvUI.getLayout());
            });
            
            
            Button menuBtnJB=new Button("Gestion des jours bloqués");
            menuBtnJB.setMinWidth(150);
            menuBtnJB.setOnAction(e->{
            JoursBloquesUI jbUI=new JoursBloquesUI();
            mainLayout.setCenter(jbUI.getLayout());
            });
            
            
            Button menuBtnJF=new Button("Gestion des jours fériés");
            menuBtnJF.setMinWidth(150);
            menuBtnJF.setOnAction(e->{
            JoursFeriesUI jfUI=new JoursFeriesUI();
            mainLayout.setCenter(jfUI.getLayout());
            });
            
                 Button btnTester=new Button("Tester");
            btnTester.setMinWidth(150);
            btnTester.setOnAction(e->{
                Client client = ClientBuilder.newClient();
                Response response=client.target("http://localhost:8080/E-santeWeb/rs").path("struct").path("tester").request(MediaType.TEXT_PLAIN).get();
            String res=response.readEntity(String.class);
            System.out.println("Response du serveur rs:"+res);
            });
            menuLayout.getChildren().addAll(labelleft,menuBtnClient,menuBtnPratiquant,menuBtnPlanning,menuBtnRV,menuBtnJB,menuBtnJF,btnTester);
            
 //*****************************************************************************Message box          
             VBox messageLayout=new VBox();
            messageLayout.setAlignment(Pos.TOP_CENTER);
            messageLayout.getChildren().addAll(labelbottom);
 //*****************************************************************************Contenue           
            GridPane contentLayout=new GridPane();           
            contentLayout.getChildren().addAll(labelWelcome);
            
            mainLayout.setTop(bannerLayout);
            mainLayout.setBottom(messageLayout);
            mainLayout.setLeft(menuLayout);
         // mainLayout.setRight(labelright);
            mainLayout.setCenter(contentLayout);
            
            Scene sceneRV=new Scene(mainLayout,600,300);
            
            window.setScene(sceneRV);
            window.setMaximized(true);
            window.show();
     
    }

}
