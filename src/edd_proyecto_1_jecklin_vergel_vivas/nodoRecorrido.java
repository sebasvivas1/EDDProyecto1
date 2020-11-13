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
public class nodoRecorrido {
    private nodoRecorrido pNext;
    private int valor;
    
    public nodoRecorrido(int valor){
        this.pNext = null;
        this.valor = valor;
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
