/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

/**
 *
 * @author WCabrera
 */
public class BD_U {

    Vector v = new Vector();

    public void guardar(Usuario usuario) {
        v.addElement(usuario);
    }

    public void guardaArchivo(Usuario usuario) {
        try {
            FileWriter fw = new FileWriter("usuarios.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(usuario.getIdUsuario());
            pw.print(";" + usuario.getNombre());
            pw.print(";" + usuario.getTelefono());
            pw.println(";" + usuario.getTipoUsuario());
            pw.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        

    public DefaultTableModel listaUsuarios(){
        Vector cabecera = new Vector();
        cabecera.addElement("Id Usuario");
        cabecera.addElement("Nombre");
        cabecera.addElement("Telefono");
        cabecera.addElement("Tipo Usuario");
        
        DefaultTableModel modelo=new DefaultTableModel(cabecera,0);
        
        
        try {
            FileReader fr=new FileReader("usuarios.txt");
            BufferedReader br=new BufferedReader(fr);
            String d;
            while ((d= br.readLine())!=null) {                
                StringTokenizer dato=new StringTokenizer(d,";");
                Vector x=new Vector();
                while (dato.hasMoreTokens()) {                    
                    x.addElement(dato.nextToken());
                }
                modelo.addRow(x);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return modelo;
    }

}


