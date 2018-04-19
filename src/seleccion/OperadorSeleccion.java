/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleccion;

import algoritmo.genetico.Cromosoma;
import funciones.Funcion;
import java.util.ArrayList;

/**
 *
 * @author philipretl
 */
public abstract class OperadorSeleccion {
    
    ArrayList<Cromosoma> poblacion;
    Cromosoma padre;
    Cromosoma madre;
    Funcion func;

    public OperadorSeleccion(ArrayList<Cromosoma> poblacion, Funcion funcion) {
        this.poblacion = poblacion;
        this.func=funcion;
        
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

    public Funcion getFunc() {
        return func;
    }

    public void setFunc(Funcion func) {
        this.func = func;
    }
    
    public abstract void seleccionarPadre();
    
    public abstract void seleccionarMadre();
    
}
