package lab7;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HouseDeserializer extends StdDeserializer<House> {

    public HouseDeserializer(Class<House> t) {
        super(t);
    }

    public HouseDeserializer() {
        this(null);
    }

    @Override
    public House deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Person theOldest = null;
        String cadastralId = null;
        String adress = null;
        List<Flat> flats = new ArrayList<>();
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String houseField = jsonParser.getCurrentName();
            if ("CNumber".equals(houseField)) {
                jsonParser.nextToken();
                cadastralId = jsonParser.getText();
            }
            if ("adress".equals(houseField)) {
                jsonParser.nextToken();
                adress = jsonParser.getText();
            }
            if ("TheOldest".equals(houseField)) {
                jsonParser.nextToken();
                theOldest = PersonDeserializer.deserializePerson(jsonParser, deserializationContext);
            }
            if ("flats".equals(houseField)) {
                jsonParser.nextToken();
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    flats.add(FlatDeserializer.deserializeFlat(jsonParser,deserializationContext));
                }
            }
        }
        jsonParser.close();
        return new House(cadastralId, adress, theOldest, flats);
    }
}
