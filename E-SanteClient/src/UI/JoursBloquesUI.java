/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import dataNew.JoursBloques;
import java.time.LocalTime;
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
import jfxtras.scene.control.CalendarTimeTextField;
import metier.JoursBloquesMetier;

/**
 *
 * @author darkman
 */
public class JoursBloquesUI {
    
    JoursBloquesMetier cm=new JoursBloquesMetier();
    
    public  VBox getLayout(){
    VBox contentLayout=new VBox();     
    Label labelcenter=new Label("Gestion des Jours Bloqués");
    Button btnAjouter=new Button("Ajouter JoursBloquess");
    btnAjouter.setOnAction(e->{
        ajouterUI();
    });
    Button btnModifier=new Button("Modifier Jours Bloqués");
    btnModifier.setOnAction(e->{
    modifierUI();
    });
    HBox commandeBox=new HBox(btnAjouter,btnModifier);
    commandeBox.setPadding(new Insets(8));
   
    TableView<JoursBloques> tableJoursBloques=getJoursBloques();
     
    contentLayout.getChildren().addAll(labelcenter,commandeBox,tableJoursBloques);
    contentLayout.setPadding(new Insets(20));
    return contentLayout;
}
    
    public TableView<JoursBloques> getJoursBloques(){
        ObservableList<JoursBloques> JoursBloques=FXCollections.observableArrayList();
        JoursBloques=cm.getAll();
        //Columns mapping
        TableColumn <JoursBloques,Integer> columnId=new TableColumn<>("Id");
        columnId.setMinWidth(50);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn <JoursBloques,String> columnDate=new TableColumn<>("Date blocage");
        columnDate.setMinWidth(200);
        columnDate.setCellValueFactory(new PropertyValueFactory<JoursBloques,String>("date_bloque"));
        
        
        TableColumn <JoursBloques,String> columnDebut=new TableColumn<>("Debut blocage");
        columnDebut.setMinWidth(200);
        columnDebut.setCellValueFactory(new PropertyValueFactory<JoursBloques,String>("debut_debut_bloque"));
        
        TableColumn <JoursBloques,String> columnFin=new TableColumn<>("Fin blocage");
        columnFin.setMinWidth(200);
        columnFin.setCellValueFactory(new PropertyValueFactory<JoursBloques,String>("date_fin_bloque"));
        
        
        TableColumn <JoursBloques,String> columnRaison=new TableColumn<>("Raison");
        columnRaison.setMinWidth(150);
        columnRaison.setCellValueFactory(new PropertyValueFactory<JoursBloques,String>("raison"));
        
       
       
        
        TableView<JoursBloques> table=new TableView<>();
        table.setItems(JoursBloques);
        table.getColumns().addAll(columnId,columnDate,columnDebut,columnFin,columnRaison);
        
        return table;
    }
    
    public void ajouterUI(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un Jours Bloqués");
        window.setMinWidth(600);
        window.setMinHeight(300); 
        
        Label labelAjoutJoursBloques=new Label("Ajouter un Jours Bloqués");
        HBox boxTitle=new HBox(labelAjoutJoursBloques);
        boxTitle.setAlignment(Pos.CENTER);
        
        Label labelId=new Label("Id:");
        TextField txtId=new TextField();
        HBox boxId=new HBox(labelId,txtId);
        
               
        Label labelDate=new Label("Date:");
        DatePicker txtDate=new DatePicker();
        HBox boxDate=new HBox(labelDate,txtDate);
        
        Label labeldebut=new Label("Heure début blocage:");     
        CalendarTimeTextField txtdebut=new CalendarTimeTextField();        
        HBox boxDebut=new HBox(labeldebut,txtdebut);
        
        Label labelFin=new Label("Heure fin blocage:");     
        CalendarTimeTextField txtFin=new CalendarTimeTextField();        
        HBox boxFin=new HBox(labelFin,txtFin);
        
         Label labelRaison=new Label("Fete:");
        TextField txtRaison=new TextField();
        HBox boxRaison=new HBox(labelRaison,txtRaison);
        
        Button btnAjouter=new Button("Ajouter");
        btnAjouter.setOnAction(e->{
        JoursBloques joursBloques=new JoursBloques();
        joursBloques.setId(new Integer(txtId.getText()));
        joursBloques.setDate_bloque(txtDate.getValue());
        joursBloques.setDebut_debut_bloque(LocalTime.of(txtdebut.getCalendar().getTime().getHours(),txtdebut.getCalendar().getTime().getMinutes()));
        joursBloques.setDate_fin_bloque(LocalTime.of(txtFin.getCalendar().getTime().getHours(),txtFin.getCalendar().getTime().getMinutes()));
        joursBloques.setRaison(txtRaison.getText());
        
        cm.ajouter(joursBloques);
        });
        Button btnAnnuler=new Button("Annuler");
        HBox boxActions=new HBox(btnAjouter,btnAnnuler);
        
        VBox ajoutLayout=new VBox();
        ajoutLayout.getChildren().addAll(boxTitle,boxId,boxRaison,boxDate,boxDebut,boxFin,boxActions);
        
        
        Scene scene=new Scene(ajoutLayout);
        window.setScene(scene);
        window.showAndWait();
        
    }

public void modifierUI(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un Jours Bloqués");
        window.setMinWidth(600);
        window.setMinHeight(300); 
        
        Label labelTitle=new Label("Modifier un Jours Bloqués");
        HBox boxTitle=new HBox(labelTitle);
        boxTitle.setAlignment(Pos.CENTER);
        
        
        Label labelId=new Label("Id:");
        TextField txtId=new TextField();
        HBox boxId=new HBox(labelId,txtId);
        
               
        Label labelDate=new Label("Date:");
        DatePicker txtDate=new DatePicker();
        HBox boxDate=new HBox(labelDate,txtDate);
        
        Label labeldebut=new Label("Heure début blocage:");     
        CalendarTimeTextField txtdebut=new CalendarTimeTextField();        
        HBox boxDebut=new HBox(labeldebut,txtdebut);
        
        Label labelFin=new Label("Heure fin blocage:");     
        CalendarTimeTextField txtFin=new CalendarTimeTextField();        
        HBox boxFin=new HBox(labelFin,txtFin);
        
         Label labelRaison=new Label("Fete:");
        TextField txtRaison=new TextField();
        HBox boxRaison=new HBox(labelRaison,txtRaison);
        
        Button btnModifier=new Button("Ajouter");
        btnModifier.setOnAction(e->{
        JoursBloques joursBloques=new JoursBloques();
        joursBloques.setId(new Integer(txtId.getText()));
        joursBloques.setDate_bloque(txtDate.getValue());
        joursBloques.setDebut_debut_bloque(LocalTime.of(txtdebut.getCalendar().getTime().getHours(),txtdebut.getCalendar().getTime().getMinutes()));
        joursBloques.setDate_fin_bloque(LocalTime.of(txtFin.getCalendar().getTime().getHours(),txtFin.getCalendar().getTime().getMinutes()));
        joursBloques.setRaison(txtRaison.getText());
        
        cm.modifier(joursBloques);
        });
        
        Button btnAnnuler=new Button("Annuler");
        HBox boxActions=new HBox(btnModifier,btnAnnuler);
        
        VBox ajoutLayout=new VBox();
        ajoutLayout.getChildren().addAll(boxTitle,boxId,boxRaison,boxDate,boxDebut,boxFin,boxActions);
       
        
        
        Scene scene=new Scene(ajoutLayout);
        window.setScene(scene);
        window.showAndWait();
        
    }

}
