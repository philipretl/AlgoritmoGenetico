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
            /*codigo viejo para no repeticiones
            padres.add(tmp);// luego de encontrar el padre y la madre se agregar a la lista
        
            cont++;
            */
            //codigo nuevo no repeticiones 03.21 am
            int num;
            if(cont==0){
                padres.add(tmp);
                cont ++;
                
            }else{
                num=0;
                for (int k = 0; k < padres.size(); k++) {
                    
                    if(padres.get(k).getPadre().getFenotipo() == tmp.getPadre().getFenotipo() && padres.get(k).getMadre().getFenotipo() == tmp.getMadre().getFenotipo()){
                        num++;
                    }
                    
                }
                if(num==0){
                    padres.add(tmp);// luego de encontrar el padre y la madre se agregar a la lista
                    cont++;
                }
            }     
            
            
        }while(cont < numPadres);

        
        return padres;
        
    }

    @Override
    public void calcularSumatoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
