package db;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    //psvm+tab
    public static void main(String[] args) {
        try{
            Connection cn=new MiConexion().getConexion();
            if (cn!=null) {
                System.out.println("Conexion conforme"); 
            }else{
                System.out.println("NO hay conexion");
            }
        }catch(ClassNotFoundException | SQLException e){
            //sout+tab
            System.out.println("Error:"+e.getMessage());
        }
    }
}
