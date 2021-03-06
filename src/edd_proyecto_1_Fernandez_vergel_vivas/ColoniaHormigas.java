package edd_proyecto_1_Fernandez_vergel_vivas;

import java.util.Random;

public class ColoniaHormigas {

    public double[][] InicializarFeromonas(int n) {
        double[][] Feromonas = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Feromonas[i][j] = (double) 1 / n;
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
        double suma = 0.0;

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
                    probabilidadPorCamino[i][j] = (double) aux;
                    suma = (double) aux + suma;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    probabilidadPorCamino[i][j] = (double) probabilidadPorCamino[i][j] / suma;
                }
            }
        }

        return probabilidadPorCamino;
    }

    public boolean Esta(int origen, int destino, Recorrido camino) {
        int aux;
        for (int i = 0; i < camino.getTamanio(); i++) {
            // if (origen == camino.buscar(i)) {

            if (camino.enRecorrido(origen)) {
                aux = i + 1;
                // if (destino == camino.buscar(aux)) {

                if (camino.enRecorrido(destino)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public double[][] ActualizarFeromonas(Hormiga hormiga, double[][] feromonas, int n, double evaporacion) {
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
                    // Revisar esta hormiga.getCamino(), originalmente era getRecorrido()
                    if (Esta(o, d, hormiga.getCamino()) == true) {
                        feromonas[o][d] = ((1 - evaporacion) * feromonas[o][d]) + (evaporacion * (1 / hormiga.getFitness()));
                        feromonas[d][o] = ((1 - evaporacion) * feromonas[d][o]) + (evaporacion * (1 / hormiga.getFitness()));
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
    }

    public Hormiga crearHormiga(Random rand, int n) {
        n--;
        NumerosAleatorios aleatorios = new NumerosAleatorios(1, n);
        Hormiga hormiga = new Hormiga(String.valueOf(0));
        hormiga.getCamino().insertarAlFinal(0);
        aleatorios.generarNumeroAleatorio(rand);
        ListaNumeros aux = aleatorios.getListaNumeros();
        for (int i = 0; i < aux.getTamanio(); i++) {
            hormiga.getCamino().insertarAlFinal(aux.obtenerValor(i));
        }
        hormiga.getCamino().insertarAlFinal(n++);
        return hormiga;
    }

    public int siguienteCiudad(ListaCiudades ciudades, double[][] probabilidadPorCamino, int n, Random rand, int origen) {
        int destino = 0;
        double menor = n;
        double sumaProbabilidadPorCamino = 0.0;

        for (int i = 1; i < n; i++) {
            if (ciudades.obtenerCiudadIndex(i).isVisitado() == false && origen != i) {
                sumaProbabilidadPorCamino = probabilidadPorCamino[origen][i] + (double) sumaProbabilidadPorCamino;
            }
        }
        for (int i = 1; i < n; i++) {
            if (ciudades.obtenerCiudadIndex(i).isVisitado() == false) {
                double aux = probabilidadPorCamino[origen][i] / (double) sumaProbabilidadPorCamino;
                ciudades.obtenerCiudadIndex(i).setProbabilidad(aux);
            }
        }
        for (int i = 0; i < ciudades.getTamanio(); i++) {
            double aux = 0;
            if (ciudades.obtenerCiudadIndex(i).isVisitado() == false) {
                for (int j = 0; j < ciudades.getTamanio(); j++) {
                    if (ciudades.obtenerCiudadIndex(i).isVisitado() == false) {
                        if (ciudades.obtenerCiudadIndex(i).getProbabilidad() >= ciudades.obtenerCiudadIndex(j).getProbabilidad()) {
                            aux = ciudades.obtenerCiudadIndex(j).getProbabilidad() + aux;
                        }
                    }
                }
            }
            ciudades.obtenerCiudadIndex(i).setProbabilidad(aux);
        }
        double aleatorio = Math.rint(rand.nextDouble() * 100) / 100;
        for (int i = 0; i < n; i++) {
            if (aleatorio <= ciudades.obtenerCiudadIndex(i).getProbabilidad() && ciudades.obtenerCiudadIndex(i).getProbabilidad() <= menor && ciudades.obtenerCiudadIndex(i).isVisitado() == false) {
                menor = ciudades.obtenerCiudadIndex(i).getIndex();
                destino = i;
            }
        }
        return destino;
    }

    //Sumar caminos para la hormiga
    public double sumaCaminos(Recorrido camino, double costos[][]) {
        double suma = 0;
        int j = 1;
        for (int i = 0; i < camino.getTamanio() - 1; i++) {
            int origen = camino.obtenerRecorridoIndex(i).getValor();
            int destino = camino.obtenerRecorridoIndex(j).getValor();
            suma = (double) costos[origen][destino] + suma;
            j++;
        }
        return suma;
    }

    public Hormiga cerebro(Random rand, int iteraciones, double evaporacion, int alpha, int betta, int cantidad) {
        Funciones f = new Funciones();
        String[] list = f.cargarDatos();
        ListaCiudades ciudades = f.obtenerCiudades(list);
        f.invertirArreglo(list);
        int n = ciudades.getTamanio();
        double[][] costo = f.obtenerCosto(list, n);
        ciudades.getpFirst().setVisitado(true);
        int cont = 0;

        double[][] visibilidad = InicializarVisibilidad(costo, n);
        double[][] feromonas = InicializarFeromonas(n);
        double[][] probabilidad = probabilidadPorCamino(n, feromonas, visibilidad, alpha, betta);

        Hormiga Best = crearHormiga(rand, n);
        Best.setFitness(sumaCaminos(Best.camino, costo));

        feromonas = ActualizarFeromonas(Best, feromonas, n, evaporacion);
        probabilidad = probabilidadPorCamino(n, feromonas, visibilidad, alpha, betta);

        for (int i = 0; i < iteraciones; i++) {
            while (cont <= cantidad) {
                if (cont == 0) {
                    Hormiga nHormiga = new Hormiga(String.valueOf(cont + 1));
                    nHormiga.camino.insertarAlFinal(0);
                    for (int j = 1; j < n; j++) {
                        int origen = nHormiga.camino.obtenerRecorridoIndex(j - 1).getValor();
                        int siguiente = siguienteCiudad(ciudades, probabilidad, n, rand, origen);
                        if (siguiente == (n - 1)) {
                            ciudades.obtenerCiudadIndex(siguiente).setVisitado(true);
                            nHormiga.camino.insertarAlFinal(siguiente);
                            j = n;
                        } else {
                            ciudades.obtenerCiudadIndex(siguiente).setVisitado(true);
                            nHormiga.camino.insertarAlFinal(siguiente);
                        }
                    }
                    nHormiga.setFitness(sumaCaminos(nHormiga.camino, costo));
                    if (nHormiga.getFitness() < Best.getFitness()) {
                        Best = nHormiga;
                        if (cont <= iteraciones) {
                            Best.setBestIteracion(cont);
                        }
                    }
                    feromonas = ActualizarFeromonas(Best, feromonas, n, evaporacion);
                    probabilidad = probabilidadPorCamino(n, feromonas, visibilidad, alpha, betta);
                    for (int k = 0; k < ciudades.getTamanio(); k++) {
                        ciudades.obtenerCiudadIndex(k).setVisitado(false);
                    }
                    cont++;
                } else {
                    Hormiga nHormiga = new Hormiga(String.valueOf(cont + 1));
                    nHormiga.camino.insertarAlFinal(0);
                    for (int l = 1; l < n; l++) {
                        int origen = nHormiga.camino.obtenerRecorridoIndex(l - 1).getValor();
                        int siguiente = siguienteCiudad(ciudades, probabilidad, n, rand, origen);
                        if (siguiente == (n - 1)) {
                            ciudades.obtenerCiudadIndex(siguiente).setVisitado(true);
                            nHormiga.camino.insertarAlFinal(siguiente);
                            l = n;
                        } else {
                            ciudades.obtenerCiudadIndex(siguiente).setVisitado(true);
                            nHormiga.camino.insertarAlFinal(siguiente);
                        }
                    }
                    nHormiga.setFitness(sumaCaminos(nHormiga.camino, costo));
                    if (nHormiga.getFitness() < Best.getFitness()) {
                        Best = nHormiga;
                        if (cont <= iteraciones) {
                            Best.setBestIteracion(cont);
                        }
                    }
                    feromonas = ActualizarFeromonas(Best, feromonas, n, evaporacion);
                    probabilidad = probabilidadPorCamino(n, feromonas, visibilidad, alpha, betta);
                    for (int m = 0; m < ciudades.getTamanio(); m++) {
                        ciudades.obtenerCiudadIndex(m).setVisitado(false);
                    }
                    cont++;
                }

            }
        }
        return Best;
    }
}
