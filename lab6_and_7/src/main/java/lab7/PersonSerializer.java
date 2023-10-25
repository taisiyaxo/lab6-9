package lab7;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class PersonSerializer extends StdSerializer<Person> {
    public PersonSerializer(Class<Person> p){
        super(p);
    }

    public PersonSerializer() {
        this(null);
    }

    public static void serializePerson(Person person, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("fullName", person.getFirstName() + " " + person.getLastName() + " " + person.getPatronymic());
        jsonGenerator.writeStringField("date", person.getDate());
        jsonGenerator.writeEndObject();
    }

    @Override
    public void serialize(Person person, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serializePerson(person, jsonGenerator, serializerProvider);
        jsonGenerator.close();
    }

}
