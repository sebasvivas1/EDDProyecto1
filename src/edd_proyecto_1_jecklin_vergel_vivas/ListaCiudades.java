package edd_proyecto_1_jecklin_vergel_vivas;

import javax.swing.JOptionPane;

public class ListaCiudades {

    private Ciudad pFirst;
    private Ciudad pLast;
    private int tamanio;

    public ListaCiudades() {
        this.pFirst = null;
        this.pLast = null;
        this.tamanio = 0;
    }

    public void insertarAlFinal(String nombre) {
        Ciudad pAux;
        int index = tamanio;
        if (esVacio()) {
            Ciudad pNew = new Ciudad(nombre, index);
            pFirst = pLast = pNew;
            tamanio++;
        } else {
            Ciudad pNew = new Ciudad(nombre, index);
            pLast.setpNext(pNew);
            pLast = pNew;
            tamanio++;
        }
    }

    public Ciudad obtenerCiudadIndex(int index) {
        Ciudad pAux = pFirst;
        if (!esVacio()) {
            if (index >= 0 || index <= 19) {
                while (pAux.getIndex() != index) {
                    pAux = pAux.getpNext();
                }
                return pAux;
            }
            JOptionPane.showMessageDialog(null, "ERROR: INDICE INVALIDO");
        }
        return null;
    }

    /**
     * Busca si existe un valor en la lista.
     *
     * @param referencia valor a buscar.
     * @return true si existe el valor en la lista.
     */
    public boolean buscar(int referencia) {
        // Crea una copia de la lista.
        Ciudad aux = pFirst;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al final de la lista.
        while (aux != null && encontrado != true) {
            // Consulta si el valor del nodo es igual al de referencia.
            if (referencia == aux.getIndex()) {
                // Canbia el valor de la bandera.
                encontrado = true;
            } else {
                // Avansa al siguiente. nodo.
                aux = aux.getpNext();
            }
        }
        // Retorna el resultado de la bandera.
        return encontrado;
    }

    /**
     * Elimina un nodo que se encuentre en la lista ubicado por un valor de
     * referencia.
     *
     * @param referencia valor del nodo que se desea eliminar.
     */
    public void removerPorReferencia(int referencia) {
        // Consulta si el valor de referencia existe en la lista.
        if (buscar(referencia)) {
            // Consulta si el nodo a eliminar es el pirmero
            if (pFirst.getIndex()== referencia) {
                // El primer nodo apunta al siguiente.
                pFirst = pFirst.getpNext();
            } else {
                // Crea ua copia de la lista.
                Ciudad aux = pFirst;
                // Recorre la lista hasta llegar al nodo anterior 
                // al de referencia.
                while (aux.getpNext().getIndex()!= referencia) {
                    aux = aux.getpNext();
                }
                // Guarda el nodo siguiente del nodo a eliminar.
                Ciudad siguiente = aux.getpNext().getpNext();
                // Enlaza el nodo anterior al de eliminar con el 
                // sguiente despues de el.
                aux.setpNext(siguiente);
            }
            // Disminuye el contador de tamaño de la lista.
            tamanio--;
        }
    }

    public boolean esVacio() {
        return tamanio == 0;
    }

    public Ciudad getpFirst() {
        return pFirst;
    }

    public void setpFirst(Ciudad pFirst) {
        this.pFirst = pFirst;
    }

    public Ciudad getpLast() {
        return pLast;
    }

    public void setpLast(Ciudad pLast) {
        this.pLast = pLast;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public boolean esVacia() {
        return pFirst == null;
    }

    public void listar() {
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            Ciudad aux = pFirst;
            // Posicion de los elementos de la lista.
            int i = 0;
            // Recorre la lista hasta el final.
            while (aux != null) {
                // Imprime en pantalla el valor del nodo.
                System.out.print(i + ".[ " + aux.getNombre() + " ]" + "\n");
                // Avanza al siguiente nodo.
                aux = aux.getpNext();
                // Incrementa el contador de la posión.
                i++;
            }
        }
    }
}
