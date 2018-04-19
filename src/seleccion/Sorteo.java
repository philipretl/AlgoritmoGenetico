/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleccion;

import algoritmo.genetico.Cromosoma;
import funciones.Funcion;
import java.util.ArrayList;
import poblacion.Padres;

/**
 *
 * @author philipretl
 */
public class Sorteo extends OperadorSeleccion{


    public Sorteo(ArrayList<Cromosoma> poblacion, Funcion funcion) {
        super(poblacion, funcion);
    }
    
  
    
    @Override
    public void seleccionarPadre() {
        System.out.println(" Metodo : Seleccion Padre");
        Cromosoma tmp;
        
        do{
            //variable entera para seleccionar aleatoreamente un cromosma de la poblacion
            int n;
            n=(int) (Math.random() * poblacion.size()) ;
            System.out.print(" n: "+n);
            tmp=poblacion.get(n);
        }while(tmp.equals(madre));
        System.out.println("");
        setPadre(tmp);
    }

    @Override
    public void seleccionarMadre() {
        System.out.println(" Metodo : Seleccion Madre");
        Cromosoma tmp;
        
        do{
            //variable entera para seleccionar aleatoreamente un cromosma de la poblacion
            int n;
            n=(int) (Math.random() * poblacion.size()) ;
            System.out.print(" n: "+n);
            tmp=poblacion.get(n);
        }while(tmp.equals(padre));
        System.out.println("");
        setMadre(tmp);
    }

    @Override
    public Padres GenerarPadres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
