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
public class Ruleta extends OperadorSeleccion{
    
    private ArrayList<Double> rangos;
        

    public Ruleta(ArrayList<Cromosoma> poblacion, Funcion funcion) {
        super(poblacion, funcion);
        rangos = new ArrayList();
        padres=new ArrayList();
        calcularSumatoria();
        calcularRangos();
    }
    
    
    public void calcularRangos(){
        
        for (int i = 0; i <poblacion.size(); i++) {
            
            if(i==0){
                rangos.add(func.calcularResultado(poblacion.get(i).getFenotipo())/sumatoria);
            }else{
                rangos.add(func.calcularResultado(poblacion.get(i).getFenotipo())/sumatoria +func.calcularResultado(poblacion.get(i-1).getFenotipo())/sumatoria);
            }
        }    
    }

    @Override
    public ArrayList<Padres> GenerarPadres(int numPadres) {
    
        
        int cont=0;
       
        do{
            //variable entera para seleccionar aleatoreamente un cromosma de la poblacion
            Padres tmp = new Padres(cont);
            //Cromosoma padre = new Cromosoma(buscar().getGenotipo(),buscar().getInfo(),buscar().getEntero(),buscar().getDecimal()); 
            //Cromosoma temp=buscar();
            Cromosoma padre ;//= new Cromosoma();
            //padre = new Cromosoma(temp.getGenotipo(),temp.getInfo(),temp.getEntero(),temp.getDecimal()); 
            padre=buscar();
            tmp.setPadre(padre);
           
            boolean flag=false;// bandera para encontrar la madre
            do{
               // Cromosoma madre = new Cromosoma(buscar().getGenotipo(),buscar().getInfo(),buscar().getEntero(),buscar().getDecimal()); 
               Cromosoma madre ;//= new Cromosoma();
               //Cromosoma tempM=buscar();
               //madre = new Cromosoma(tempM.getGenotipo(),tempM.getInfo(),tempM.getEntero(),tempM.getDecimal()); 
               madre=buscar();
               tmp.setMadre(madre);
                if(tmp.getMadre().getFenotipo()!=tmp.getPadre().getFenotipo()){
                    //tmp.setMadre(madre);
                    flag=true;
                }
            }while(flag!=true);

            padres.add(tmp);// luego de encontrar el padre y la madre se agregar a la lista
        
            cont++;
            
        }while(cont < numPadres);
     

       return padres;
    }
    
    public Cromosoma buscar(){
        Cromosoma cromo = null;
        double n;
        n= (Math.random() * 100) / 100 ;
        
        for (int i = 0; i < rangos.size(); i++) {
                
            if(n<=rangos.get(i)){
               // System.out.println("poblacion: " + poblacion.get(i).getFenotipo() +"rango: " + rangos.get(i));

                //cromo=new Cromosoma(poblacion.get(i).getGenotipo(),poblacion.get(i).getInfo(),poblacion.get(i).getEntero(),poblacion.get(i).getDecimal());;
                cromo=poblacion.get(i);
                break;
            }
                    
        }
                    
        return cromo;
    }

    @Override
    public void calcularSumatoria() {
        for (int i = 0; i < poblacion.size(); i++) {
            sumatoria=sumatoria + (func.calcularResultado(poblacion.get(i).getFenotipo()));
        }
    }
    

   

}
