
package edd_proyecto_1_jecklin_vergel_vivas;

import javax.swing.JOptionPane;


public class EDD_Proyecto_1_Jecklin_Vergel_Vivas {

    public static void main(String[] args) {

        Grafo grafo = new Grafo();
        
        grafo.insertarArista(3, 4, 5);
        grafo.insertarArista(5, 6, 2);
        grafo.insertarArista(1, 5, 1);
        grafo.insertarArista(7, 3, 9);
       
        for(int i = 0; i < grafo.getMatrix().length; i++){ 
	for(int j = 0; j < grafo.getMatrix()[i].length; j++){ 
		System.out.print(grafo.getMatrix()[i][j] + " ");
            }
        System.out.println( );
        }


    }
    
}
