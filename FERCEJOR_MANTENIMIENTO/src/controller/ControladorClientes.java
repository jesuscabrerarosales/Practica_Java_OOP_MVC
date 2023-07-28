package controller;

import db.MiConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Clientes;

public class ControladorClientes {

    public int insertarCliente(Clientes obj){
        int insertados=-1;
        Connection conn=null;
        PreparedStatement pstm=null;
        try{
            conn=new MiConexion().getConexion();
            String sql="insert into clientes values(null,?,?,?,?)";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,obj.getNombrecliente());
            pstm.setInt(2, obj.getRuc());
            pstm.setString(3,obj.getDireccion());
            pstm.setString(4,obj.getProvincia());
            insertados=pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cliente Registrado Correctamente");
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

    public int actualizarClientes(Clientes obj){
        int actualizados=-1;
        Connection conn=null;
        PreparedStatement pstm=null;
        try{
            conn=new MiConexion().getConexion();
            String sql="update clientes set nombre=?,Ruc=?, direccion=?, provincia=? where idcliente=?";
            pstm=conn.prepareStatement(sql);
            pstm.setInt(5, obj.getIdClientes());
            pstm.setString(1, obj.getNombrecliente());
            pstm.setInt(2,obj.getRuc());
            pstm.setString(3,obj.getDireccion());
            pstm.setString(4,obj.getProvincia());
            actualizados=pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Actualizado Satisfactoriamente");
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

    public int eliminarCliente(int idClientes){
        int eliminados=-1;
        Connection conn=null;
        PreparedStatement pstm=null;
        try{
            conn=new MiConexion().getConexion();
            String sql="delete from clientes where idcliente=?";
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, idClientes);
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

    public List<Clientes>listaClientes(){
        List<Clientes> data=new ArrayList<Clientes>();
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try{
            conn=new MiConexion().getConexion();
            String sql="select * from clientes";
            pstm=conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            Clientes c=null;
            while(rs.next()){
                c=new Clientes();
                c.setIdClientes(rs.getInt("idcliente"));
                c.setNombrecliente(rs.getString("nombre"));
                c.setRuc(rs.getInt("Ruc"));
                c.setDireccion(rs.getString("direccion"));
                c.setProvincia(rs.getString("provincia"));
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

    public List<Clientes>buscarClientes(String nombre){
        ArrayList<Clientes>data=new ArrayList<Clientes>();
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try{
            conn=new MiConexion().getConexion();
            String sql="select * from clientes where nombre like ?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, nombre+"%");
            rs = pstm.executeQuery();
            Clientes c;
            while(rs.next()){
                c=new Clientes();
                c.setIdClientes(rs.getInt("idcliente"));
                c.setNombrecliente(rs.getString("nombre"));
                c.setRuc(rs.getInt("Ruc"));
                c.setDireccion(rs.getString("direccion"));
                c.setProvincia(rs.getString("provincia"));
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
    public List<Clientes>buscarProvincia(String provincia){
        ArrayList<Clientes>data=new ArrayList<Clientes>();
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try{
            conn=new MiConexion().getConexion();
            String sql="select idcliente,nombre,Ruc,direccion,provincia"; // as provincia from clientes c inner join provincia p on c.idPais=p.idPais where p.nombre=?";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, provincia);
            rs = pstm.executeQuery();
            Clientes c;
            while(rs.next()){
                c=new Clientes();
                c.setIdClientes(rs.getInt("idcliente"));
                c.setNombrecliente(rs.getString("nombre"));
                c.setRuc(rs.getInt("Ruc"));
                c.setDireccion(rs.getString("direccion"));
                c.setProvincia(rs.getString("provincia"));
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
}}
