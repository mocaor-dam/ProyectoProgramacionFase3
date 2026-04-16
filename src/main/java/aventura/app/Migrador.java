package aventura.app;

import aventura.domain.Habitacion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Migrador {




    public static void migrador(String descripcion, Habitacion[] arrayHabitaciones) throws IOException {

        Map<String, Habitacion> salas = new HashMap<>();

        for (Habitacion h : arrayHabitaciones){
            if (h != null){
                salas.put(h.getNombre(), h);
            }
        }

        AventuraConfig aventuraConfig = new AventuraConfig(descripcion, salas);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Convertimos el objeto a una cadena de texto de JSON
        String json = gson.toJson(aventuraConfig);

        Path ruta = Path.of("src/main/resources/aventura.json");

        Files.writeString(ruta, json);


    }

}
