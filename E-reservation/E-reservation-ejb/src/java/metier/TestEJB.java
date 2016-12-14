/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import crud.Admin.CrudClient;
import crud.Admin.CrudJoursBloques;
import crud.Admin.CrudJoursFeries;
import crud.Admin.CrudPays;
import crud.Admin.CrudPlanning;
import crud.Admin.CrudPratiquant;
import crud.Admin.CrudRV;
import crud.Admin.CrudServices;
import crud.Admin.CrudStructures;
import dataNew.Client;
import dataNew.JoursBloques;
import dataNew.JoursFeries;
import dataNew.Pays;
import dataNew.Planning;
import dataNew.Pratiquant;
import dataNew.RV;
import dataNew.Region;
import dataNew.Service;
import dataNew.Structure;
import dataNew.Ville;
import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.LocalTime;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author darkman
 */
@Stateless
public class TestEJB implements TestEJBRemote {
@Inject
CrudPays crudPays;
@Inject
CrudStructures crudStruct;
@Inject
CrudServices crudServices;
@Inject
CrudPlanning crudPlanning;
@Inject
CrudRV crudRV;
@Inject
CrudPratiquant crudPratiquant;
@Inject
CrudClient crudClient;
@Inject
CrudJoursBloques crudJoursBloques;
@Inject
CrudJoursFeries crudJoursFeries;

    @Override
    public String Hello() { 
    System.out.println("remote");
    return "Hello from remote ejb";
    }
   
    //Tester les pays

    @Override
    public void TesterAjouterPays() {
        Pays pays=new Pays();
        pays.setIndicatif_telephonique("+221");
        pays.setMonaie("Fcfa");
        pays.setNom_pays("Mali");
        pays.setTaux(Float.valueOf(655));
        crudPays.ajouterPays(pays);
    }

    @Override
    public void TesterModifierPays() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void TesterSuprimerPays() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pays> TesterObtenirPays() {
        return crudPays.getAll();
      }
    
    
    @Override
    public void testStructures(){
        //System.out.println("test from ejb client");
        Structure struct= new Structure();
        struct.setAdresse("Ouest Foire");
        struct.setBlog("Blog name");
        struct.setEmail("abdoulayediaw6@hotmail.com");
        struct.setLatitude("12");
        struct.setLongitude("15");
         crudStruct.ajouterStructure(struct);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void deleteStructures() {
    Structure struct=new Structure();
    struct.setId(new Integer("401"));
    crudStruct.delete(struct);
    }

    @Override
    public void testModifierStructures() {
    Structure struct=new Structure();
    struct.setId(new Integer("501"));
    struct.setAdresse("Ouagounaiyes");
    struct.setBlog("new blog good");
    struct.setEmail("layediaw@atos.com");
    struct.setLatitude("77");
    struct.setLongitude("99");
    crudStruct.modifier(struct); 
    }

    @Override
    public void TesterAjouterServices() {
        Service service= new Service();
        service.setService("Consultation");
        service.setSpecialite("Dentaire");
        service.setTarif("15000");
        crudServices.ajouterService(service);
    }

    @Override
    public void TesterModifierServices() {
    Service service= new Service();
        service.setId(551);
        service.setService("Traitement");
        service.setSpecialite("Ophtalmologie");
        service.setTarif("12000");
        crudServices.modifier(service); }

    @Override
    public void TesterSuprimerServices() {
    Service service= new Service();
        service.setId(551);
        crudServices.delete(service);
    }

    @Override
    public void TesterObtenirServices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //TESTER Planning

    @Override
    public void TesterAjouterPlanning() {
        Planning planning= new Planning();
        planning.setHeure_fermeture(new java.util.Date(2016, 8, 22, 17, 0));
        planning.setHeure_ouverture(new java.util.Date(2016, 8, 22, 8, 0));
        crudPlanning.ajouterPlanning(planning);
    }

    @Override
    public void TesterModifierPlanning() {
       Planning planning= new Planning();
        planning.setId(new Integer("651"));
        planning.setHeure_fermeture(new java.util.Date(2016, 8, 22, 18, 0));
        planning.setHeure_ouverture(new java.util.Date(2016, 8, 22, 9, 0));
        crudPlanning.modifier(planning);
    }

    @Override
    public void TesterSuprimerPlanning() {
        Planning planning= new Planning();
        planning.setId(new Integer("651"));
        crudPlanning.delete(planning);
    }

    @Override
    public void TesterObtenirPlanning() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    //TESTER LES RVs
    
    @Override
    public void TesterAjouterRV() {
     RV rv= new RV();
     rv.setCodeRV("152442");
     rv.setDateRV(LocalDate.now());
     rv.setEtat("Valide");
     rv.setHeureDebutRV(LocalTime.now());
     rv.setHeureDebutRV(LocalTime.now());
    crudRV.ajouterRV(rv);
    }

    @Override
    public void TesterModifierRV() {
       RV rv= new RV();
     rv.setId(new Integer("701"));
     rv.setCodeRV("152442");
     rv.setDateRV(LocalDate.now());
     rv.setEtat("Valide");
     rv.setHeureDebutRV(LocalTime.now());
     rv.setHeureFinRV(LocalTime.now());
     // rv.setPlanning(null);
    crudRV.modifier(rv);
    }

    @Override
    public void TesterSuprimerRV() {
       RV rv= new RV();
     rv.setId(new Integer("701"));
     crudRV.delete(rv);
    }

    @Override
    public void TesterObtenirRV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //Tester pratiquants

    @Override
    public void TesterAjouterPratiquant() {
        Pratiquant pratiquant= new Pratiquant();
        pratiquant.setAge("12");
        pratiquant.setCivilite("Feminin");
        pratiquant.setNom("Fatou");
        pratiquant.setPrenom("Diop");
        pratiquant.setSpecialite("Dentiste");
        pratiquant.setTitre("Dr");
        crudPratiquant.ajouterPratiquant(pratiquant);
          }

    @Override
    public void TesterModifierPratiquant() {
    Pratiquant pratiquant= new Pratiquant();
        pratiquant.setId(new Integer("1"));
        pratiquant.setAge("32");
        pratiquant.setCivilite("Masculin");
         pratiquant.setNom("Moussa");
        pratiquant.setPrenom("Diop");
        pratiquant.setSpecialite("Ophtalmo");
        pratiquant.setTitre("Proffesseur");
        crudPratiquant.modifier(pratiquant);
    }

    @Override
    public void TesterSuprimerPratiquant() {
     Pratiquant pratiquant= new Pratiquant();
        pratiquant.setId(new Integer("1"));
        crudPratiquant.delete(pratiquant);
    }

    @Override
    public void TesterObtenirPratiquant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    //Tester les clients
    
    @Override
    public void TesterAjouterClient() {
        Client client= new Client();
       client.setAge("21");
       client.setCivilite("Mr");
       client.setEmail("abdoulayediaw6@hotmail.com");
       client.setNom("Diaw");
       client.setPrenom("Abdoulaye");
       client.setPhone("+221 77 221 47 55");
       crudClient.ajouterClient(client);
    }

    @Override
    public void TesterModifierClient() {
      Client client= new Client();
      client.setId(new Integer("51"));
       client.setAge("19");
       client.setCivilite("Mme");
       client.setEmail("yacine@gmail.com");
       client.setNom("Diop");
       client.setPrenom("Yacine");
       client.setPhone("+221 77 171 60 77");
       crudClient.modifier(client);
    }

    @Override
    public void TesterSuprimerClient() {
   Client client= new Client();
      client.setId(new Integer("51"));
      crudClient.delete(client);
    }

    @Override
    public void TesterObtenirClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    //Tester les jours bloques

    @Override
    public void TesterAjouterJoursBloques() {
        JoursBloques joursBloques= new JoursBloques();
        joursBloques.setDate_fin_bloque(LocalTime.now());
        joursBloques.setDebut_debut_bloque(LocalTime.now());
        joursBloques.setRaison("Netoyage du materiel");
        crudJoursBloques.ajouterJoursBloques(joursBloques);
    }

    @Override
    public void TesterModifierJoursBloques() {
     JoursBloques joursBloques= new JoursBloques();
     joursBloques.setId(new Integer("101"));
        joursBloques.setDate_fin_bloque(LocalTime.now());
        joursBloques.setDebut_debut_bloque(LocalTime.now());
        joursBloques.setRaison("Absence du pratiquant");
        crudJoursBloques.modifier(joursBloques);
    }

    @Override
    public void TesterSuprimerJoursBloques() {
   JoursBloques joursBloques= new JoursBloques();
     joursBloques.setId(new Integer("101")); 
     crudJoursBloques.delete(joursBloques);
    }

    //Tester jours bloques
    @Override
    public void TesterObtenirJoursBloques() {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

    @Override
    public boolean TesterAjouterJoursFeries() {
        JoursFeries jours_feries=new JoursFeries();
        jours_feries.setDate_bloque(LocalDate.now());
        jours_feries.setFete("Tabaski");
      return  crudJoursFeries.ajouterJoursFeries(jours_feries);
       }

    @Override
    public void TesterModifierJoursFeries() {
    JoursFeries jours_feries=new JoursFeries();
        jours_feries.setId(new Integer("151"));
        jours_feries.setDate_bloque(LocalDate.now());
        jours_feries.setFete("Korite");
        crudJoursFeries.modifier(jours_feries);  }

    @Override
    public void TesterSuprimerJoursFeries() {
      JoursFeries jours_feries=new JoursFeries();
        jours_feries.setId(new Integer("151"));
        crudJoursFeries.delete(jours_feries);
    }

    @Override
    public void TesterObtenirJoursFeries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
