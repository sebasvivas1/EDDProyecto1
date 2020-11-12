/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto_1_jecklin_vergel_vivas;

import javax.swing.JOptionPane;

/**
 *
 * @author Edward Vergel
 */
public class Grafo {

    private int max_vertices;
    private int max_aristas;
    private int aristas;
    private int matrix[][];

    //Contructor 
    public Grafo() {
        this.max_aristas = 30;
        this.max_vertices = 10; //Restriccion 
        this.aristas = 0;
        this.matrix = new int[max_vertices][max_vertices]; // Se crea una matriz solo de 0
        for (int i = 0; i < max_vertices; i++) {
            for (int j = 0; j < max_vertices; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    //PRIMITIVAS
    /**
     * Inserta una arista dada la relacion entre vertice1 y vertice2 y la
     * distancia entre los vertices dados
     *
     * @param vertice1 vertice1
     * @param vertice2 vertice2
     * @param dist distancia entre los dos vertices
     */
    public void insertarArista(int vertice1, int vertice2, int dist) {
        if (verticesValidos(vertice1, vertice2)) {
            if (aristas != max_aristas) {
                matrix[vertice1][vertice2] = dist;
                aristas++;
            } else {
                JOptionPane.showMessageDialog(null, "ERROR: NUMERO DE ARISTAS MAXIMAS ALCANZADO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: NUMERO DE ARISTAS MAXIMAS ALCANZADO");
        }
    }

    /**
     * Este metodo nos indica si existe una arista entre un par de vertice
     * dados.
     *
     * @param vertice1 vertice1
     * @param vertice2 vertice2
     * @return verdadero o falso.
     */
    public boolean existeArista(int vertice1, int vertice2) {
        if (verticesValidos(vertice1, vertice2)) {
            if (matrix[vertice1][vertice2] != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Este metodo nos indica si un par de vertices son validos.
     *
     * @param vertice1 vertice1
     * @param vertice2 vertice2
     * @return verdadero o falso.
     */
    public boolean verticesValidos(int vertice1, int vertice2) {
        return vertice1 < max_vertices && vertice2 < max_vertices;
    }

    public int getMax_vertices() {
        return max_vertices;
    }

    public void setMax_vertices(int max_vertices) {
        this.max_vertices = max_vertices;
    }

    public int getMax_aristas() {
        return max_aristas;
    }

    public void setMax_aristas(int max_aristas) {
        this.max_aristas = max_aristas;
    }

    public int getAristas() {
        return aristas;
    }

    public void setAristas(int aristas) {
        this.aristas = aristas;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

}
