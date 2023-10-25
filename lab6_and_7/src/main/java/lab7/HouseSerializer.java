package lab7;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class HouseSerializer extends StdSerializer<House> {
    public HouseSerializer(Class<House> t) {
        super(t);
    }

    public HouseSerializer() {
        this(null);
    }


    @Override
    public void serialize(House house, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("CNumber", house.getCNumber());
        jsonGenerator.writeStringField("adress", house.getAddress());
        jsonGenerator.writeFieldName("TheOldest");
        jsonGenerator.writeStartObject();
        Person senior = house.getTheOldest();
        jsonGenerator.writeStringField("fullName", senior.getFirstName() + ' '
                + senior.getLastName() + ' ' + senior.getPatronymic());
        jsonGenerator.writeStringField("date", senior.getDate());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeFieldName("flats");
        jsonGenerator.writeStartArray();
        for (Flat flat : house.getFlats()) {
            FlatSerializer.serializeFlat(flat, jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.close();
    }

}
