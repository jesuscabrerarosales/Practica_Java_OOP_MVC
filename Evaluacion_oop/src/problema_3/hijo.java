
package problema_3;

public class hijo extends padre implements implementar{
    
    public hijo(String colorOjos, String colorPelo, String colorPiel) {
        super(colorOjos, colorPelo, colorPiel);
    }

    @Override
    public boolean esFeliz() {
        boolean saludB = true;
        boolean saludM=false;
        if(saludB =!saludM)
            saludB=saludB;
        return saludB;
    }

    @Override
    String mensaje() {
        return super.mensaje()+"su salud es: "+esFeliz()+"osea buena"; 
    }

    
}

