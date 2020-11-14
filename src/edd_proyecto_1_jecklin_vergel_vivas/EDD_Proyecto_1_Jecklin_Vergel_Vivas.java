package edd_proyecto_1_jecklin_vergel_vivas;

import java.util.Random;

public class EDD_Proyecto_1_Jecklin_Vergel_Vivas {

    public static void main(String[] args) throws Exception {
        ColoniaHormigas ch = new ColoniaHormigas();
        Random rand = new Random();
        
        Hormiga xd = ch.cerebro(rand, 200,1.0, 8.0, 1, 1);
        System.out.println(xd.getFitness());
      
        
        
    }
}
