package edd_proyecto_1_jecklin_vergel_vivas;

public class ColoniaHormigas {

    public double[][] InicializarFeromonas(double[][] visibilidad, int n, double p) { // Aca borrar la visibilidad, lo puse para que no saltara error.
        double[][] Feromonas = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Feromonas[i][j] = visibilidad[i][j]; //Esto es lo que hay que terminar
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

    public double[][] probabilidadPorCamino(int n, double[][] feromonas, double[][] visibilidad) {
        double[][] probabilidadPorCamino = new double[n][n];
        double suma = 0;
        int alpha = 1;
        int betta = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    double aux = (double) (Math.pow(feromonas[i][j], alpha) * (Math.pow(visibilidad[i][j], betta))); // El usuario podrá modificar alpha y betta.
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
}
