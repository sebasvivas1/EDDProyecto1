
package edd_proyecto_1_jecklin_vergel_vivas;

import javax.swing.JOptionPane;

public class EDD_Proyecto_1_Jecklin_Vergel_Vivas {
        
    public static void main(String[] args) {
        Funciones f = new Funciones();
        ColoniaHormigas ch = new ColoniaHormigas();
        String[] list = f.cargarDatos();
        ListaCiudades ciudades = f.obtenerCiudades(list);
        //ciudades.listar();
        f.invertirArreglo(list);
        double[][] m = f.obtenerCosto(list, 4);
//        for(int i = 0; i < m.length; i++){ 
//            for(int j = 0; j < m[i].length; j++){ 
//                System.out.print(m[i][j] + " ");    // Imprime elemento 
//            } 
//            System.out.println();    // Imprime salto de línea 
//        }
        double k[][]= ch.InicializarFeromonas(4);
        double h[][]= ch.InicializarVisibilidad(m, 4);
        
        double g[][] = ch.probabilidadPorCamino(4, m, h, 1, 2);
        
                for(int i = 0; i < g.length; i++){ 
            for(int j = 0; j < g[i].length; j++){ 
                System.out.print(g[i][j] + " ");    // Imprime elemento 
            } 
            System.out.println();    // Imprime salto de línea 
            
            Recorrido r = new Recorrido();
            
            r.insertarAlFinal(1);
            r.insertarAlFinal(2);
            r.insertarAlFinal(3);
            
            
            System.out.println(r.getTamanio());
            System.out.println(r.getpLast().getValor());
            System.out.println(r.enRecorrido(7));
            
    }
}
}
