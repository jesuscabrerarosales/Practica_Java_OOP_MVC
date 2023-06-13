
public class Terreno extends Inmueble{
    
    public Terreno(String tipo, int area, String direccion, String cocher, double precio) {
        super(tipo, area, direccion, cocher, precio);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCocher() {
        return cocher;
    }

    public void setCocher(String cocher) {
        this.cocher = cocher;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    @Override
    public double DeterminaPrecioVenta() {
        
        area=area*area;
        precio=precio/area;
        precio=area*precio;
        
        
        return precio;
    }

    @Override
    String mensaje() {
        return super.mensaje()+DeterminaPrecioVenta(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
