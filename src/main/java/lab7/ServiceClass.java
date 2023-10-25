package lab7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;


public class ServiceClass {
    public static void serialiseHouse(House house, OutputStream os) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(os)){
            oos.writeObject(house);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public static House deSerialiseHouse(InputStream is) throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(is)){
            House house = (House) ois.readObject();
            return house;
        } catch (IOException | ClassNotFoundException e) {
            throw e;
        }
    }
    //Методы сериализации / десериализации объектов типа House в строки
    public static String toJsonHouse(House house) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(house);
    }

    public static House toHouseFromJson(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, House.class);
    }
}
