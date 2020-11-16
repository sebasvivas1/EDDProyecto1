package edd_proyecto_1_Fernandez_vergel_vivas;

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
    
    public void agregarAlInicio(int index, String nombre){
        Ciudad nuevo = new Ciudad(nombre, index);
        if (esVacia()) {
            pFirst = nuevo;
        } else{
            nuevo.setpNext(pFirst);
            pFirst = nuevo;
        }
        tamanio++;
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
    
    public void insertarPorPosicion(int posicion, int index, String nombre){
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y <= que el numero de elementos del la lista.
        if(posicion>=0 && posicion<=tamanio){
            Ciudad nuevo = new Ciudad(nombre,index);
            nuevo.setIndex(index);
            // Consulta si el nuevo nodo a ingresar va al Pfirst de la lista.
            if(posicion == 0){
                // Inserta el nuevo nodo al Pfirst de la lista.
                nuevo.setpNext(pFirst);
                pFirst = nuevo;
            }
            else{
                // Si el nodo a inserta va al final de la lista.
                if(posicion == tamanio){
                    Ciudad aux = pFirst;
                    // Recorre la lista hasta llegar al ultimo nodo.
                    while(aux.getpNext()!= null){
                        aux = aux.getpNext();
                    }
                    // Inserta el nuevo nodo despues de del ultimo.
                    aux.setpNext(nuevo);              
                }
                else{
                    // Si el nodo a insertar va en el medio de la lista.
                    Ciudad aux = pFirst;
                    // Recorre la lista hasta llegar al nodo anterior
                    // a la posicion en la cual se insertara el nuevo nodo.
                    for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getpNext();
                    }
                    // Guarda el nodo siguiente al nodo en la posición
                    // en la cual va a insertar el nevo nodo.
                    Ciudad siguiente = aux.getpNext();
                    // Inserta el nuevo nodo en la posición indicada.
                    aux.setpNext(nuevo);
                    // Une el nuevo nodo con el resto de la lista.
                    nuevo.setpNext(siguiente);
                }
            }
            // Incrementa el contador de tamaño de la lista.
            tamanio++;
        }
    }
}
