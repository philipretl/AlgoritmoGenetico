/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruce;

import java.util.ArrayList;
import poblacion.Cromosoma;

/**
 *
 * @author Mauricio
 */
public class CrucePunto {
    
    int puntoCorte;
    

    public CrucePunto() {
    }
    
    public void cruzar(Cromosoma padre, Cromosoma madre){
        
        ArrayList<Integer> cabezaP = new ArrayList<>();
        ArrayList<Integer> colaP = new ArrayList<>();;
        ArrayList<Integer> cabezaM = new ArrayList<>();;
        ArrayList<Integer> colaM = new ArrayList<>();;
        Cromosoma hijo1;
        Cromosoma hijo2;
        
        //Saco cabeza de padre y cabeza de madre
        for (int i = 0; i < puntoCorte; i++) {
            cabezaP.add(padre.getGenotipo().get(i));
            cabezaM.add(madre.getGenotipo().get(i));
        }
        
        //Saco cola de padre y cabeza de madre
        for (int j = puntoCorte; j < padre.getGenotipo().size(); j++) {
            colaP.add(padre.getGenotipo().get(j));
            colaM.add(madre.getGenotipo().get(j));
        }
        
        ArrayList<Integer> genotipo1= new ArrayList<>();
        ArrayList<Integer> genotipo2= new ArrayList<>();
        
        for (int i = 0; i < cabezaP.size(); i++) {
            genotipo1.add(cabezaP.get(i));
            genotipo2.add(cabezaM.get(i));
        }
        
        for (int j = 0; j < colaP.size(); j++) {
            genotipo1.add(colaM.get(j));
            genotipo2.add(colaP.get(j));
        }
        
        hijo1 = new Cromosoma(genotipo1,padre.getInfo(),padre.getEntero(),padre.getDecimal());
        hijo2 = new Cromosoma(genotipo2,padre.getInfo(),padre.getEntero(),padre.getDecimal());
        
       
    }
    
    public void crearPuntoCorte(){
        
    }
}
