/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import dataNew.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import metier.ClientMetier;
import metier.ConnectionEsante;
import static metier.ConnectionEsante.connection;

/**
 *
 * @author darkman
 */
public class ClientUI {
    
    ClientMetier cm=new ClientMetier();
    
    
    public  VBox getLayout(){
    VBox contentLayout=new VBox();     
    Label labelcenter=new Label("Gestion des clients");
    Button btnRefresh=new Button("Actualiser");
    btnRefresh.setOnAction(e->{
    TableView<Client> tableClients=getClients();
    });
    Button btnAjouter=new Button("Ajouter Clients");
    btnAjouter.setOnAction(e->{
    ajouterUI();
    });
    Button btnModifier=new Button("Modifier Clients");
    btnModifier.setOnAction(e->{
    modifierUI();
    });
    HBox commandeBox=new HBox(btnRefresh,btnAjouter,btnModifier);
    commandeBox.setPadding(new Insets(8));
   
    TableView<Client> tableClients=getClients();
      System.out.println("test clients");
    contentLayout.getChildren().addAll(labelcenter,commandeBox,tableClients);
    contentLayout.setPadding(new Insets(20));
    return contentLayout;
}
    
    public TableView<Client> getClients(){
        ObservableList<Client> clients=FXCollections.observableArrayList();
       
        clients=cm.getAll();
        //Columns mapping
        TableColumn <Client,Integer> columnId=new TableColumn<>("Id");
        columnId.setMinWidth(50);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn <Client,String> columnPrenom=new TableColumn<>("Prenom");
        columnPrenom.setMinWidth(200);
        columnPrenom.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
        
        TableColumn <Client,String> columnNom=new TableColumn<>("Nom");
        columnNom.setMinWidth(150);
        columnNom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
        
        TableColumn <Client,String> columnPhone=new TableColumn<>("Phone");
        columnPhone.setMinWidth(200);
        columnPhone.setCellValueFactory(new PropertyValueFactory<Client,String>("phone"));
        
        TableColumn <Client,String> columnEmail=new TableColumn<>("Email");
        columnEmail.setMinWidth(200);
        columnEmail.setCellValueFactory(new PropertyValueFactory<Client,String>("email"));
        
        TableColumn <Client,String> columnAge=new TableColumn<>("Age");
        columnAge.setMinWidth(50);
        columnAge.setCellValueFactory(new PropertyValueFactory<Client,String>("age"));
        
        TableColumn <Client,String> columnCivilite=new TableColumn<>("Civilite");
        columnCivilite.setMinWidth(100);
        columnCivilite.setCellValueFactory(new PropertyValueFactory<Client,String>("civilite"));
        
       
        
        TableView<Client> table=new TableView<>();
        table.setItems(clients);
        table.getColumns().addAll(columnId,columnPrenom,columnNom,columnAge,columnEmail,columnPhone,columnCivilite);
        
        return table;
    }
    
    public void ajouterUI(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un client");
        window.setMinWidth(600);
        window.setMinHeight(300); 
        
        Label labelAjoutClient=new Label("Ajouter un client");
        HBox boxTitle=new HBox(labelAjoutClient);
        boxTitle.setAlignment(Pos.CENTER);
        
    /*    Label labelId=new Label("Id:");
        TextField txtId=new TextField();
        HBox boxId=new HBox(labelId,txtId);
     */   
        Label labelPrenom=new Label("Prenom:");
        TextField txtPrenom=new TextField();
        HBox boxPrenom=new HBox(labelPrenom,txtPrenom);
        
        Label labelNom=new Label("Nom:");
        TextField txtNom=new TextField();
        HBox boxNom=new HBox(labelNom,txtNom);
        
        Label labelPhone=new Label("Phone:");
        TextField txtPhone=new TextField();
        HBox boxPhone=new HBox(labelPhone,txtPhone);
        
        Label labelEmail=new Label("Email:");
        TextField txtEmail=new TextField();
        HBox boxEmail=new HBox(labelEmail,txtEmail);
        
        Label labelage=new Label("age:");
        TextField txtage=new TextField();
        HBox boxage=new HBox(labelage,txtage);
        
        Label labelCivilite=new Label("Civilite:");
        TextField txtCivilite=new TextField();
        HBox boxCivilite=new HBox(labelCivilite,txtCivilite);
        
       
        Button btnAjouter=new Button("Ajouter");
        btnAjouter.setOnAction(e->{
      
            Client client=new Client();
//            client.setId(new Integer(txtId.getText()));
            client.setPrenom(txtPrenom.getText());
            client.setNom(txtNom.getText());
            client.setEmail(txtEmail.getText());
            client.setPhone(txtPhone.getText());
            client.setAge(txtage.getText());
            client.setCivilite(txtCivilite.getText());
                
            
            cm.ajouter(client);
                 ClientUI clientUI=new ClientUI();
        MainWindow.mainLayout.setCenter(clientUI.getLayout()); 
        
        });
        Button btnAnnuler=new Button("Annuler");
        HBox boxActions=new HBox(btnAjouter,btnAnnuler);
        
        VBox ajoutLayout=new VBox();
        ajoutLayout.getChildren().addAll(boxTitle,boxPrenom,boxNom,boxPhone,boxEmail,boxage,boxCivilite,boxActions);
        
        
        Scene scene=new Scene(ajoutLayout);
        window.setScene(scene);
        window.showAndWait();
        
        
    }

public void modifierUI(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un client");
        window.setMinWidth(600);
        window.setMinHeight(300); 
        
        Label labelTitle=new Label("Modifier un client");
        HBox boxTitle=new HBox(labelTitle);
        boxTitle.setAlignment(Pos.CENTER);
        
         Label labelId=new Label("Id:");
        TextField txtId=new TextField();
        HBox boxId=new HBox(labelId,txtId);
        
        Label labelPrenom=new Label("Prenom:");
        TextField txtPrenom=new TextField();
        HBox boxPrenom=new HBox(labelPrenom,txtPrenom);
        
        Label labelNom=new Label("Nom:");
        TextField txtNom=new TextField();
        HBox boxNom=new HBox(labelNom,txtNom);
        
        Label labelPhone=new Label("Phone:");
        TextField txtPhone=new TextField();
        HBox boxPhone=new HBox(labelPhone,txtPhone);
        
        Label labelEmail=new Label("Email:");
        TextField txtEmail=new TextField();
        HBox boxEmail=new HBox(labelEmail,txtEmail);
        
        Label labelage=new Label("age:");
        TextField txtage=new TextField();
        HBox boxage=new HBox(labelage,txtage);
        
        Label labelCivilite=new Label("Civilite:");
        TextField txtCivilite=new TextField();
        HBox boxCivilite=new HBox(labelCivilite,txtCivilite);
        
        Button btnModifier=new Button("Modifier");
        btnModifier.setOnAction(e->{
          Client client=new Client();
            client.setId(new Integer(txtId.getText()));
            client.setPrenom(txtPrenom.getText());
            client.setNom(txtNom.getText());
            client.setEmail(txtEmail.getText());
            client.setPhone(txtPhone.getText());
            client.setAge(txtage.getText());
            client.setCivilite(txtCivilite.getText());
         
            cm.modifier(client); 
         });
        Button btnAnnuler=new Button("Annuler");
        HBox boxActions=new HBox(btnModifier,btnAnnuler);
        
        VBox ajoutLayout=new VBox();
        ajoutLayout.getChildren().addAll(boxTitle,boxId,boxPrenom,boxNom,boxPhone,boxEmail,boxage,boxCivilite,boxActions);
        
        
        Scene scene=new Scene(ajoutLayout);
        window.setScene(scene);
        window.showAndWait();
        
    }

}
