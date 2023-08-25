package modelo.grafo.dijkstra;

import static modeloDeVistaGrafo.GraficadorGrafoFrame.R_repaint;
import static modeloDeVistaGrafo.GraficadorGrafoFrame.ingresarNodoOrigen;
import static modeloDeVistaGrafo.GraficadorGrafoFrame.jPanel1;

import java.awt.Color;

import mundo.Grafo;
import mundo.Lienzo;

public class AlgoritmoPrim {
	   private int cumulado;
	    private int aristaMenor;
	    private int fin;
	    private boolean estaNodo = false;
	    private boolean aumentaTamano;
	    private int nodoApuntado;
	    private int nodoApuntador;
	    private int tamano;
	    private int arsitaMayor;
	    private Grafo grafos;
	    private int tope;
	    private int nodoOrigen;

	    public AlgoritmoPrim(Grafo grafo, int top, int aristaMayor) {
	        //  // Inicializar variables de instancia
	    	this.cumulado = 0;
	        this.aristaMenor = 0;
	        this.fin = 0;
	        this.estaNodo = false;
	        this.aumentaTamano = false;
	        this.nodoApuntado = 0;
	        this.nodoApuntador = 0;
	        this.tamano = 1;
	        this.arsitaMayor = aristaMayor;
	        this.grafos = grafo;
	        this.tope = top;
	    }

	    public int getCumulado() {
	        return cumulado;
	    }

	    public void prim() {
	    	  // Leer la entrada del usuario para el nodo de inicio
	        this.nodoOrigen = ingresarNodoOrigen("Digite la ruta de inicio", "NO EXISTE LA RUTA", tope);
	        // Limpiar el área de dibujo
	        jPanel1.paint(jPanel1.getGraphics());
	        // Volver a pintar el grafo
	        R_repaint(tope, grafos);
	     // Crear nodos en el grafo
	        grafos.crearEnGrafo(tope);
	        // Establecer el nodo de inicio en el grafo
	        grafos.setEnGrafo(0, nodoOrigen);

	     // Bucle principal: se ejecuta hasta que el valor de 'fin' sea menor que 2
	        do {
	            // Inicializar 'aristaMenor' con el valor máximo de 'arsitaMayor'
	            this.aristaMenor = this.arsitaMayor;
	            // Inicializar 'fin' en 2
	            this.fin = 2;
	            
	            // Bucle para explorar los nodos en 'grafos.getEnGrafo(j)'
	            for (int j = 0; j < tamano; j++) {
	                // Bucle para explorar todos los nodos en el grafo 'grafos'
	                for (int k = 0; k < tope; k++) {
	                    // Verificar si hay una conexión entre los nodos 'k' y 'grafos.getEnGrafo(j)'
	                    if (grafos.getmAdyacencia(k, grafos.getEnGrafo(j)) == 1) {
	                        // Verificar si el nodo 'k' ya está en el grafo
	                        for (int h = 0; h < tamano; h++) {
	                            if (grafos.getEnGrafo(h) == k) {
	                                this.estaNodo = true;
	                                break;
	                            }
	                        }
	                        // Si el nodo 'k' no está en el grafo y cumple con las condiciones de la arista
	                        if (estaNodo == false) {
	                            if (grafos.getmCoeficiente(k, grafos.getEnGrafo(j)) <= aristaMenor && grafos.getmCoeficiente(k, grafos.getEnGrafo(j)) > 0) {
	                                // Actualizar valores relacionados con la arista más corta
	                                aristaMenor = grafos.getmCoeficiente(k, grafos.getEnGrafo(j));
	                                this.nodoApuntado = k;
	                                this.aumentaTamano = true;
	                                this.nodoApuntador = grafos.getEnGrafo(j);
	                                this.fin = 1;
	                            }
	                        }
	                        this.estaNodo = false;
	                    }
	                }
	            }
	            
	            // Si se encontró una arista válida para agregar al grafo
	            if (aumentaTamano == true) {
	                // Dibujar el camino entre nodos en rojo
	                Lienzo.pintarCamino(jPanel1.getGraphics(), grafos.getCordeX(nodoApuntador), grafos.getCordeY(nodoApuntador), grafos.getCordeX(nodoApuntado), grafos.getCordeY(nodoApuntado), Color.red);
	                // Resaltar nodos en rojo
	                Lienzo.clickSobreNodo(jPanel1.getGraphics(), grafos.getCordeX(nodoApuntador), grafos.getCordeY(nodoApuntador), null, Color.red);
	   
	                // Agregar el nodo apuntado al grafo
	                grafos.setEnGrafo(tamano, nodoApuntado);
	                this.tamano++;
	                this.aumentaTamano = false;
	                // Incrementar el valor acumulado con la longitud de la arista más corta
	                this.cumulado += this.aristaMenor;
	            }
	        } while (fin < 2);  // Continuar mientras haya aristas por agregar al grafo


	}
}

