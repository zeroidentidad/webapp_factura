package sistema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    private static final Logger LOG = Logger.getLogger(DAO.class.getName());
    
    public static Connection conectar() throws IOException{
    	
		InputStream configdb = DAO.class.getResourceAsStream("db.properties");		
		Properties p=new Properties ();
		p.load (configdb);
		
        String usuario= (String) p.get ("usuario"); 
        String contrasena= (String) p.get ("contrasena"); 
        String iphost= (String) p.get ("iphost");
        String puerto= (String) p.get ("puerto");
        String namedb= (String) p.get ("namedb");   	
    	
        Connection conexion = null;
        String url = "jdbc:postgresql://"+iphost+":"+puerto+"/"+namedb;
        try {
        	DriverManager.registerDriver(new org.postgresql.Driver());
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        } catch (SQLException sqle) {
            LOG.log(Level.SEVERE, "Ocurrió un error en: {0}", sqle.getMessage());
        }
        return conexion;
    }
    
    public static void cerrar(Connection c, PreparedStatement p, ResultSet r) {
        try {
            if (r != null) {
                r.close();
            }
            if (p != null) {
                p.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException sqle) {}
    }
}
