/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metierTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dataNew.Client;
import javafx.collections.ObservableList;
import metier.ClientMetier;

/**
 *
 * @author darkman
 */
public class ClientMetierTest {
    
    public ClientMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
     public void testAjoutClient() {
     Client client=new Client();
     client.setAge("31");
     client.setCivilite("Mr");
     client.setEmail("abdoulayediaw6@hotmail.com");
     client.setNom("Diaw");
     client.setPrenom("Abdoulaye");
     client.setPhone("+221772214755"+Math.random());
     
     ClientMetier cmetier=new ClientMetier();
     cmetier.ajouter(client);
        ObservableList lst=cmetier.getAll();
        
        Client clientSearch=new Client();
        Boolean found=false;
        for(int i=0;i<lst.size();i++){
           clientSearch =(Client)lst.get(i);
           if(client.getEmail().equals(clientSearch.getEmail())){
               found=true;
           }
        }
        
        assertTrue(found);
     }
}
