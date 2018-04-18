/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import funciones.Funcion;

/**
 *
 * @author philipretl
 */
public class Funcion1 extends Funcion{
    
    double e;
    double pi;
        
    public Funcion1() {
        e=2.71828182845904523536;
        pi=3.14159265358979323846;
    }

    @Override
    public double calcularResultado(double fenotipo) {
        
        resultado=0;
        double a,b,c;
        double fenotipoAbs;
        
        fenotipoAbs = Math.abs(fenotipo);
        a=20;
        b=e-(20*Math.pow(e,-0.2*fenotipoAbs));
        c=Math.pow(e,Math.cos(2*pi*fenotipo));
        
        resultado=a+b-c;
        
        return resultado;
    }
    
}

