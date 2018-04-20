/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poblacion;

/**
 *
 * @author philipretl
 */
public class Padres {
    Cromosoma padre;
    Cromosoma madre;
    int id;
    //mela pela

    public Padres(int id) {
        this.id=id;
    }

    public Cromosoma getPadre() {
        return padre;
    }

    public void setPadre(Cromosoma padre) {
        this.padre = padre;
    }

    public Cromosoma getMadre() {
        return madre;
    }

    public void setMadre(Cromosoma madre) {
        this.madre = madre;
    }
    
    
}
