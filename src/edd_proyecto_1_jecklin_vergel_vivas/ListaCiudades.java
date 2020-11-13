
package edd_proyecto_1_jecklin_vergel_vivas;

import javax.swing.JOptionPane;

public class ListaCiudades {
    private Ciudad pFirst;
    private Ciudad pLast;
    private int tamanio;
    
    public ListaCiudades(){
        this.pFirst = null;
        this.pLast = null;
        this.tamanio = 0;
    }
    
    public void insertarAlFinal(String nombre){
        Ciudad pAux;
        int index = tamanio;
        if (esVacio()){
            Ciudad pNew = new Ciudad (nombre, index);
            pFirst = pLast = pNew;
            tamanio ++;
        }else {
            Ciudad pNew = new Ciudad (nombre, index);
            pLast.setpNext(pNew);
            pLast = pNew;
            tamanio++;
        }
    }
    
    public Ciudad obtenerCiudadIndex(int index){
        Ciudad pAux = pFirst;
        if (!esVacio()){
            if(index <= 19 || index >= 0){
                while(pAux.getIndex() != index){
                    pAux = pAux.getpNext();
                }
                return pAux;
            }
            JOptionPane.showMessageDialog(null, "ERROR: INDICE INVALIDO");
        }
        return null;
    }
    
//    public void eliminarIndice(int index){
//        Ciudad pAnt = pFirst;
//        Ciudad pAct = pFirst.getpNext();
//        Ciudad pSig = pAct.getpNext();
//        if (!esVacio()){
//            while(pSig != pLast){
//                if (pAux.getIndex() == index){
//                    
//                }
//                pAux = pAux.getpNext();
//                pSig = pSig.getpNext();
//            }
//        }else {
//            JOptionPane.showMessageDialog(null, "ERROR: NO HAY CIUDADES INSERTADAS");
//        }
//    }
    
    
    
    public boolean esVacio(){
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
    
    
}
