
public class Depa extends Inmueble{
    int montoDesc;
    int BonoDesc;
    int ageOld;
    int piso=4;
    
    public Depa(String tipo, int area, String direccion, String cocher, double precio) {
        super(tipo, area, direccion, cocher, precio);
        this.montoDesc=montoDesc;
        this.BonoDesc=BonoDesc;
        this.ageOld=ageOld;
    }

    public int getMontoDesc() {
        return montoDesc;
    }

    public void setMontoDesc(int montoDesc) {
        this.montoDesc = montoDesc;
    }

    public int getBonoDesc() {
        return BonoDesc;
    }

    public void setBonoDesc(int BonoDesc) {
        this.BonoDesc = BonoDesc;
    }

    public int getAgeOld() {
        return ageOld;
    }

    public void setAgeOld(int ageOld) {
        this.ageOld = ageOld;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
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
        if(BonoDesc<10)
            BonoDesc=1000;
        area=area*area;
        montoDesc=400*ageOld;
        precio=precio/area;
        
        precio=(area*precio)-montoDesc-BonoDesc;
        
        
        return precio;
    }

    @Override
    String mensaje() {
        return super.mensaje()+DeterminaPrecioVenta(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
