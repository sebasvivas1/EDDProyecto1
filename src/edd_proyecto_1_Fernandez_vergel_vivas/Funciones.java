package edd_proyecto_1_Fernandez_vergel_vivas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Funciones {

    //Cargar los datos del txt y generar un arreglo de strings. Retorna dicho arreglo.
    public String[] cargarDatos() {
        String linea;
        String txt = "";
        String path = "test\\Wakanda.txt";
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

    //Eliminar ciudad
    public double[][] eliminarCiudad(ListaCiudades ciudades, double[][] costos, int nFila, int nColumna) {
        int ren = nFila;
        int colRemove = nColumna;

        ciudades.removerPorReferencia(nFila);
        Ciudad temp = ciudades.getpFirst();
        for (int i = 0; i < ciudades.getTamanio(); i++) {
            temp.setIndex(i);
            temp = temp.getpNext();
        }
        return this.removeCol(this.removerow(costos, ren), colRemove);

    }

    //Eliminar fila matriz
    public double[][] removerow(double mat[][], int ren) {
        int rengre = ren;//row to remove
        double mat2[][] = new double[mat.length - 1][mat[0].length];
        int p = 0;
        for (int i = 0; i < mat.length; ++i) {
            if (i == rengre) {
                continue;
            }
            int q = 0;
            for (int j = 0; j < mat[0].length; ++j) {
                mat2[p][q] = mat[i][j];
                ++q;
            }
            ++p;
        }
        return mat2;
    }

    //Eliminar columna matriz
    public double[][] removeCol(double[][] array, int colRemove) {
        int row = array.length;
        int col = array[0].length - 1;
        int oldCol = array[0].length;

        double[][] newArray = new double[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0, k = 0; j < oldCol && k < col; j++) {
                if (j != colRemove) {
                    newArray[i][k++] = array[i][j];
                }
            }
        }

        return newArray;
    }

    //Subir datos al .txt. Recibe la lista de ciudades y la matriz del grafo (matriz costo).
    public void subirDatos(ListaCiudades ciudades, double[][] costo) {
        String ciudadesActuales = "";
        if (!ciudades.esVacia()) {
            Ciudad temp = ciudades.getpFirst();
            for (int i = 0; i < ciudades.getTamanio(); i++) {
                ciudadesActuales += temp.getNombre() + "," + temp.getIndex() + "\n";
                temp = temp.getpNext();
            }
        }
        try {
            PrintWriter pw = new PrintWriter("test\\Wakanda.txt");
            pw.print("ciudades" + "\n");
            pw.append(ciudadesActuales);
            pw.append("rutas" + "\n");
            for (int i = 0; i < costo.length; i++) {
                for (int j = 0; j < costo[i].length; j++) {
                    if (i != j) {
                        String cadena0 = String.valueOf(i);
                        String cadena1 = String.valueOf(j);
                        int cadena2 = (int) costo[i][j];
                        pw.append(cadena0 + "," + cadena1 + "," + cadena2 + "\n");
                    }
                }
            }
            pw.close();
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error al guardar las ciudades.");
        }
    }
}
