/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import dataNew.Pratiquant;
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
import metier.PratiquantMetier;

/**
 *
 * @author darkman
 */
public class PratiquantUI {
    
    PratiquantMetier cm=new PratiquantMetier();
    
    public  VBox getLayout(){
    VBox contentLayout=new VBox();     
    Label labelcenter=new Label("Gestion des pratiquants");
    Button btnAjouter=new Button("Ajouter Pratiquants");
    btnAjouter.setOnAction(e->{
    ajouterUI();
    });
    Button btnModifier=new Button("Modifier Pratiquants");
    btnModifier.setOnAction(e->{
    modifierUI();
    });
    HBox commandeBox=new HBox(btnAjouter,btnModifier);
    commandeBox.setPadding(new Insets(8));
   
    TableView<Pratiquant> tablePratiquants=getPratiquants();
     
    contentLayout.getChildren().addAll(labelcenter,commandeBox,tablePratiquants);
    contentLayout.setPadding(new Insets(20));
    return contentLayout;
}
    
    public TableView<Pratiquant> getPratiquants(){
        ObservableList<Pratiquant> pratiquants=FXCollections.observableArrayList();
        pratiquants=cm.getAll();
        
        //Columns mapping
        TableColumn <Pratiquant,Integer> columnId=new TableColumn<>("Id");
        columnId.setMinWidth(50);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn <Pratiquant,String> columnPrenom=new TableColumn<>("Prenom");
        columnPrenom.setMinWidth(200);
        columnPrenom.setCellValueFactory(new PropertyValueFactory<Pratiquant,String>("prenom"));
        
        TableColumn <Pratiquant,String> columnNom=new TableColumn<>("Nom");
        columnNom.setMinWidth(150);
        columnNom.setCellValueFactory(new PropertyValueFactory<Pratiquant,String>("nom"));
        
        TableColumn <Pratiquant,String> columnTitre=new TableColumn<>("Titre");
        columnTitre.setMinWidth(200);
        columnTitre.setCellValueFactory(new PropertyValueFactory<Pratiquant,String>("titre"));
        
        TableColumn <Pratiquant,String> columnSpecialite=new TableColumn<>("Specialite");
        columnSpecialite.setMinWidth(200);
        columnSpecialite.setCellValueFactory(new PropertyValueFactory<Pratiquant,String>("specialite"));
        
        TableColumn <Pratiquant,String> columnAge=new TableColumn<>("Age");
        columnAge.setMinWidth(50);
        columnAge.setCellValueFactory(new PropertyValueFactory<Pratiquant,String>("age"));
        
        TableColumn <Pratiquant,String> columnCivilite=new TableColumn<>("Civilite");
        columnCivilite.setMinWidth(100);
        columnCivilite.setCellValueFactory(new PropertyValueFactory<Pratiquant,String>("civilite"));
        
       
        
        TableView<Pratiquant> table=new TableView<>();
        table.setItems(pratiquants);
        table.getColumns().addAll(columnId,columnPrenom,columnNom,columnAge,columnSpecialite,columnTitre,columnCivilite);
        
        return table;
    }
    
    public void ajouterUI(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un pratiquant");
        window.setMinWidth(600);
        window.setMinHeight(300); 
        
        Label labelAjoutPratiquant=new Label("Ajouter un pratiquant");
        HBox boxTitle=new HBox(labelAjoutPratiquant);
        boxTitle.setAlignment(Pos.CENTER);
        
        
        
        Label labelPrenom=new Label("Prenom:");
        TextField txtPrenom=new TextField();
        HBox boxPrenom=new HBox(labelPrenom,txtPrenom);
        
        Label labelNom=new Label("Nom:");
        TextField txtNom=new TextField();
        HBox boxNom=new HBox(labelNom,txtNom);
        
        Label labelCni=new Label("Numéro carte identite:");
        TextField txtCni=new TextField();
        HBox boxCni=new HBox(labelCni,txtCni);
        
        Label labelTitre=new Label("Titre:");
        TextField txtTitre=new TextField();
        HBox boxTitre=new HBox(labelTitre,txtTitre);
        
        Label labelSpecialite=new Label("Specialite:");
        TextField txtSpecialite=new TextField();
        HBox boxSpecialite=new HBox(labelSpecialite,txtSpecialite);
        
        Label labelage=new Label("age:");
        TextField txtage=new TextField();
        HBox boxage=new HBox(labelage,txtage);
        
        Label labelCivilite=new Label("Civilite:");
        TextField txtCivilite=new TextField();
        HBox boxCivilite=new HBox(labelCivilite,txtCivilite);
        
        Button btnAjouter=new Button("Ajouter");
        btnAjouter.setOnAction(e->{
        Pratiquant pratiquant=new Pratiquant();
        pratiquant.setCni(txtCni.getText());
        pratiquant.setPrenom(txtPrenom.getText());
        pratiquant.setNom(txtNom.getText());
        pratiquant.setTitre(txtTitre.getText());
        pratiquant.setSpecialite(txtSpecialite.getText());
        pratiquant.setCivilite(txtCivilite.getText());
        pratiquant.setAge(txtage.getText());
        cm.ajouter(pratiquant); 
        });
        Button btnAnnuler=new Button("Annuler");
        HBox boxActions=new HBox(btnAjouter,btnAnnuler);
        
        VBox ajoutLayout=new VBox();
        ajoutLayout.getChildren().addAll(boxTitle,boxCni,boxPrenom,boxNom,boxTitre,boxSpecialite,boxage,boxCivilite,boxActions);
        
        
        Scene scene=new Scene(ajoutLayout);
        window.setScene(scene);
        window.showAndWait();
        
    }

public void modifierUI(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un pratiquant");
        window.setMinWidth(600);
        window.setMinHeight(300); 
        
        Label labelTitle=new Label("Modifier un pratiquant");
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
        
        Label labelCni=new Label("Numéro carte identite:");
        TextField txtCni=new TextField();
        HBox boxCni=new HBox(labelCni,txtCni);
        
        Label labelTitre=new Label("Titre:");
        TextField txtTitre=new TextField();
        HBox boxTitre=new HBox(labelTitre,txtTitre);
        
        Label labelSpecialite=new Label("Specialite:");
        TextField txtSpecialite=new TextField();
        HBox boxSpecialite=new HBox(labelSpecialite,txtSpecialite);
        
        Label labelage=new Label("age:");
        TextField txtage=new TextField();
        HBox boxage=new HBox(labelage,txtage);
        
        Label labelCivilite=new Label("Civilite:");
        TextField txtCivilite=new TextField();
        HBox boxCivilite=new HBox(labelCivilite,txtCivilite);
        
        Button btnModifier=new Button("Modifier");
        btnModifier.setOnAction(e->{
        Pratiquant pratiquant=new Pratiquant();
        pratiquant.setId(new Integer(txtId.getText()));
        pratiquant.setPrenom(txtPrenom.getText());
        pratiquant.setNom(txtNom.getText());
        pratiquant.setCni(txtCni.getText());
        pratiquant.setTitre(txtTitre.getText());
        pratiquant.setSpecialite(txtSpecialite.getText());
        pratiquant.setCivilite(txtCivilite.getText());
        pratiquant.setAge(txtage.getText());
        cm.modifier(pratiquant); 
        });
        Button btnAnnuler=new Button("Annuler");
        HBox boxActions=new HBox(btnModifier,btnAnnuler);
        
        VBox ajoutLayout=new VBox();
        ajoutLayout.getChildren().addAll(boxTitle,boxId,boxPrenom,boxNom,boxCni,boxTitre,boxSpecialite,boxage,boxCivilite,boxActions);
        
        
        Scene scene=new Scene(ajoutLayout);
        window.setScene(scene);
        window.showAndWait();
        
    }

}
