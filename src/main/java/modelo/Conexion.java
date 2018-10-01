
package modelo;

//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
//    private static Connection conn;
//    
//    /*
//    public static final String driver="com.mysql.jdbc.Driver";
//    public static final String user="root";
//    public static final String pass="12345678";
//    public static final String url = "jdbc:mysql://localhost:3306/colegio";
//    */
//    
//    //conexion en host
//    public static final String driver="com.mysql.jdbc.Driver";
//    public static final String user="root";
//    public static final String pass="FXIqam13766";
//    public static final String url = "jdbc:mysql://node24298-inmaculadaconcepcion.jelastic.cloudhosted.es:3306/colegio";
//    
//    
//    
//    public Conexion() {
//        conn=null;
//        try {
//            Class.forName(driver);
//            conn = (Connection) DriverManager.getConnection(url,user,pass);
//            if(conn!=null){
//                System.out.println("conexion");
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println("error");
//        }
//    }
//    
//    public Connection getConnection(){
//        return conn;
//    }
//    
//    public void desconectar(){
//        conn=null;
//        if(conn == null){
//            System.out.println("terminado");
//        }
//    }
}
