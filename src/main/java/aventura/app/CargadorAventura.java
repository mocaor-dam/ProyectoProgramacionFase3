package aventura.app;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class CargadorAventura {
    private Gson gson;
    private Path directorioBase;
    private Path archivoAventura;

    public void cargarConfiguracion(){
        Properties config = new Properties();
        Path rutaConfig = Path.of("config.properties");


        //Cargamos el archivo
        try (BufferedReader reader = Files.newBufferedReader(rutaConfig)){
            config.load(reader);
            //Leemos los Strings usando las "llaves" del archivo properties
            String dir = config.getProperty("juego.directorio.base");
            String archivo = config.getProperty("juego.archivo.base");


            //Convertimos los Strings a objetos Path
            this.directorioBase = Path.of(dir);
            //Usamos resolve para unir la carpeta con el archivo
            this.archivoAventura = this.directorioBase.resolve(archivo);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }


}
