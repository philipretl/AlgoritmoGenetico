/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo.genetico;

import funciones.Funcion1;
import funciones.Funcion;
import java.util.ArrayList;

/**
 *
 * @author philipretl
 */
public class AlgoritmoGenetico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Funcion ensayo= new Funcion1();
        System.out.println("valor: " + ensayo.calcularResultado(31.5005));
        
        Cromosoma cromos;
        //cromos= new Cromosoma(crearGenotipo(32),1, 8, 23);
        cromos= new Cromosoma(crearGenotipo(13),1, 8, 4);
        
        cromos.calcularFenotipo();
        
    }
    
   static public ArrayList crearGenotipo(int tamanio){
        ArrayList<Integer> genotipo=new ArrayList();
        for (int i = 0; i < tamanio; i++) {
            //0 1 2 3 4 5 6 7 8 ...
            //+ 0 0 0 1 
            if(i>0 && i<4){
                genotipo.add(0);
            }else{
                genotipo.add((int) (Math.random() * 2));
                System.out.print(" * " + genotipo.get(i) );
            }
        }
        return genotipo;
    }
}
