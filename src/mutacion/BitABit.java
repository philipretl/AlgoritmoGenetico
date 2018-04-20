/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutacion;

import java.util.ArrayList;
import poblacion.Cromosoma;

/**
 *
 * @author mauricio
 */
public class BitABit {
    
    int posicion;

    public BitABit() {
    }
    
    public void seleccionarBit(Cromosoma cromosoma){
        int bit= (int) (Math.random() * (cromosoma.getGenotipo().size()));
        posicion=bit;
    }
    
    public Cromosoma mutar(Cromosoma cromosoma){
        seleccionarBit(cromosoma);
        Cromosoma nuevo;
        nuevo=cromosoma;
        if(cromosoma.getGenotipo().get(posicion)==0){
            nuevo.getGenotipo().set(posicion, 1);
        }else{
            nuevo.getGenotipo().set(posicion, 0);
        }
        
        return nuevo;
    }
    
    public ArrayList<Cromosoma> mutarPoblacion(ArrayList<Cromosoma> poblacion){
        ArrayList<Cromosoma> poblacionMutada=new ArrayList<>();
        for (int i = 0; i < poblacion.size(); i++) {
            poblacionMutada.add(mutar(poblacion.get(i)));
        }
        
        return poblacionMutada;
    }
}
