
public class Casa extends Inmueble{
    int montoDesc;
    int ageOld;
    

    public Casa(String tipo, int area, String direccion, String cocher, double precio) {
        super(tipo, area, direccion, cocher, precio);
        this.montoDesc=montoDesc;
        this.ageOld=ageOld;
    }

    public int getMontoDesc() {
        return montoDesc;
    }

    public void setMontoDesc(int montoDesc) {
        this.montoDesc = montoDesc;
    }

    public int getAgeOld() {
        return ageOld;
    }

    public void setAgeOld(int ageOld) {
        this.ageOld = ageOld;
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
        montoDesc=700*ageOld;
        precio=precio/area;
        precio=(area*precio)-montoDesc;
        
        
        return precio;
    }

    @Override
    String mensaje() {
        return super.mensaje()+DeterminaPrecioVenta(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
