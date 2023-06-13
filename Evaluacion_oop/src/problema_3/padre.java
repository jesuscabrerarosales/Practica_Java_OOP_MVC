
package problema_3;

public class padre {
    String colorOjos;
    String colorPelo;
    String colorPiel;

    public padre(String colorOjos, String colorPelo, String colorPiel) {
        this.colorOjos = colorOjos;
        this.colorPelo = colorPelo;
        this.colorPiel = colorPiel;
    }
    
    String mensaje (){
    return "Las caracteristicas fisicas del individuo son: "+"\n"
            +" Color de ojos: "+colorOjos+"\n"
            +" Color de Pelo: "+colorPelo+"\n"
            +" Color de Piel: "+colorPiel+"\n";
    }

}
