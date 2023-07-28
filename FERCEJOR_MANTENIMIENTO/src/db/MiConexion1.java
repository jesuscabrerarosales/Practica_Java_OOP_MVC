package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiConexion1 {
    //vinculo con el DRIVER MYSQL
    static{
        try{
            //conectar con el Driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //metodo de conexion
    public Connection getConexion()throws SQLException,ClassNotFoundException{
        Connection conn=null;
        try{
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/categoria",
                    "root","123456");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
