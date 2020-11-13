package edd_proyecto_1_jecklin_vergel_vivas;

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
                        alpha = 2;
                    }
                    if (beta > 0) {
                        beta = 1;
                    }
                    double aux = (double) (Math.pow(feromonas[i][j], alpha) * (Math.pow(visibilidad[i][j], beta))); // El usuario podrá modificar alpha y betta.
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
