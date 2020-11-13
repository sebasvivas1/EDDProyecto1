/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto_1_jecklin_vergel_vivas;

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

    public void insertarAlFinal(int n) {
        Numero pAux;
        int index = tamanio;
        if (esVacio()) {
            Numero pNew = new Numero(n, index);
            pFirst = pLast = pNew;
            tamanio++;
        } else {
            Numero pNew = new Numero(n, index);
            pLast.setpNext(pNew);
            pLast = pNew;
            tamanio++;
        }
    }

    public int getTamanio() {
        return tamanio;
    }

    public boolean existeNumero(int numero, ListaNumeros lista) {
        Numero pAux = pFirst;
        if (!lista.esVacio()) {
            while (pAux.getNumero() != numero) {
                if (pAux == pLast) {
                    return false;
                }
                pAux = pAux.pNext;
            }
        }

        return true;
    }

}
