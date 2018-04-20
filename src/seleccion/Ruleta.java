/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleccion;

import poblacion.Cromosoma;
import funciones.Funcion;
import java.util.ArrayList;
import java.util.Random;
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
        double primero,anterior;
        for (int i = 0; i <poblacion.size(); i++) {
            
            if(i==0){
                rangos.add(func.calcularResultado(poblacion.get(i).getFenotipo())/sumatoria);
                System.out.println("rangos:" + rangos.get(i));
            }else{
                primero=func.calcularResultado(poblacion.get(i).getFenotipo())/sumatoria;
                anterior=rangos.get(i-1);
                rangos.add(primero+anterior);
            }
        }    
    }

    @Override
    public ArrayList<Padres> GenerarPadres(int numPadres) {
    
        
        int cont=0;
        double n,m;
        Random rand = new Random();
       
        do{
          
            // new try------------------------
            
            Padres padresTemp = new Padres(cont);
            
            // genero un aleatorio miro el rango seleccion el papá
             //n= (Math.random() * sumatoria/100) ;
            for (int i = 0; i < rangos.size(); i++) {
                do{// se me estaba desbordando el aleatorio.
                    n=0.0;
                    n= (Math.random() * 100) / 100 ;
                    //n=0.1 + ( 1 - 0) * rand.nextDouble();
                }while(n > rangos.get(rangos.size()-1));
                
                /*n=0.0;
                //n= (Math.random() * sumatoria/100) ;
                n=0.1 + ( sumatoria/100 - 0.1) * rand.nextDouble();
                */
                System.out.println("n: " + n );//
                System.out.println("rango del for: "  + rangos.get(i));
                if(n<=rangos.get(i)){
                     
                    // System.out.println("poblacion: " + poblacion.get(i).getFenotipo() +"rango: " + rangos.get(i));

                    // cromo=new Cromosoma(poblacion.get(i).getGenotipo(),poblacion.get(i).getInfo(),poblacion.get(i).getEntero(),poblacion.get(i).getDecimal());;
                     padresTemp.setPadre(poblacion.get(i));
                     break;
                }
            }    
            // genero un random, miro el rango seleccion a la mamá si es igual 
            //repite
            boolean flag=false;
            //Double m;
            /*do{
                m= (Math.random() * 100) / 100 ;
            }while(m > rangos.get(rangos.size()-1));
             */
            do {
                //System.out.println("entre al do interno");
                do{ 
                    m=0.0;
                    m= (Math.random() * 100) / 100 ;
                     //n=0.1 + ( 1 - 0.1) * rand.nextDouble();
                }while(m > rangos.get(rangos.size()-1)); 
                
                /*m=0.0;
                //m= (Math.random() * sumatoria/100) ;
                m=0.1 + (sumatoria/100 - 0.1) * rand.nextDouble();
                */
                for (int j = 0; j < rangos.size(); j++) {
                   
                    if(m<=rangos.get(j)){
                        
               // System.out.println("poblacion: " + poblacion.get(i).getFenotipo() +"rango: " + rangos.get(i));

               // cromo=new Cromosoma(poblacion.get(i).getGenotipo(),poblacion.get(i).getInfo(),poblacion.get(i).getEntero(),poblacion.get(i).getDecimal());;
                        padresTemp.setMadre(poblacion.get(j));
                        break;
                    }
                }
                
                if(padresTemp.getMadre().getFenotipo()!=padresTemp.getPadre().getFenotipo()){// evalua que el padre y la madre no sean el mimso
                        flag=true;
                
                }
                  
            } while (!flag);
            int num;
        //------------------------------    
            if(cont==0){
                padres.add(padresTemp);
                cont ++;
                
            }else{
                num=0;
                for (int k = 0; k < padres.size(); k++) {
                    
                    if(padres.get(k).getPadre().getFenotipo() == padresTemp.getPadre().getFenotipo() && padres.get(k).getMadre().getFenotipo() == padresTemp.getMadre().getFenotipo()){
                        num++;
                    }
                    
                }
                if(num==0){
                    padres.add(padresTemp);// luego de encontrar el padre y la madre se agregar a la lista
                    cont++;
                }
            }     
            
            
            
        }while(cont < numPadres);
     
        
       return padres;
    
    }    

    @Override
    public void calcularSumatoria() {
        for (int i = 0; i < poblacion.size(); i++) {
            System.out.println("funcion: " + (func.calcularResultado(poblacion.get(i).getFenotipo())));
            sumatoria=sumatoria + (func.calcularResultado(poblacion.get(i).getFenotipo()));
            System.out.println("sumatoria: " + sumatoria);
        }
    }
    

   

}
