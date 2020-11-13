
package edd_proyecto_1_jecklin_vergel_vivas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Funciones {
    
    public static String[] cargarDatos() {
        String line;
        String datosTxt="";
        String path = "test\\Datos.txt";
        String[] datosSplit = null;
        File file = new File(path);
        
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                while ((line = br.readLine()) != null) {
                    datosTxt += line + "\n";
                }
            }
            if (!"".equals(datosTxt)) {
                datosSplit = datosTxt.split("\n");
                for (int i = 0; i < datosSplit.length; i++) {
                    System.out.println(datosSplit[i]);
                }  
            }  
        }
        catch (IOException ex){
            JOptionPane.showMessageDialog(null,"Error");
        }
        return datosSplit;
    }
}
