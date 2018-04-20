/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleccion;

import poblacion.Cromosoma;
import funciones.Funcion;
import java.util.ArrayList;
import poblacion.Padres;

/**
 *
 * @author philipretl
 */
public abstract class OperadorSeleccion {
    
    ArrayList<Cromosoma> poblacion;
    ArrayList<Padres> padres;
    Funcion func;
    double sumatoria;

    public OperadorSeleccion(ArrayList<Cromosoma> poblacion, Funcion funcion){
        this.poblacion = poblacion;
        this.func=funcion;
        int sumatoria=0;
        
    }

    public ArrayList<Cromosoma> getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(ArrayList<Cromosoma> poblacion) {
        this.poblacion = poblacion;
    }

    public Funcion getFunc() {
        return func;
    }

    public void setFunc(Funcion func) {
        this.func = func;
    }
    
    public abstract ArrayList<Padres> GenerarPadres(int numPadres);
    public abstract void calcularSumatoria();
}
