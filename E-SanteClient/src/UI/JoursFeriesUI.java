/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import dataNew.JoursFeries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
import metier.JoursFeriesMetier;

/**
 *
 * @author darkman
 */
public class JoursFeriesUI {
    
    JoursFeriesMetier cm=new JoursFeriesMetier();
    
    public  VBox getLayout(){
    VBox contentLayout=new VBox();     
    Label labelcenter=new Label("Gestion des Jours fériéss");
    Button btnAjouter=new Button("Ajouter JoursFeriess");
    btnAjouter.setOnAction(e->{
    ajouterUI();
    });
    Button btnModifier=new Button("Modifier Jours fériéss");
    btnModifier.setOnAction(e->{
    modifierUI();
    });
    HBox commandeBox=new HBox(btnAjouter,btnModifier);
    commandeBox.setPadding(new Insets(8));
   
    TableView<JoursFeries> tableJoursFeries=getJoursFeries();
     
    contentLayout.getChildren().addAll(labelcenter,commandeBox,tableJoursFeries);
    contentLayout.setPadding(new Insets(20));
    return contentLayout;
}
    
    public TableView<JoursFeries> getJoursFeries(){
        ObservableList<JoursFeries> JoursFeries=FXCollections.observableArrayList();
        JoursFeries=cm.getAll();
        //Columns mapping
        TableColumn <JoursFeries,Integer> columnId=new TableColumn<>("Id");
        columnId.setMinWidth(50);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn <JoursFeries,String> columnFete=new TableColumn<>("Fete");
        columnFete.setMinWidth(200);
        columnFete.setCellValueFactory(new PropertyValueFactory<JoursFeries,String>("fete"));
        
        TableColumn <JoursFeries,String> columnDate=new TableColumn<>("Date férié");
        columnDate.setMinWidth(150);
        columnDate.setCellValueFactory(new PropertyValueFactory<JoursFeries,String>("date_bloque"));
        
       
       
        
        TableView<JoursFeries> table=new TableView<>();
        table.setItems(JoursFeries);
        table.getColumns().addAll(columnId,columnFete,columnDate);
        
        return table;
    }
    
    public void ajouterUI(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un Jours fériés");
        window.setMinWidth(600);
        window.setMinHeight(300); 
        
        Label labelAjoutJoursFeries=new Label("Ajouter un Jours fériés");
        HBox boxTitle=new HBox(labelAjoutJoursFeries);
        boxTitle.setAlignment(Pos.CENTER);
        
        Label labelId=new Label("Id:");
        TextField txtId=new TextField();
        HBox boxId=new HBox(labelId,txtId);
        
        Label labelFete=new Label("Fete:");
        TextField txtFete=new TextField();
        HBox boxFete=new HBox(labelFete,txtFete);
        
        Label labelDate=new Label("Date:");
        DatePicker txtDate=new DatePicker();
        HBox boxDate=new HBox(labelDate,txtDate);
        
        
        Button btnAjouter=new Button("Ajouter");
        btnAjouter.setOnAction(e->{
        JoursFeries joursFeries=new JoursFeries();
        joursFeries.setId(new Integer(txtId.getText()));
        joursFeries.setDate_bloque(txtDate.getValue());
        joursFeries.setFete(txtFete.getText());
        
        cm.ajouter(joursFeries);
        });
        Button btnAnnuler=new Button("Annuler");
        HBox boxActions=new HBox(btnAjouter,btnAnnuler);
        
        VBox ajoutLayout=new VBox();
        ajoutLayout.getChildren().addAll(boxTitle,boxId,boxFete,boxDate,boxActions);
        
        
        Scene scene=new Scene(ajoutLayout);
        window.setScene(scene);
        window.showAndWait();
        
    }

public void modifierUI(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un Jours fériés");
        window.setMinWidth(600);
        window.setMinHeight(300); 
        
        Label labelTitle=new Label("Modifier un Jours fériés");
        HBox boxTitle=new HBox(labelTitle);
        boxTitle.setAlignment(Pos.CENTER);
        
           Label labelId=new Label("Id:");
        TextField txtId=new TextField();
        HBox boxId=new HBox(labelId,txtId);
            
        Label labelFete=new Label("Fete:");
        TextField txtFete=new TextField();
        HBox boxFete=new HBox(labelFete,txtFete);
        
        Label labelDate=new Label("Date:");
        DatePicker txtDate=new DatePicker();
        HBox boxDate=new HBox(labelDate,txtDate);
        
        
        Button btnModifier=new Button("Modifier");
        btnModifier.setOnAction(e->{
        JoursFeries joursFeries=new JoursFeries();
        joursFeries.setId(new Integer(txtId.getText()));
        joursFeries.setDate_bloque(txtDate.getValue());
        joursFeries.setFete(txtFete.getText());
        
        cm.modifier(joursFeries);
        });
        Button btnAnnuler=new Button("Annuler");
        HBox boxActions=new HBox(btnModifier,btnAnnuler);
        
        VBox ajoutLayout=new VBox();
        ajoutLayout.getChildren().addAll(boxTitle,boxId,boxFete,boxDate,boxActions);
        
        
        
        Scene scene=new Scene(ajoutLayout);
        window.setScene(scene);
        window.showAndWait();
        
    }

}
