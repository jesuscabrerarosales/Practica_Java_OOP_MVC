/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a;

/**
 *
 * @author HPUSER
 */
public class Llamada {
    private String dni;
    private String nombre;
    private String tipoPlan;
    private String tipoLlamada;
    private int minuLlamada;

    public Llamada(String dni, String nombre, String tipoPlan, String tipoLlamada, int minuLlamada) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipoPlan = tipoPlan;
        this.tipoLlamada = tipoLlamada;
        this.minuLlamada = minuLlamada;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getTipoLlamada() {
        return tipoLlamada;
    }

    public void setTipoLlamada(String tipoLlamada) {
        this.tipoLlamada = tipoLlamada;
    }

    public int getMinuLlamada() {
        return minuLlamada;
    }

    public void setMinuLlamada(int minuLlamada) {
        this.minuLlamada = minuLlamada;
    }
    
    public double calcularCostoPorMinuto(){
        double monto=0;
        if(getTipoPlan().equalsIgnoreCase("A")){
            if(getTipoLlamada().equalsIgnoreCase("LOCAL")){
                monto=0.20*getMinuLlamada();
            }else if(getTipoLlamada().equalsIgnoreCase("CELULAR")){
                monto=0.40*getMinuLlamada();
            }
        }else if(getTipoPlan().equalsIgnoreCase("B")){
            if(getTipoLlamada().equalsIgnoreCase("LOCAL")){
                monto=0.15*getMinuLlamada();
            }else if(getTipoLlamada().equalsIgnoreCase("CELULAR")){
                monto=0.30*getMinuLlamada();
            }
        }
        return monto;
    }
    public double costoDeLlamada(){
        return calcularCostoPorMinuto()*getMinuLlamada();
    }
    public double pagoFinalPorLLamada(){
        return costoDeLlamada()+(costoDeLlamada()*0.18);
    }
}
