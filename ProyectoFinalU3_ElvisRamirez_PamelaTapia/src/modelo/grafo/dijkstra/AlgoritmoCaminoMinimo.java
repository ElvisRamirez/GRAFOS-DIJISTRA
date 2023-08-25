package modelo.grafo.dijkstra;

import static modeloDeVistaGrafo.GraficadorGrafoFrame.R_repaint;

import static modeloDeVistaGrafo.GraficadorGrafoFrame.jPanel1;

import java.awt.Color;

import javax.swing.JOptionPane;

import mundo.Grafo;
import mundo.Lienzo;
import mundo.Nodo;

public class AlgoritmoCaminoMinimo {
	   private Grafo grafos; // Grafo sobre el que se ejecutará el algoritmo
	    private int subTope; // Contador auxiliar para la iteración
	    private Nodo auxi = null; // Nodo auxiliar
	    private int auxAumulado; // Variable auxiliar para el acumulado de Tiempos
	    private int subAcomulado; // Variable auxiliar para el acumulado temporal
	    private Nodo nodo[]; // Arreglo de nodos
	    private int tope; // Cantidad total de nodos
	    private int permanente; // Nodo de inicio
	    private int nodoFin; // Nodo de destino
	   
	    public AlgoritmoCaminoMinimo (Grafo grafo, int tope,int permanente, int nodoFin){
	        this.grafos = grafo;        
	        this.tope = tope;
	        this.nodo= new Nodo[tope]; 
	        this.permanente = permanente;
	        this.nodoFin = nodoFin;
	        
	    }

	    public int getAcumulado(){
	        return nodo[nodoFin].getAcumulado(); 
	    }
	        
	    public void dijkstra(){ 
	    	 long startTime = System.currentTimeMillis(); // Tiempo inicial

	         for (int i = 0; i < tope; i++)  // creamos el vector nodo del tamanioo de tope el cual tiene el numero de nodo pintados 
	                    nodo[i]= new Nodo(); // Crea un arreglo de nodos
	      // Si el nodo de inicio es diferente al nodo final
	        if(permanente != nodoFin){
	             jPanel1.paint(jPanel1.getGraphics());
	             R_repaint(tope, grafos);  // Llama a R_repint para repintar el grafo 
	             Lienzo.clickSobreNodo(jPanel1.getGraphics(), grafos.getCordeX(permanente), grafos.getCordeY(permanente), null,Color.GREEN); // pinta de color GREEN los nodos
	            
	        
	            nodo[permanente].setVisitado(true);        
	            nodo[permanente].setNombre(permanente);       
	            int iteraciones = 0; // Contador de iteraciones
	            do{            
	              subAcomulado=0;
	              auxAumulado = 2000000000; // lo igualamos a esta cifra ya q el acomulado de los nodos, supuestamente  nunca sera mayor 
	              nodo[permanente].setEtiqueta(true); 
	              // Recorre los nodos y actualiza los acumulados
	              for (int j = 0; j < tope; j++) {
	                  if(grafos.getmAdyacencia(j, permanente)==1){
	                        subAcomulado= nodo[permanente].getAcumulado()+grafos.getmCoeficiente(j, permanente);                                 
	                        if(subAcomulado <= nodo[j].getAcumulado() && nodo[j].isVisitado()==true && nodo[j].isEtiqueta()== false){
	                            nodo[j].setAcumulado(subAcomulado);
	                            nodo[j].setVisitado(true);
	                            nodo[j].setNombre(j);
	                            nodo[j].setPredecesor(nodo[permanente]);
	                        }
	                        else if( nodo[j].isVisitado()==false){
	                            nodo[j].setAcumulado(subAcomulado);
	                            nodo[j].setVisitado(true);
	                            nodo[j].setNombre(j);
	                            nodo[j].setPredecesor(nodo[permanente]); 
	                       }
	                 }
	              }
	           // Encuentra el próximo nodo permanente
	              for (int i = 0; i <tope; i++) { // buscamos cual de los nodos visitado tiene el acumulado menor par escogerlo como permanente 
	                if(nodo[i].isVisitado()== true && nodo[i].isEtiqueta()== false){
	                   if(nodo[i].getAcumulado()<=auxAumulado){
	                       permanente= nodo[i].getNombre();
	                       auxAumulado= nodo[i].getAcumulado();
	                   }
	                }               
	             }
	            subTope++;
	            iteraciones++;
	            System.out.print("Iteración " + iteraciones + ": Nodos visitados -> ");
	            for (int i = 0; i < tope; i++) {
	                if (nodo[i].isVisitado()) {
	                    System.out.print(i + " ");
	                }
	            }
	            System.out.println();
	          }while(subTope<tope+1); // Fin del bucle principal     
	          auxi= nodo[nodoFin]; // Nodo auxiliar para el rastreo del camino
	           if(auxi.getPredecesor() == null )
	             JOptionPane.showMessageDialog(null,"No se puede llegar a la ruta "+nodoFin);          
	        // Rastrea y pinta el camino
	           while(auxi.getPredecesor() != null){           
	              Lienzo.pintarCamino(jPanel1.getGraphics(), grafos.getCordeX(auxi.getNombre()), grafos.getCordeY(auxi.getNombre()), grafos.getCordeX(auxi.getPredecesor().getNombre()), grafos.getCordeY(auxi.getPredecesor().getNombre()),Color.GREEN);
	              Lienzo.clickSobreNodo(jPanel1.getGraphics(), grafos.getCordeX(auxi.getNombre()), grafos.getCordeY(auxi.getNombre()), null,Color.GREEN);
	             auxi=auxi.getPredecesor();              
	          }  
	          
	         Lienzo.clickSobreNodo(jPanel1.getGraphics(), grafos.getCordeX(nodoFin), grafos.getCordeY(nodoFin), null,Color.GREEN);   
	         long endTime = System.currentTimeMillis(); // Tiempo final

	            // Calcula el tiempo de ejecución
	            long executionTime = endTime - startTime;

	            System.out.println("Tiempo de ejecución: " + executionTime + " ms");
	            System.out.println("Iteraciones realizadas: " + iteraciones);
	       }
	       else Lienzo.clickSobreNodo(jPanel1.getGraphics(), grafos.getCordeX(nodoFin), grafos.getCordeY(nodoFin), null,Color.GREEN);    
	        
	    }
	    
	    
	
	}


