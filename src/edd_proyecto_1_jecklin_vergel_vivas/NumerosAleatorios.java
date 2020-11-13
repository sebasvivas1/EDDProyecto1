/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto_1_jecklin_vergel_vivas;

import java.util.Random;

/**
 *
 * @author sebastian
 */
public class NumerosAleatorios {

    private int valorInicial;
    private int valorFinal;
    private ListaNumeros listaNumeros = new ListaNumeros();

    public NumerosAleatorios(int valorInicial, int valorFinal) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;

    }

    private int numeroAleatorio(Random rand) {
        int r = (int) (rand.nextDouble() * (valorFinal - valorInicial + 1) + valorInicial);
        return r;
    }

    public int generarNumeroAleatorio(Random rand) {

        if (listaNumeros.getTamanio() < (valorFinal - valorInicial) + 1) {

            int numero = numeroAleatorio(rand);
            if (listaNumeros.esVacio()) {
                listaNumeros.insertarAlFinal(numero);
                return numero;
            } else {
                if (listaNumeros.existeNumero(numero, listaNumeros)) {
                    return generarNumeroAleatorio(rand);
                } else {
                    listaNumeros.insertarAlFinal(numero);
                    return numero;
                }
            }
        } else {
            return -1;
        }
    }
}
