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
public class CruceDosPuntos {
    
    int puntoCorte1;
    int puntoCorte2;
    

    public CruceDosPuntos() {
    }
    
    public ArrayList<Cromosoma> cruzar(Cromosoma padre, Cromosoma madre){
        
        ArrayList<Integer> cabezaP = new ArrayList<>();
        ArrayList<Integer> centroP = new ArrayList<>();
        ArrayList<Integer> colaP = new ArrayList<>();
        ArrayList<Integer> cabezaM = new ArrayList<>();
        ArrayList<Integer> centroM = new ArrayList<>();
        ArrayList<Integer> colaM = new ArrayList<>();
        ArrayList<Cromosoma> hijos = new ArrayList<>();
        Cromosoma hijo1;
        Cromosoma hijo2;
        
        //Saco cabeza de padre y cabeza de madre
        for (int i = 0; i < puntoCorte1; i++) {
            cabezaP.add(padre.getGenotipo().get(i));
            cabezaM.add(madre.getGenotipo().get(i));
        }
        //Saco centro de padre y centro de madre
        for (int k = puntoCorte1; k < puntoCorte2; k++) {
            cabezaP.add(padre.getGenotipo().get(k));
            cabezaM.add(madre.getGenotipo().get(k));
        }
        
        //Saco cola de padre y cabeza de madre
        for (int j = puntoCorte2; j < padre.getGenotipo().size(); j++) {
            colaP.add(padre.getGenotipo().get(j));
            colaM.add(madre.getGenotipo().get(j));
        }
        
        ArrayList<Integer> genotipo1= new ArrayList<>();
        ArrayList<Integer> genotipo2= new ArrayList<>();
        
        for (int i = 0; i < cabezaP.size(); i++) {
            genotipo1.add(cabezaP.get(i));
            genotipo2.add(cabezaM.get(i));
        
        }
        
        for (int k = 0; k < centroP.size(); k++) {
            genotipo1.add(centroM.get(k));
            genotipo2.add(centroP.get(k));
        }
        
        for (int j = 0; j < colaP.size(); j++) {
            genotipo1.add(colaP.get(j));
            genotipo2.add(colaM.get(j));
        }
        
        hijo1 = new Cromosoma(genotipo1,padre.getInfo(),padre.getEntero(),padre.getDecimal());
        hijo2 = new Cromosoma(genotipo2,padre.getInfo(),padre.getEntero(),padre.getDecimal());
        
        hijos.add(hijo1);
        hijos.add(hijo2);
        
        return hijos;
       
    }
    
    public void crearPuntosCorte(Cromosoma cromosoma){
        int size = cromosoma.getGenotipo().size();
        int corte1=0;
        int corte2=0;
        do{
            corte1 = (int) (Math.random() * (size-1))+1;
            corte2 = (int) (Math.random() * (size-1))+1;
        }while(corte2>corte1 && corte2-corte1<1);
        
        puntoCorte1=corte1;
        puntoCorte2=corte2;
    }
    
    public ArrayList<Cromosoma> configurarCruces(ArrayList<Padres> parejas){
        ArrayList<Cromosoma> hijos =new ArrayList<>();
        crearPuntosCorte(parejas.get(0).getPadre());
        for (int i = 0; i < parejas.size(); i++) {
            ArrayList<Cromosoma> cruces = cruzar(parejas.get(i).getPadre(),parejas.get(i).getMadre());
            hijos.add(cruces.get(0));
            hijos.add(cruces.get(1));
        }
        
        return hijos;
    }
    
}
