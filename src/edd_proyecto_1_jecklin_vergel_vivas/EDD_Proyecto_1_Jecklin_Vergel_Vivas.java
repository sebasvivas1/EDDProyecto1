
package edd_proyecto_1_jecklin_vergel_vivas;

import javax.swing.JOptionPane;

public class EDD_Proyecto_1_Jecklin_Vergel_Vivas {
        
    public static void main(String[] args) {
        double[][] probando;
        Funciones f = new Funciones();
        String[] list = f.cargarDatos();
        ListaCiudades ciudades = f.obtenerCiudades(list);
        ciudades.listar();
        f.invertirArreglo(list);
        double[][] m = f.obtenerCosto(list, 4);
        for(int i = 0; i < m.length; i++){ 
            for(int j = 0; j < m[i].length; j++){ 
                System.out.print(m[i][j] + " ");    // Imprime elemento 
            } 
            System.out.println();    // Imprime salto de línea 
        }
        
        ColoniaHormigas probarVisibilidad = new ColoniaHormigas();
        
        
        
    }
}
