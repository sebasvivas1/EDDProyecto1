
package edd_proyecto_1_jecklin_vergel_vivas;
/**
 *
 * @author Edward Vergel
 */
public class Ciudad {
    private Ciudad pNext; 
    private String nombre;
    //private String id; ----> id = index (NO ES NECESARIO ID YA QUE EL INDEX ES LO MISMO PERO INT)
    private int index; //Para poder eliminar por endice en la lista
  
    public Ciudad(String nombre , int index){
        this.pNext = null;
        this.nombre = nombre;
        this.index = index;
    }

    public Ciudad getpNext() {
        return pNext;
    }

    public void setpNext(Ciudad pNext) {
        this.pNext = pNext;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
}
