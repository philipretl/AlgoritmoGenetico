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
        int n;
        n=(int) (Math.random() * (1-0+0.1)+1) ;
        System.out.println("n: " + n );
    
    }

    @Override
    public void seleccionarMadre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
             

}
