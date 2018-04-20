/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

/**
 *
 * @author philipretl
 */
public abstract class  Funcion {
    protected double fenotipo;
    protected double resultado;

    public Funcion() {
    }
    
    //abstract public double calcularResultado(double fenotipo);
    
    public double getFenotipo() {
        return fenotipo;
    }

    public void setFenotipo(double fenotipo) {
        this.fenotipo = fenotipo;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado= resultado;
    }
    
    
   
    
    
}


