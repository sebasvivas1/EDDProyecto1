package edd_proyecto_1_jecklin_vergel_vivas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Funciones {
    
    //Cargar los datos del txt y generar un arreglo de strings. Retorna dicho arreglo.
    public String[] cargarDatos() {
        String linea;
        String txt = "";
//        String path = "test\\Datos.txt";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((linea = br.readLine()) != null) {
                    if (!linea.isEmpty()) {
                        txt += linea + '\n';
                    }
                }
                br.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer.");
        }
        String[] list = txt.split("\n");
        return list;
    }

    //Recibe el arreglo del txt y crea una lista con las ciudades correspondientes. Regresa dicha lista.
    public ListaCiudades obtenerCiudades(String[] datosTxt) {
        ListaCiudades Ciudades = new ListaCiudades();
        for (int i = 1; i < datosTxt.length; i++) {
            boolean bucle = true;
            while (bucle == true) {
                if (!datosTxt[i].toLowerCase().equals("rutas")) {
                    String[] ciudad = datosTxt[i].split(",");
                    Ciudades.insertarAlFinal(ciudad[0]);
                    i++;
                } else if (datosTxt[i].toLowerCase().equals("rutas")) {
                    bucle = false;
                }
            }
            break;
        }
        return Ciudades;
    }

    //Recibe el arreglo del txt y la cantidad de ciudades para crear la mtariz de costo. Regresa dicha matriz.
    public double[][] obtenerCosto(String[] datosTxt, int n) {
        double[][] costo = new double[n][n];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (j == k) {
                    costo[j][k] = 0.0;
                }
            }
        }
        boolean bucle = true;
        for (int i = 0; i < datosTxt.length; i++) {
            while (bucle == true) {
                if (!datosTxt[i].toLowerCase().equals("rutas")) {
                    String[] ruta = datosTxt[i].split(",");
                    costo[Integer.parseInt(ruta[0])][Integer.parseInt(ruta[1])] = Double.parseDouble(ruta[2]);
                    i++;
                } else if (datosTxt[i].toLowerCase().equals("rutas")) {
                    bucle = false;
                }
            }
        }
        return costo;
    }

    //Invertir Arreglo
    public void invertirArreglo(String[] arreglo) {
        String temporal;
        int longitudDeArreglo = arreglo.length;
        for (int x = 0; x < longitudDeArreglo / 2; x++) {
            temporal = arreglo[x];
            int indiceContrario = longitudDeArreglo - x - 1;
            arreglo[x] = arreglo[indiceContrario];
            arreglo[indiceContrario] = temporal;
        }
    }
}
