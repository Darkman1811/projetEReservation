/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author darkman
 */
@Remote
public interface TestEJBRemote {
     String Hello(); 
     
      //Tester les pays
     public void TesterAjouterPays();
     public void TesterModifierPays();
     public void TesterSuprimerPays();
     public List<?>  TesterObtenirPays();
     
     //Tester Structures
     public void testStructures();
     public void deleteStructures();
     public void testModifierStructures();
     
     
     //Tester les services
     public void TesterAjouterServices();
     public void TesterModifierServices();
     public void TesterSuprimerServices();
     public void TesterObtenirServices();
     
      //Tester les Planning
     public void TesterAjouterPlanning();
     public void TesterModifierPlanning();
     public void TesterSuprimerPlanning();
     public void TesterObtenirPlanning();
     
     //Tester les RVs
      public void TesterAjouterRV();
     public void TesterModifierRV();
     public void TesterSuprimerRV();
     public void TesterObtenirRV();
     
     //Tester les pratiquants
      public void TesterAjouterPratiquant();
     public void TesterModifierPratiquant();
     public void TesterSuprimerPratiquant();
     public void TesterObtenirPratiquant();
     
     //Tester les Clients
     void TesterAjouterClient();
     public void TesterModifierClient();
     public void TesterSuprimerClient();
     public void TesterObtenirClient();
             
     //Tester les jours bloqués
     void TesterAjouterJoursBloques();
     public void TesterModifierJoursBloques();
     public void TesterSuprimerJoursBloques();
     public void TesterObtenirJoursBloques();
     
      //Tester les jours feries
     public boolean TesterAjouterJoursFeries();
     public void TesterModifierJoursFeries();
     public void TesterSuprimerJoursFeries();
     public void TesterObtenirJoursFeries();
     
    
}
