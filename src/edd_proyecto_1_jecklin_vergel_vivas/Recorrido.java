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
public class Recorrido {

    private nodoRecorrido pFirst;
    private nodoRecorrido pLast;
    private int tamanio;

    public Recorrido() {
        this.pFirst = null;
        this.pLast = null;
        this.tamanio = 0;
    }

    public void insertarAlFinal(int valor) {
        nodoRecorrido pAux;
        int index = tamanio;
        if (esVacio()) {
            nodoRecorrido pNew = new nodoRecorrido(valor, index);
            pFirst = pLast = pNew;
            tamanio++;
        } else {
            nodoRecorrido pNew = new nodoRecorrido(valor, index);
            pLast.setpNext(pNew);
            pLast = pNew;
            tamanio++;
        }
    }

    public boolean enRecorrido(int numero) {
        nodoRecorrido pAux = pFirst;
        if (!esVacio()) {
            while (pAux.getValor() != numero) {
                if (pAux == pLast) {
                    return false;
                }
                pAux = pAux.getpNext();
            }
            return true;
        }
        return false;
    }
    
     public nodoRecorrido obtenerRecorridoIndex(int index) {
        nodoRecorrido pAux = pFirst;
        if (!esVacio()) {
            if (index <= 400 || index >= 0) {
                while (pAux.getIndex() != index) {
                    pAux = pAux.getpNext();
                }
                return pAux;
            }
            JOptionPane.showMessageDialog(null, "ERROR: INDICE INVALIDO");
        }
        return null;
    }

    public boolean esVacio() {
        return tamanio == 0;
    }

    public nodoRecorrido getpFirst() {
        return pFirst;
    }

    public void setpFirst(nodoRecorrido pFirst) {
        this.pFirst = pFirst;
    }

    public nodoRecorrido getpLast() {
        return pLast;
    }

    public void setpLast(nodoRecorrido pLast) {
        this.pLast = pLast;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public boolean esVacia() {
        return pFirst == null;
    }

    public void listar() {
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            nodoRecorrido aux = pFirst;
            // Posicion de los elementos de la lista.
            int i = 0;
            // Recorre la lista hasta el final.
            while (aux != null) {
                // Imprime en pantalla el valor del nodo.
                System.out.print(i + ".[ " + aux.getValor() + " ]" + "\n");
                // Avanza al siguiente nodo.
                aux = aux.getpNext();
                // Incrementa el contador de la posión.
                i++;
            }
        }
    }

}
