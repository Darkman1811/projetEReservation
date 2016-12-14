/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import dataNew.Client;
import dataNew.Planning;
import dataNew.Pratiquant;
import dataNew.RV;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import jfxtras.scene.control.CalendarTextField;
import jfxtras.scene.control.CalendarTimeTextField;
import jfxtras.scene.control.CalendarTimeTextField;
import metier.ClientMetier;
import metier.PlanningMetier;
import metier.PratiquantMetier;
import metier.RVMetier;

/**
 *
 * @author darkman
 */
public class RVUI {
    
    RVMetier cm= new RVMetier();
    PlanningMetier pcm=new PlanningMetier();
    ClientMetier ccm=new ClientMetier();
    PratiquantMetier prcm=new PratiquantMetier();
    
    public  VBox getLayout(){
    VBox contentLayout=new VBox();     
    Label labelcenter=new Label("Gestion des Rendez-vous");
    Button btnAjouter=new Button("Ajouter Rendez-vous");
    btnAjouter.setOnAction(e->{
    ajouterUI();
    });
    Button btnModifier=new Button("Modifier Rendez-vous");
    btnModifier.setOnAction(e->{
    modifierUI();
    });
    HBox commandeBox=new HBox(btnAjouter,btnModifier);
    commandeBox.setPadding(new Insets(8));
   
    TableView<RV> tableRVss=getRVs();
     
    contentLayout.getChildren().addAll(labelcenter,commandeBox,tableRVss);
    contentLayout.setPadding(new Insets(20));
    return contentLayout;
}
    
    public TableView<RV> getRVs(){
        ObservableList<RV> rvs=FXCollections.observableArrayList();
        
        rvs=cm.getAll();
        
        //Columns mapping
        TableColumn <RV,Integer> columnId=new TableColumn<>("Id");
        columnId.setMinWidth(50);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn <RV,String> columnEtat=new TableColumn<>("Etat");
        columnEtat.setMinWidth(200);
        columnEtat.setCellValueFactory(new PropertyValueFactory<RV,String>("etat"));
        
        TableColumn <RV,String> columnCode=new TableColumn<>("Code");
        columnCode.setMinWidth(150);
        columnCode.setCellValueFactory(new PropertyValueFactory<RV,String>("codeRV"));
        
        TableColumn <RV,String> columnDate=new TableColumn<>("Date");
        columnDate.setMinWidth(200);
        columnDate.setCellValueFactory(new PropertyValueFactory<RV,String>("dateRV"));
        
        TableColumn <RV,String> columnDebut=new TableColumn<>("Début");
        columnDebut.setMinWidth(200);
        columnDebut.setCellValueFactory(new PropertyValueFactory<RV,String>("heureDebutRV"));
        
        TableColumn <RV,String> columnFin=new TableColumn<>("Fin");
        columnFin.setMinWidth(50);
        columnFin.setCellValueFactory(new PropertyValueFactory<RV,String>("heureFinRV"));
        
        TableColumn <RV,Planning> columnPlanning=new TableColumn<>("Planning");
        columnPlanning.setMinWidth(50);
        columnPlanning.setCellValueFactory(new PropertyValueFactory<RV,Planning>("planning"));
        
        
        TableColumn <RV,Client> columnClient=new TableColumn<>("Client");
        columnClient.setMinWidth(50);
        columnClient.setCellValueFactory(new PropertyValueFactory<RV,Client>("client"));
       
        
        TableColumn <RV,Pratiquant> columnPratiquant=new TableColumn<>("Pratiquant");
        columnPratiquant.setMinWidth(50);
        columnPratiquant.setCellValueFactory(new PropertyValueFactory<RV,Pratiquant>("pratiquant"));
       
        TableView<RV> table=new TableView<>();
        table.setItems(rvs);
        table.getColumns().addAll(columnId,columnCode,columnEtat,columnDate,columnDebut,columnFin,columnPlanning,columnClient,columnPratiquant);
        
        return table;
    }
    
    public void ajouterUI(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un Rendez-vous");
        window.setMinWidth(600);
        window.setMinHeight(300); 
        
        Label labelAjoutRV=new Label("Ajouter un Rendez-vous");
        HBox boxTitle=new HBox(labelAjoutRV);
        boxTitle.setAlignment(Pos.CENTER);
        
         Label labelId=new Label("Id:");
        TextField txtId=new TextField();
        HBox boxId=new HBox(labelId,txtId);
        
        Label labelCode=new Label("Code:");
        TextField txtCode=new TextField();
        HBox boxCode=new HBox(labelCode,txtCode);
        
        Label labelEtat=new Label("Etat:");
        TextField txtEtat=new TextField();
        HBox boxEtat=new HBox(labelEtat,txtEtat);
        
        Label labelDate=new Label("Date:");
        DatePicker txtDate=new DatePicker();
        HBox boxDate=new HBox(labelDate,txtDate);
        
        Label labelDebut=new Label("Debut:");
        CalendarTimeTextField txtDebut=new CalendarTimeTextField();
        HBox boxDebut=new HBox(labelDebut,txtDebut);
        
        Label labelFin=new Label("Fin:");
        CalendarTimeTextField txtFin=new CalendarTimeTextField();
        HBox boxFin=new HBox(labelFin,txtFin);
        
        Label labelPlanning=new Label("Planning");
        ChoiceBox<Planning> choicePlanning=new ChoiceBox();
        choicePlanning.getItems().addAll(pcm.getAll());       
        HBox boxPlanning=new HBox(labelPlanning,choicePlanning);
        
         Label labelClient=new Label("Client");
        ChoiceBox<Client> choiceClient=new ChoiceBox();
        choiceClient.getItems().addAll(ccm.getAll());       
        HBox boxClient=new HBox(labelClient,choiceClient);
        
         Label labelPratiquant=new Label("Pratiquant");
        ChoiceBox<Pratiquant> choicePratiquant=new ChoiceBox();
        choicePratiquant.getItems().addAll(prcm.getAll());       
        HBox boxPratiquant=new HBox(labelPratiquant,choicePratiquant);
               
        Button btnAjouter=new Button("Ajouter");
        btnAjouter.setOnAction(e->{
        RV rv=new RV();
        rv.setId(new Integer(txtId.getText()));
        
        rv.setDateRV(txtDate.getValue());
        rv.setHeureDebutRV(LocalTime.of(txtDebut.getCalendar().getTime().getHours(),txtFin.getCalendar().getTime().getMinutes()));
        rv.setHeureFinRV(LocalTime.of(txtFin.getCalendar().getTime().getHours(), txtFin.getCalendar().getTime().getMinutes()));
        rv.setEtat(txtEtat.getText());
        rv.setCodeRV(txtCode.getText());
        rv.setPlanning(choicePlanning.getValue());
        rv.setClient(choiceClient.getValue());
        rv.setPratiquant(choicePratiquant.getValue());
        
        cm.ajouter(rv);
        });
        Button btnAnnuler=new Button("Annuler");
        HBox boxActions=new HBox(btnAjouter,btnAnnuler);
        
        VBox ajoutLayout=new VBox();
        ajoutLayout.getChildren().addAll(boxTitle,boxId,boxCode,boxEtat,boxDate,boxDebut,boxFin,boxPlanning,boxClient,boxPratiquant,boxActions);
        
        
        Scene scene=new Scene(ajoutLayout);
        window.setScene(scene);
        window.showAndWait();
        
    }

public void modifierUI(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un Rendez-vous");
        window.setMinWidth(600);
        window.setMinHeight(300); 
        
        Label labelTitle=new Label("Modifier un Rendez-vous");
        HBox boxTitle=new HBox(labelTitle);
        boxTitle.setAlignment(Pos.CENTER);
        
        Label labelId=new Label("Id:");
        TextField txtId=new TextField();
        HBox boxId=new HBox(labelId,txtId);
         
        Label labelCode=new Label("Code:");
        TextField txtCode=new TextField();
        HBox boxCode=new HBox(labelCode,txtCode);
        
        Label labelEtat=new Label("Etat:");
        TextField txtEtat=new TextField();
        HBox boxEtat=new HBox(labelEtat,txtEtat);
        
        Label labelDate=new Label("Date:");
        DatePicker txtDate=new DatePicker();
        HBox boxDate=new HBox(labelDate,txtDate);
        
        Label labelDebut=new Label("Debut:");
        CalendarTimeTextField txtDebut=new CalendarTimeTextField();
        HBox boxDebut=new HBox(labelDebut,txtDebut);
        
        Label labelFin=new Label("Fin:");
        CalendarTimeTextField txtFin=new CalendarTimeTextField();
        HBox boxFin=new HBox(labelFin,txtFin);
        
         Label labelPlanning=new Label("Planning");
        ChoiceBox<Planning> choicePlanning=new ChoiceBox();
        choicePlanning.getItems().addAll(pcm.getAll());       
        HBox boxPlanning=new HBox(labelPlanning,choicePlanning);
        
         Label labelClient=new Label("Client");
        ChoiceBox<Client> choiceClient=new ChoiceBox();
        choiceClient.getItems().addAll(ccm.getAll());       
        HBox boxClient=new HBox(labelClient,choiceClient);
        
         Label labelPratiquant=new Label("Pratiquant");
        ChoiceBox<Pratiquant> choicePratiquant=new ChoiceBox();
        choicePratiquant.getItems().addAll(prcm.getAll());       
        HBox boxPratiquant=new HBox(labelPratiquant,choicePratiquant);
               
        Button btnModifier=new Button("Modifier");
        btnModifier.setOnAction(e->{
        RV rv=new RV();
        rv.setId(new Integer(txtId.getText()));
        rv.setDateRV(txtDate.getValue());
        rv.setHeureDebutRV(LocalTime.of(txtDebut.getCalendar().getTime().getHours(),txtFin.getCalendar().getTime().getMinutes()));
        rv.setHeureFinRV(LocalTime.of(txtFin.getCalendar().getTime().getHours(), txtFin.getCalendar().getTime().getMinutes()));
         rv.setEtat(txtEtat.getText());
        rv.setCodeRV(txtCode.getText());
        rv.setPlanning(choicePlanning.getValue());
        rv.setClient(choiceClient.getValue());
        rv.setPratiquant(choicePratiquant.getValue());
        
        cm.modifier(rv);
        });
        Button btnAnnuler=new Button("Annuler");
        HBox boxActions=new HBox(btnModifier,btnAnnuler);
        
        VBox ajoutLayout=new VBox();
        ajoutLayout.getChildren().addAll(boxTitle,boxId,boxCode,boxEtat,boxDate,boxDebut,boxFin,boxPlanning,boxClient,boxPratiquant,boxActions);
        
        
        Scene scene=new Scene(ajoutLayout);
        window.setScene(scene);
        window.showAndWait();
        
    }

}
