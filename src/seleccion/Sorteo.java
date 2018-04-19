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
public class Sorteo extends OperadorSeleccion{

    public Sorteo() {
        super();
    }

    public Sorteo(ArrayList<Cromosoma> poblacion) {
        super(poblacion);
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
    
}
