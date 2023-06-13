/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author WCabrera
 */
public class Libro {
    private String IdLibro;
    private String Titulo;
    private String Autor;
    private String disponibilidad;

    public Libro(String IdLibro, String Titulo, String Autor, String disponibilidad) {
        this.IdLibro = IdLibro;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.disponibilidad = disponibilidad;
    }

    public String getIdLibro() {
        return IdLibro;
    }

    public void setIdLibro(String IdLibro) {
        this.IdLibro = IdLibro;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    
    
}
