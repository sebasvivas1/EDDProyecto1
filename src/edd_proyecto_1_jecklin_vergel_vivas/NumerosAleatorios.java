
package edd_proyecto_1_jecklin_vergel_vivas;

import java.util.Random;

public class NumerosAleatorios {

    private int valorInicial;
    private int valorFinal;
    private ListaNumeros listaNumeros = new ListaNumeros();
    
    

    public NumerosAleatorios(int valorInicial, int valorFinal) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;

    }

    public int numeroAleatorio(Random rand) {
        int r = (int) (rand.nextDouble() * (getValorFinal() - getValorInicial() + 1) + getValorInicial());
        return r;
    }

    public void generarNumeroAleatorio(Random rand ) {
        for (int i = 0; i < this.getValorFinal()-1 ; i++) {
            int numero = numeroAleatorio(rand);
            if (this.getListaNumeros().esVacio() == true) {
                this.getListaNumeros().insertarAlFinal(numero);
            }else{
                if (this.getListaNumeros().existeNumero(numero, this.getListaNumeros()) == false) {
                    this.getListaNumeros().insertarAlFinal(numero);
                }
                else{
                    i--;
                }
            }
        }
    }

    public int getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public int getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(int valorFinal) {
        this.valorFinal = valorFinal;
    }

    public ListaNumeros getListaNumeros() {
        return listaNumeros;
    }

    public void setListaNumeros(ListaNumeros listaNumeros) {
        this.listaNumeros = listaNumeros;
    }
}
