/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruce;

import poblacion.Cromosoma;

/**
 *
 * @author Mauricio
 */
public abstract class OperadorCruce {
    
    Cromosoma hijo;

    public OperadorCruce() {
    }

    public Cromosoma getHijo() {
        return hijo;
    }

    public void setHijo(Cromosoma hijo) {
        this.hijo = hijo;
    }
    
    public abstract void cruzar();
    
}
