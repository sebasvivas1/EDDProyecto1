/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto_1_jecklin_vergel_vivas;

/**
 *
 * @author Edward Vergel
 */
public class Hormiga {

    private String nombre;
    private double fitness;
    private int posicion;
    Recorrido camino = new Recorrido();
    private int bestIteracion;

    public Hormiga(String n) {
        this.nombre = "h" + n;
        this.fitness = 0;
        this.posicion = posicion;
    }

    public Recorrido getCamino() {
        return camino;
    }

    public void setCamino(Recorrido camino) {
        this.camino = camino;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public int getBestIteracion() {
        return bestIteracion;
    }

    public void setBestIteracion(int bestIteracion) {
        this.bestIteracion = bestIteracion;
    }

}
