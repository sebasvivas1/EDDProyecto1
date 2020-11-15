package edd_proyecto_1_jecklin_vergel_vivas;

import Interfaz.Intro;
import java.util.Random;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class EDD_Proyecto_1_Jecklin_Vergel_Vivas {

    public static void main(String[] args) {
        ColoniaHormigas colonia = new ColoniaHormigas();
        Random rand = new Random();

        Hormiga xd = colonia.cerebro(rand, 200, 0.5, 1, 2, 20);
        System.out.println("Mejor iteracion: " + xd.getBestIteracion());
        System.out.println("Nombre "+xd.getNombre());   
        System.out.println("Fitness: " + xd.getFitness());
        xd.getCamino().listar();
    }
}
