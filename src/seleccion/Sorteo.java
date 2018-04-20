/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleccion;

import poblacion.Cromosoma;
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
        padres=new ArrayList();
    }
    
 

    @Override
    public ArrayList<Padres> GenerarPadres(int numPadres) {
        int cont=0;
        int n;
 
        do{
            //variable entera para seleccionar aleatoreamente un cromosma de la poblacion
            n=(int) (Math.random() * poblacion.size()) ;
            Padres tmp = new Padres(cont);
           
            tmp.setPadre(poblacion.get(n));
            
            boolean flag=false;// bandera para encontrar la madre
            do{
               
               n=(int) (Math.random() * poblacion.size());
               if(poblacion.get(n)!=tmp.getPadre()){
                   tmp.setMadre(poblacion.get(n));
                   flag=true;
               }
            }while(flag!=true);
            
            padres.add(tmp);// luego de encontrar el padre y la madre se agregar a la lista
        
            cont++;
            
        }while(cont < numPadres);

        
        return padres;
        
    }
    
}
