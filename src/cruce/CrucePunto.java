/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruce;

import java.util.ArrayList;
import poblacion.Cromosoma;
import poblacion.Padres;

/**
 *
 * @author Mauricio
 */
public class CrucePunto {
    
    int puntoCorte;
    

    public CrucePunto() {
    }
    
    public ArrayList<Cromosoma> cruzar(Cromosoma padre, Cromosoma madre){
        
        ArrayList<Integer> cabezaP = new ArrayList<>();
        ArrayList<Integer> colaP = new ArrayList<>();
        ArrayList<Integer> cabezaM = new ArrayList<>();
        ArrayList<Integer> colaM = new ArrayList<>();
        ArrayList<Cromosoma> hijos = new ArrayList<>();
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
        
        hijos.add(hijo1);
        hijos.add(hijo2);
        
        return hijos;
       
    }
    
    public void crearPuntoCorte(Cromosoma cromosoma){
        int size = cromosoma.getGenotipo().size();
        int corte = (int) (Math.random() * (size-1))+1;
        puntoCorte=corte;
        
    }
    
    public ArrayList<Cromosoma> configurarCruces(ArrayList<Padres> parejas){
        ArrayList<Cromosoma> hijos =new ArrayList<>();
        crearPuntoCorte(parejas.get(0).getPadre());
        for (int i = 0; i < parejas.size(); i++) {
            ArrayList<Cromosoma> cruces = cruzar(parejas.get(i).getPadre(),parejas.get(i).getMadre());
            hijos.add(cruces.get(0));
            hijos.add(cruces.get(1));
        }
        
        return hijos;
    }
}
