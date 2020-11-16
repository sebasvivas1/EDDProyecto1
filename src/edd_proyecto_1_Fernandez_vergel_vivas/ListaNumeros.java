/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto_1_Fernandez_vergel_vivas;

import javax.swing.JOptionPane;

/**
 *
 * @author sebastian
 */
public class ListaNumeros {

    private Numero pFirst;
    private Numero pLast;
    private int tamanio;

    public ListaNumeros() {
        this.pFirst = null;
        this.pLast = null;
        this.tamanio = 0;
    }

    public boolean esVacio() {
        if (tamanio == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setpLast(Numero pLast) {
        this.pLast = pLast;
    }

    public void insertarAlFinal(int numero) {
        Numero pAux;
        int index = tamanio;
        if (esVacio()) {
            Numero pNew = new Numero(numero, index);
            pFirst = pLast = pNew;
            tamanio++;
        } else {
            Numero pNew = new Numero(numero, index);
            pLast.setpNext(pNew);
            pLast = pNew;
            tamanio++;
        }
    }

    public int getTamanio() {
        return tamanio;
    }

    public boolean existeNumero(int numero, ListaNumeros lista) {
        Numero pAux = getpFirst();
        if (!lista.esVacio()) {
            while (pAux.getNumero() != numero) {
                if (pAux == getpLast()) {
                    return false;
                }
                pAux = pAux.pNext;
            }
        }
        return true;
    }

    public int recorrer(Recorrido camino) {
        Numero pAux;
        int resultado = 0;
        pAux = getpFirst();
        while (pAux != null) {
            camino.insertarAlFinal(this.leer(pAux));
            pAux = pAux.getpNext();
        }
        return resultado;
    }

    public int leer(Numero pValor) {
        return pValor.getIndex();
    }

    public boolean esVacia() {
        return getpFirst() == null;
    }

    public void listar() {
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            Numero aux = getpFirst();
            // Posicion de los elementos de la lista.
            int i = 0;
            // Recorre la lista hasta el final.
            while (aux != null) {
                // Imprime en pantalla el valor del nodo.
                System.out.print(i + ".[ " + aux.getNumero() + " ]");
                // Avanza al siguiente nodo.
                aux = aux.getpNext();
                // Incrementa el contador de la posión.
                i++;
            }
        }
    }

    public Numero getpFirst() {
        return pFirst;
    }

    public void setpFirst(Numero pFirst) {
        this.pFirst = pFirst;
    }

    public Numero getpLast() {
        return pLast;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int obtenerValor(int posicion) {
        try {
            if (posicion >= 0 && posicion < tamanio) {
                if (posicion == 0) {
                    return pFirst.getNumero();
                } else {
                    Numero aux = pFirst;
                    for (int i = 0; i < posicion; i++) {
                        aux = aux.getpNext();
                    }
                    return aux.getNumero();
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Posicion no existente");
        }
        return 0;
    }
}
