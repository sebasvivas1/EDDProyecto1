package edd_proyecto_1_jecklin_vergel_vivas;

import Interfaz.Intro;
import java.util.Random;

public class EDD_Proyecto_1_Jecklin_Vergel_Vivas {

    public static void main(String[] args) throws Exception {
        ColoniaHormigas ch = new ColoniaHormigas();
        Random rand = new Random();
        
        Hormiga xd = ch.cerebro(rand, 1, 0.5 , 1 , 2, 20);
        System.out.println(xd.getFitness());
        
        for(int i=0; i< xd.getCamino().getTamanio();i++){
            System.out.print("" + xd.getCamino().obtenerRecorridoIndex(i).getValor());
        }
        System.out.println("\nFitness: "+xd.getFitness());
        /*Random rand = new Random();
        NumerosAleatorios aleatorios = new NumerosAleatorios(1, 6);
        aleatorios.generarNumeroAleatorio(rand);
        ColoniaHormigas colonia = new ColoniaHormigas();
        Hormiga h = colonia.crearHormiga(rand, 6);
        h.getCamino().listar();*/
        //ListaNumeros numeros = aleatorios.getListaNumeros();
        //numeros.listar();
    }
}
