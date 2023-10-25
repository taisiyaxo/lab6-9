package lab7;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class FlatSerializer extends StdSerializer<Flat> {

    public FlatSerializer(Class<Flat> t) {
        super(t);
    }

    public FlatSerializer() {
        this(null);
    }

    public static void serializeFlat(Flat flat, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("number", flat.getFlatNumber());
        jsonGenerator.writeNumberField("area", flat.getSquare());
        jsonGenerator.writeFieldName("owners");
        jsonGenerator.writeStartArray();
        for (Person i : flat.getPeople()) {
            PersonSerializer.serializePerson(i, jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }

    @Override
    public void serialize(Flat flat, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serializeFlat(flat, jsonGenerator, serializerProvider);
    }
}
