/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto_1_Fernandez_vergel_vivas;

/**
 *
 * @author sebastian
 */
public class Numero {

    int numero;
    Numero pNext;
    int index;

    public Numero(int n, int index) {
        this.numero = n;
        this.index = index;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Numero getpNext() {
        return pNext;
    }

    public void setpNext(Numero pNext) {
        this.pNext = pNext;
    }

}
