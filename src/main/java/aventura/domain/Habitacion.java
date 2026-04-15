package aventura.domain;

import aventura.exceptions.AventuraException;
import java.util.LinkedList;
import java.util.List;

public class Habitacion {
    private String descripcion;
    private List<Objeto> objetos; // Array de objetos reales, no Strings

    /**
     * Constructor de la clase Habitacion.
     * @param desc Descripción de la habitación.
     */
    public Habitacion(String desc) {
        this.descripcion = desc;
        objetos=new LinkedList<>();
    }

    /**
     * Agrega un objeto a la habitación.
     * @param obj Objeto a agregar.
     * @throws AventuraException Si no se puede agregar el objeto.
     */
    public void agregarObjeto(Objeto obj) throws AventuraException {
        // Lógica para añadir en el primer hueco null
       objetos.add(obj);
    }

    /**
     * Elimina un objeto de la habitación.
     * @param obj Objeto a eliminar.
     * @return true si se eliminó el objeto, false si no se encontró.
     */
    public boolean eliminarObjeto(Objeto obj) {
    return objetos.remove(obj);
    }

    /**
     * Muestra la descripción de la habitación y los objetos presentes en ella.
     * @return Descripción de la habitación y lista de objetos.
     */
    public String mirar() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.descripcion).append("\n");
        for(Objeto obj : objetos) {
            if(obj != null) {
                sb.append(" - ").append(obj.getNombre()).append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * Obtiene los objetos presentes en la habitación.
     * @return Array de objetos en la habitación.
     */
    public List<Objeto> getObjetos() {
        return objetos;
    }

    /**
     * Busca un objeto por su nombre en la habitación.
     * @param nombre Nombre del objeto a buscar.
     * @return El objeto si se encuentra, null en caso contrario.
     */
    public Objeto buscar(String nombre) {
        for (Objeto obj : objetos) {
            if (obj != null && obj.getNombre().equalsIgnoreCase(nombre)) {
                return obj;
            }
        }
        return null;
    }

    public String getDescripcion() {
        return descripcion;
    }


}
