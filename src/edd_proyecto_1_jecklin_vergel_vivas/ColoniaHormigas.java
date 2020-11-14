package edd_proyecto_1_jecklin_vergel_vivas;

import java.util.Random;

public class ColoniaHormigas {

    public double[][] InicializarFeromonas(int n) {
        double[][] Feromonas = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Feromonas[i][j] = 1 / n;
            }
        }
        return Feromonas;
    }

    public double[][] InicializarVisibilidad(double[][] costo, int n) {
        double[][] visibilidad = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (costo[i][j] != 0) {
                    double aux = (1 / costo[i][j]);
                    visibilidad[i][j] = aux;
                } else {
                    visibilidad[i][j] = 0;
                }
            }
        }
        return visibilidad;
    }

    public double[][] probabilidadPorCamino(int n, double[][] feromonas, double[][] visibilidad, int alpha, int beta) {
        double[][] probabilidadPorCamino = new double[n][n];
        double suma = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {

                    // Aca se evalua que el parámetro Alpha y Betta pasado por el usuario no sea un número negativo. 
                    //Si es negativo entonces se asigna el valor predeterminado.
                    if (alpha > 0) {
                        alpha = 1;
                    }
                    if (beta > 0) {
                        beta = 2;
                    }
                    double aux = (double) (Math.pow(feromonas[i][j], alpha) * (Math.pow(visibilidad[i][j], beta))); // El usuario podrá modificar alpha y beta.
                    probabilidadPorCamino[i][j] = aux;
                    suma = aux + suma;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    probabilidadPorCamino[i][j] = probabilidadPorCamino[i][j] / suma;
                }
            }
        }

        return probabilidadPorCamino;
    }

    /*public boolean Esta(int origen, int destino, Recorrido camino) {
        int aux;
        for (int i = 0; i < camino.getTamanio(); i++) {
            if (origen == camino.buscar(i)) {

                aux = i + 1;
                if (destino == camino.buscar(aux)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }*/

    /*public double[][] ActualizarFeromonas(Hormiga hormiga, double[][] feromonas, int n, double evaporacion) {
        double sumaFeromonas = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumaFeromonas = feromonas[i][j] + sumaFeromonas;
            }
        }

        int o = 0;
        while (o < n) {
            int d = 1;
            while (d < n) {
                if (o != d) {
                    if (Esta(o, d, hormiga.getRecorrido()) == true) {
                        feromonas[o][d] = ((1 - evaporacion) * feromonas[o][d]) + (evaporacion * (1 / hormiga.getRecorrido()));
                        feromonas[d][o] = ((1 - evaporacion) * feromonas[d][o]) + (evaporacion * (1 / hormiga.getRecorrido()));
                    } else {
                        feromonas[o][d] = ((1 - evaporacion) * feromonas[o][d]);
                        feromonas[d][o] = ((1 - evaporacion) * feromonas[d][o]);
                    }
                }
                d++;
            }
            o++;
        }

        return feromonas;
    }*/

    /*public Hormiga crearHormiga(Random rand, int n) {
        NumerosAleatorios aleatorios = new NumerosAleatorios(1, n - 1);
        Hormiga hormiga = new Hormiga(n);
        // hormiga.getCamino().add(0);
        hormiga.insertarAlFinal(0);

        for (int i = 1; i < n; i++) {
            int aux = aleatorios.generarNumeroAleatorio(rand);
            // hormiga.getCamino().add(i, aux);
            hormiga.InsertarAlFinal(i, aux);
        }
        return hormiga;
    }*/

}
