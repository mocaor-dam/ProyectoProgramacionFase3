package aventura.domain;

import com.google.gson.*;

import java.lang.reflect.Type;


public class ObjetoAdapter implements JsonSerializer<Objeto>, JsonDeserializer<Objeto> {


    @Override
    public JsonElement serialize(Objeto src, Type typeOfSrc, JsonSerializationContext context) {
        // Convertimos el objeto a un JsonObject estándar
        JsonObject jsonObject = context.serialize(src).getAsJsonObject();


        // Inyectamos la propiedad "tipo" basada en el nombre de la clase
        jsonObject.addProperty("tipo", src.getClass().getSimpleName().toLowerCase());


        return jsonObject;
    }


    @Override
    public Objeto deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();


        // Extraemos el tipo que inyectamos en la serialización
        JsonElement tipoElement = jsonObject.get("tipo");
        if (tipoElement == null) {
            throw new JsonParseException("Falta el campo 'tipo' para deserializar Objeto");
        }


        String tipo = tipoElement.getAsString();


        // Usamos el contexto para asignar la clase hija que corresponda en cada caso
        switch (tipo) {
            case "Llave":
                return context.deserialize(jsonObject, Llave.class);
            case "Mueble":
                return context.deserialize(jsonObject, Mueble.class);
            case "Contenedor":
                return context.deserialize(jsonObject, Contenedor.class);
            case "MangoRotoLlave":
                return context.deserialize(jsonObject, MangoRotoLlave.class);
            case "PaloRotoLlave":
                return context.deserialize(jsonObject, PaloRotoLlave.class);
            case "Nota":
                return context.deserialize(jsonObject, Nota.class);
            case "Item":
                return context.deserialize(jsonObject, Item.class);
            default:
                throw new JsonParseException("Tipo de objeto desconocido: " + tipo);
        }
    }
}