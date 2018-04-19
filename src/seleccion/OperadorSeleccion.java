/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleccion;

import algoritmo.genetico.Cromosoma;
import java.util.ArrayList;

/**
 *
 * @author philipretl
 */
public abstract class OperadorSeleccion {
    
    ArrayList<Cromosoma> poblacion;
    Cromosoma padre;
    Cromosoma madre;

    public OperadorSeleccion() {
        poblacion=new ArrayList();
    }

    public OperadorSeleccion(ArrayList<Cromosoma> poblacion) {
        this.poblacion = poblacion;

    }

    public ArrayList<Cromosoma> getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(ArrayList<Cromosoma> poblacion) {
        this.poblacion = poblacion;
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
    
    public abstract void seleccionarPadre();
    
    public abstract void seleccionarMadre();
    
}
