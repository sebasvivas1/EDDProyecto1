
package edd_proyecto_1_jecklin_vergel_vivas;

public class Hormiga {

    private String nombre;
    double recorrido;
    private int posicion;
    Recorrido camino;

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

    public Hormiga(int n) {
        this.nombre = "h" + n;
        this.recorrido = 0;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

}
