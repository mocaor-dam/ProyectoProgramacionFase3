package aventura.app;

import aventura.domain.Habitacion;

import java.util.Map;

public class AventuraConfig {
    private String descripcion;
    private Map<String, Habitacion> salas;

    public AventuraConfig(String descripcion, Map<String, Habitacion> salas) {
        this.descripcion = descripcion;
        this.salas = salas;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Map<String, Habitacion> getSalas() {
        return salas;
    }

    public void setSalas(Map<String, Habitacion> salas) {
        this.salas = salas;
    }
}
