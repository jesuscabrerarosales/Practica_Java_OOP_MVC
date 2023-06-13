
public abstract class Inmueble {
    String tipo;
    int area;
    String direccion;
    String cocher;
    double precio;

    public Inmueble(String tipo, int area, String direccion, String cocher, double precio) {
        this.tipo = tipo;
        this.area = area;
        this.direccion = direccion;
        this.cocher = cocher;
        this.precio = precio;
    }
    
    public abstract double DeterminaPrecioVenta();
    
    
    
    String mensaje(){

        return "Es un inmueble tipo: "+tipo+" de"+area+"\n"
                +"ubicado en: "+direccion+". Cochera: "+cocher+"\n"
                +"y su precio es: ";
}
}

