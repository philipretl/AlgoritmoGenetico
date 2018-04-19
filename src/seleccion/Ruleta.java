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
public class Ruleta extends OperadorSeleccion{
    
    private ArrayList<Double> rangos;
        

    public Ruleta(ArrayList<Cromosoma> poblacion, Funcion funcion) {
        super(poblacion, funcion);
        rangos = new ArrayList();
    }
    
    
    public void calcularRangos(){
        
        for (int i = 0; i <poblacion.size(); i++) {
            
            if(i==0){
                rangos.add(func.calcularResultado(poblacion.get(i).getFenotipo()));
            }else{
                rangos.add(func.calcularResultado(poblacion.get(i).getFenotipo())+func.calcularResultado(poblacion.get(i-1).getFenotipo()));
            }
        }    
    }

    @Override
    public void seleccionarPadre() {
        double n;
        n= (Math.random() * 100) / 100 ;
        System.out.println("n: " + n );
        
        for (int i = 0; i < 10; i++) {
            
        }
    }

    @Override
    public void seleccionarMadre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Padres GenerarPadres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
             

}
