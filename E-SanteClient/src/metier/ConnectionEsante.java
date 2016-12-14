/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darkman
 */
public class ConnectionEsante {
    public static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    public static final String JDBC_URL="jdbc:derby://localhost:1527/dbEsanteLocal;create=true;user=root;password=scorpio";
    public static Connection connection;
     
    public ConnectionEsante(){
       
    }
   
    public void TestDB(){
        
        try {
            String sqlStat="insert into PAYS values (1,'Sénégal',221,'Fcfa',355)";
            connection.createStatement().executeUpdate(sqlStat);
          //  connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnection(){
        if (connection==null){ try {
            Class.forName(DRIVER).newInstance();
            connection=DriverManager.getConnection(JDBC_URL);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    return this.connection;
    }
}
