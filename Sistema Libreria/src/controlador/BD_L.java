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
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;

/**
 *
 * @author WCabrera
 */
public class BD_L {
    Vector v = new Vector();
    public void guardar(Libro libro) {
        v.addElement(libro);
    }
    
    public void guardaArchivo(Libro libro) {
        try {
            FileWriter fw = new FileWriter("libros.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(libro.getIdLibro());
            pw.print(";" + libro.getTitulo());
            pw.print(";" + libro.getAutor());
            pw.println(";" + libro.getDisponibilidad());
            pw.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        

    public DefaultTableModel listaUsuarios(){
        Vector cabecera = new Vector();
        cabecera.addElement("Id Libro");
        cabecera.addElement("Titulo");
        cabecera.addElement("Autor");
        cabecera.addElement("Disponible");
        
        DefaultTableModel modelo=new DefaultTableModel(cabecera,0);
        
        
        try {
            FileReader fr=new FileReader("libros.txt");
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
