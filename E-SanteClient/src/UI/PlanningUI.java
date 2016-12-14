/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import dataNew.Planning;
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
import jfxtras.scene.control.CalendarTimePicker;
import jfxtras.scene.control.CalendarTimeTextField;


import jfxtras.scene.control.LocalDateTimePicker;
import metier.PlanningMetier;

/**
 *
 * @author darkman
 */
public class PlanningUI {
    
    PlanningMetier cm=new PlanningMetier();
    
    public  VBox getLayout(){
    VBox contentLayout=new VBox();     
    Label labelcenter=new Label("Gestion des plannings");
    Button btnAjouter=new Button("Ajouter Plannings");
    btnAjouter.setOnAction(e->{
    ajouterUI();
    });
    Button btnModifier=new Button("Modifier Plannings");
    btnModifier.setOnAction(e->{
    modifierUI();
    });
    HBox commandeBox=new HBox(btnAjouter,btnModifier);
    commandeBox.setPadding(new Insets(8));
   
    TableView<Planning> tablePlannings=getPlannings();
     
    contentLayout.getChildren().addAll(labelcenter,commandeBox,tablePlannings);
    contentLayout.setPadding(new Insets(20));
    return contentLayout;
}
    
    public TableView<Planning> getPlannings(){
        ObservableList<Planning> plannings=FXCollections.observableArrayList();
        
        plannings=cm.getAll();
        
        //Columns mapping
        TableColumn <Planning,Integer> columnId=new TableColumn<>("Id");
        columnId.setMinWidth(50);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        
        TableColumn <Planning,String> columnOuverture=new TableColumn<>("Ouverture");
        columnOuverture.setMinWidth(200);
        columnOuverture.setCellValueFactory(new PropertyValueFactory<Planning,String>("heure_ouverture"));
        
        TableColumn <Planning,String> columnFermeture=new TableColumn<>("Fermeture");
        columnFermeture.setMinWidth(150);
        columnFermeture.setCellValueFactory(new PropertyValueFactory<Planning,String>("heure_fermeture"));
        
        TableColumn <Planning,String> columnJour=new TableColumn<>("Jours de la semaine");
        columnJour.setMinWidth(200);
        columnJour.setCellValueFactory(new PropertyValueFactory<Planning,String>("jours_de_semaine"));
        
        
       
        
        TableView<Planning> table=new TableView<>();
        table.setItems(plannings);
        table.getColumns().addAll(columnId,columnOuverture,columnFermeture,columnJour);
        
        return table;
    }
    
    public void ajouterUI(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un planning");
        window.setMinWidth(600);
        window.setMinHeight(300); 
        
        Label labelAjoutPlanning=new Label("Ajouter un planning");
        HBox boxTitle=new HBox(labelAjoutPlanning);
        boxTitle.setAlignment(Pos.CENTER);
        
        Label labelId=new Label("Id:");
        TextField txtId=new TextField();
        HBox boxId=new HBox(labelId,txtId);
        
        Label labelJour=new Label("Jours de la semaine:");
        DatePicker txtJours=new DatePicker();//new TextField();
        HBox boxJours=new HBox(labelJour,txtJours);
        
        Label labelOuverture=new Label("Heure ouverture:");     
        CalendarTimeTextField txtOuverture=new CalendarTimeTextField();        
        HBox boxOuverture=new HBox(labelOuverture,txtOuverture);
        
        Label labelFermeture=new Label("Heure fermeture:");
        CalendarTimeTextField txtFermeture=new CalendarTimeTextField();
        HBox boxFermeture=new HBox(labelFermeture,txtFermeture);
        
      
        
        Button btnAjouter=new Button("Ajouter");
        btnAjouter.setOnAction(e->{
        Planning planning=new Planning();
        planning.setId(new Integer(txtId.getText()));
        
        planning.setJours_de_semaine(txtJours.getEditor().getText());
        planning.setHeure_ouverture(txtOuverture.getCalendar().getTime());
        planning.setHeure_fermeture(txtFermeture.getCalendar().getTime());
        cm.ajouter(planning);
        });
        Button btnAnnuler=new Button("Annuler");
        HBox boxActions=new HBox(btnAjouter,btnAnnuler);
        
        VBox ajoutLayout=new VBox();
        ajoutLayout.getChildren().addAll(boxTitle,boxId,boxJours,boxOuverture,boxFermeture,boxActions);
        
        
        Scene scene=new Scene(ajoutLayout);
        window.setScene(scene);
        window.showAndWait();
        
    }

public void modifierUI(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un planning");
        window.setMinWidth(600);
        window.setMinHeight(300); 
        
        Label labelTitle=new Label("Modifier un planning");
        HBox boxTitle=new HBox(labelTitle);
        boxTitle.setAlignment(Pos.CENTER);
        
         Label labelId=new Label("Id:");
        TextField txtId=new TextField();
        HBox boxId=new HBox(labelId,txtId);
       
            
        Label labelJour=new Label("Jours de la semaine:");
        DatePicker txtJours=new DatePicker();//new TextField();
        HBox boxJours=new HBox(labelJour,txtJours);
        
       
         Label labelOuverture=new Label("Heure ouverture:");     
        CalendarTimeTextField txtOuverture=new CalendarTimeTextField();        
        HBox boxOuverture=new HBox(labelOuverture,txtOuverture);
        
        Label labelFermeture=new Label("Heure fermeture:");
        CalendarTimeTextField txtFermeture=new CalendarTimeTextField();
        HBox boxFermeture=new HBox(labelFermeture,txtFermeture);
        
        
        Button btnModifier=new Button("Modifier");
        btnModifier.setOnAction(e->{
        Planning planning=new Planning();
        planning.setId(new Integer(txtId.getText()));
        
        planning.setJours_de_semaine(txtJours.getEditor().getText());
        planning.setHeure_ouverture(txtOuverture.getCalendar().getTime());
        planning.setHeure_fermeture(txtFermeture.getCalendar().getTime());
        cm.modifier(planning);
        });
        Button btnAnnuler=new Button("Annuler");
        HBox boxActions=new HBox(btnModifier,btnAnnuler);
        
        VBox ajoutLayout=new VBox();
        ajoutLayout.getChildren().addAll(boxTitle,boxId,boxJours,boxOuverture,boxFermeture,boxActions);
        
        
        Scene scene=new Scene(ajoutLayout);
        window.setScene(scene);
        window.showAndWait();
        
    }

}
