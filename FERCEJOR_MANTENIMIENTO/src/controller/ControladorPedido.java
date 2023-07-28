package controller;

import db.MiConexion2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pedido;

public class ControladorPedido {

    public int insertarPedido(Pedido obj){
        int insertados=-1;
        Connection conn=null;
        PreparedStatement pstm=null;
        try{
            conn=new MiConexion2().getConexion();
            String sql="insert into pedido values(null,?,?)";
            pstm=conn.prepareStatement(sql);
            //aqui se asigna valores
            pstm.setString(1,obj.getNombrePedido());
            pstm.setDouble(2, obj.getPrecio());
            insertados=pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Pedidos Registrado Correctamente");
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

    public int actualizarPedidos(Pedido obj){
        int actualizados=-1;
        Connection conn=null;
        PreparedStatement pstm=null;
        try{
            conn=new MiConexion2().getConexion();
            String sql="update pedido set nombre=?,precio=? where idpedido=?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, obj.getNombrePedido());
            pstm.setInt(3,obj.getIdPedido());
            pstm.setDouble(2, obj.getPrecio());
            actualizados=pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido Actualizado Satisfactoriamente");
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

    public int eliminarPedido(int idPedidos){
        int eliminados=-1;
        Connection conn=null;
        PreparedStatement pstm=null;
        try{
            conn=new MiConexion2().getConexion();
            String sql="delete from pedido where idpedido=?";
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, idPedidos);
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

    public List<Pedido>listaPedido(){
        List<Pedido> data=new ArrayList<Pedido>();
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try{
            conn=new MiConexion2().getConexion();
            String sql="select * from pedido";
            pstm=conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            Pedido c=null;
            while(rs.next()){
                c=new Pedido();
                c.setIdPedido(rs.getInt("idpedido"));
                c.setNombrePedido(rs.getString("nombre"));
                c.setPrecio(rs.getDouble("precio"));
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

    public List<Pedido>buscarPedidos(String nombre){
        ArrayList<Pedido>data=new ArrayList<Pedido>();
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try{
            conn=new MiConexion2().getConexion();
            String sql="select * from pedido where nombre like ?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, nombre+"%");
            rs = pstm.executeQuery();
            Pedido c;
            while(rs.next()){
                c=new Pedido();
                c.setIdPedido(rs.getInt("idpedido"));
                c.setNombrePedido(rs.getString("nombre"));
                c.setPrecio(rs.getInt("precio"));
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
