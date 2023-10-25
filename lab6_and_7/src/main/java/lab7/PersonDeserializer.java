package lab7;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class PersonDeserializer extends StdDeserializer<Person> {
    public PersonDeserializer(Class<Person> p){
        super(p);
    }

    public PersonDeserializer() {
        this(null);
    }
    public static Person deserializePerson(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String firstName = null;
        String lastName = null;
        String patronymic = null;
        String date = null;
        while (jsonParser.nextToken() != JsonToken.END_OBJECT){
            String fieldName =  jsonParser.getCurrentName();
            if("fullName".equals(fieldName)){
                jsonParser.nextToken();
                String[] fName = jsonParser.getText().split("\\s+");
                firstName = fName[0];
                lastName = fName[1];
                patronymic = fName[2];
            }
            if("date".equals(fieldName)){
                jsonParser.nextToken();
                String birth = jsonParser.getText();
                date = birth;
            }
        }
        return new Person(firstName, lastName, patronymic, date);
    }
    @Override
    public Person deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return deserializePerson(jsonParser, deserializationContext);
    }
}
