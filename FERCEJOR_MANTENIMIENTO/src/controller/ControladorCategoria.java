package controller;

import db.MiConexion1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;

public class ControladorCategoria {

    public int insertarCliente(Categoria obj){
        int insertados=-1;
        Connection conn=null;
        PreparedStatement pstm=null;
        try{
            conn=new MiConexion1().getConexion();
            String sql="insert into Categoria values(null,?,?)";
            pstm=conn.prepareStatement(sql);
            //aqui se asigna valores
            pstm.setString(1,obj.getNombreRepuesto());
            pstm.setString(2, obj.getDescripcion());
            insertados=pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Categoria Registrado Correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (pstm!=null) {
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return insertados;
    }

    public int actualizarCategoria(Categoria obj){
        int actualizados=-1;
        Connection conn=null;
        PreparedStatement pstm=null;
        try{
            conn=new MiConexion1().getConexion();
            String sql="update Categoria set nombre=?,descripcion=? where idcategoria=?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, obj.getNombreRepuesto());
            pstm.setString(2,obj.getDescripcion());
            pstm.setInt(3, obj.getIdCategoria());
            actualizados=pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria Actualizado Satisfactoriamente");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (pstm!=null) {
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return actualizados;
    }

    public int eliminarCategoria(int idCategoria){
        int eliminados=-1;
        Connection conn=null;
        PreparedStatement pstm=null;
        try{
            conn=new MiConexion1().getConexion();
            String sql="delete from Categoria where idcategoria=?";
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, idCategoria);
            eliminados=pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado Satisfactoriamente");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (pstm!=null) {
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return eliminados;
    }

    public List<Categoria>listaCategoria(){
        List<Categoria> data=new ArrayList<Categoria>();
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try{
            conn=new MiConexion1().getConexion();
            String sql="select * from Categoria";
            pstm=conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            Categoria c=null;
            while(rs.next()){
                c=new Categoria();
                c.setIdCategoria(rs.getInt("idcategoria"));
                c.setNombreRepuesto(rs.getString("nombre"));
                c.setDescripcion(rs.getString("descripcion"));
                data.add(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (pstm!=null) {
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return data;
    }

    public List<Categoria>buscarCategoria(String nombre){
        ArrayList<Categoria>data=new ArrayList<Categoria>();
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try{
            conn=new MiConexion1().getConexion();
            String sql="select * from Categoria where nombre like ?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, nombre+"%");
            rs = pstm.executeQuery();
            Categoria c;
            while(rs.next()){
                c=new Categoria();
                c.setIdCategoria(rs.getInt("idcategoria"));
                c.setNombreRepuesto(rs.getString("nombre"));
                c.setDescripcion(rs.getString("descripcion"));
                data.add(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (pstm!=null) {
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return data;
    }
}
