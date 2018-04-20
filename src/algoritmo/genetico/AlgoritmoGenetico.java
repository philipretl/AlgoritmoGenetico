/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo.genetico;

import poblacion.Cromosoma;
import funciones.Funcion1;
import funciones.Funcion;
import java.util.ArrayList;
import poblacion.Padres;
import seleccion.OperadorSeleccion;
import seleccion.Ruleta;
import seleccion.Sorteo;

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

       
        //Prueba de sorteo, se crea un array de cromosomas :"poblacion"
        ArrayList<Cromosoma> poblacion= new ArrayList<>(); 
        Cromosoma cromos,c2,c3;
        cromos= new Cromosoma(crearGenotipo(32),1, 8, 23);

        //cromos.calcularFenotipo();
        c2=new Cromosoma(crearGenotipo(32),1, 8, 23);
        //c2.calcularFenotipo();
        c3=new Cromosoma(crearGenotipo(32),1, 8, 23);
        //c3.calcularFenotipo();
        poblacion.add(cromos);
        poblacion.add(c2);
        poblacion.add(c3);
        
        /*
            pruebas 
        */
        //OperadorSeleccion operador;
        
        Sorteo operador = new Sorteo(poblacion,null);
        
        for (int i = 0; i < 100; i++) {
            System.out.print((Math.random() * 100) / 100+ " - ");
        }
      
        System.out.println("Poblacion: ");
        for (int j = 0; j < poblacion.size(); j++) {
            System.out.println("Cromosoma: " + poblacion.get(j).getFenotipo());
        }
         
        System.out.println("Prueba sorteo");
         ArrayList <Padres> pad = operador.GenerarPadres(5);
        for (int i = 0; i <pad.size() ; i++) {
            System.out.println("padre: " + pad.get(i).getPadre().getFenotipo() + " madre: " + pad.get(i).getMadre().getFenotipo());
        }
        
         System.out.println("Prueba Ruleta");
         Funcion func = new Funcion1();
         Ruleta rulet = new Ruleta(poblacion,func);
         ArrayList <Padres> padRuleta= rulet.GenerarPadres(5);
        for (int i = 0; i <padRuleta.size() ; i++) {
            System.out.println("padre: " + padRuleta.get(i).getPadre().getFenotipo() + " madre: " + padRuleta.get(i).getMadre().getFenotipo());
        }
        
        /**
         * Finaliza pruebas
         * 
        */
        
        
       /* Sorteo sort = new Sorteo(poblacion,null);// codigo manzano
        
        sort.seleccionarPadre();
        sort.seleccionarMadre();
        
        Cromosoma padre = sort.getPadre();
        Cromosoma madre = sort.getMadre();
        
        System.out.println("Padre: "+padre.fenotipo);
        System.out.println("Madre: "+madre.fenotipo);
        
        */
        
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
            }
        }
        return genotipo;
    }
}
