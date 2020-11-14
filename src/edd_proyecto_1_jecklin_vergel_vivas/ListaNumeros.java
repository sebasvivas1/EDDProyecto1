
package edd_proyecto_1_jecklin_vergel_vivas;

public class ListaNumeros {

    private Numero pFirst;
    private Numero pLast;
    private int tamanio;

    public ListaNumeros() {
        this.pFirst = null;
        this.pLast = null;
        this.tamanio = 0;
    }

    public boolean esVacio() {
        if (tamanio == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setpLast(Numero pLast) {
        this.pLast = pLast;
    }

    public void insertarAlFinal(int n) {
        Numero pAux;
        int index = tamanio;
        if (esVacio()) {
            Numero pNew = new Numero(n, index);
            setpFirst(pLast = pNew);
            tamanio++;
        } else {
            Numero pNew = new Numero(n, index);
            getpLast().setpNext(pNew);
            pLast = pNew;
            tamanio++;
        }
    }

    public int getTamanio() {
        return tamanio;
    }

    public boolean existeNumero(int numero, ListaNumeros lista) {
        Numero pAux = getpFirst();
        if (!lista.esVacio()) {
            while (pAux.getNumero() != numero) {
                if (pAux == getpLast()) {
                    return false;
                }
                pAux = pAux.pNext;
            }
        }

        return true;
    }

    /**
     * @return the pFirst
     */
    public Numero getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Numero pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Numero getpLast() {
        return pLast;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

}
