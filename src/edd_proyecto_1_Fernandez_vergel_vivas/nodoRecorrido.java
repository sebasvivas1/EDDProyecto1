/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto_1_Fernandez_vergel_vivas;

/**
 *
 * @author Edward Vergel
 */
public class nodoRecorrido {
    private nodoRecorrido pNext;
    private int valor;
    private int index;
    
    public nodoRecorrido(int valor, int index){
        this.pNext = null;
        this.valor = valor;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public nodoRecorrido getpNext() {
        return pNext;
    }

    public void setpNext(nodoRecorrido pNext) {
        this.pNext = pNext;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
