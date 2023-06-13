
public class Salida {
    public static void main(String[] args) {
        /*
        return "Es un inmueble tipo: "+tipo+" de"+area+"\n"
                +"ubicado en: "+direccion+". Cochera: "+cocher+"\n"
                +"y su precio es: "+precio;
        */
        Inmueble a1= new Casa("Casa",200,"Av. Rosa Luz","con cochera",800.000);
        Inmueble a2= new Depa("Departamento",150,"Calle Rosales","con cochera",1000.000);
        Inmueble a3= new Terreno("Terreno",300,"Tercera etapa de lisos","sin cochera",400.000);
        /*
        Inmueble aO1[]=new Casa[4];
        aO1[0]=new Casa ("Casa",200,"Av. Rosa Luz","con cochera",800000);
        
        
        for (int i = 0; i < aO1.length; i++) {
          */  
        System.out.println(a1.mensaje());
        System.out.println(a2.mensaje());
        System.out.println(a3.mensaje());
        
        /*
        Inmueble ar1[]={new Casa ("Casa",200,"Av. Rosa Luz","con cochera",800.000),
        new Depa("Departamento",150,"Calle Rosales","con cochera",1000.000),
        new  Terreno("Terreno",300,"Tercera etapa de lisos","sin cochera",400.000)};
        for (int i = 0; i < ar1.length; i++) {
            System.out.println(ar1[i]);
        }
        */
    }
    
}
