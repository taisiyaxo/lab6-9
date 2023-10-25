package lab7.test;

import lab7.Flat;
import lab7.House;
import lab7.Person;
import lab7.ServiceClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceClassTest {

    private static House house;
    @BeforeClass
    public static void setUp(){
        Person person = new Person("Victoria", "Aist", "Gennadievna", "23.9.1999");
        List<Person> personList=new ArrayList<>();
        personList.add(person);
        Flat flat=new Flat(3, 66,personList);
        List<Flat> flatList=new ArrayList<>();
        flatList.add(flat);
        house=new House("111111111", "Petra Ilicheva",person, flatList);
    }

    @Test
    public void serialiseAndDeSerialise() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ServiceClass.serialiseHouse(house, baos);
        House expected=ServiceClass.deSerialiseHouse(new ByteArrayInputStream(baos.toByteArray()));
        assertEquals(expected, house);
    }

    @Test
    public void testToJsonHouse() throws IOException {
        String expected = "{\"CNumber\":\"111111111\",\"adress\":\"Petra Ilicheva\",\"TheOldest\":{\"fullName\":\"Victoria Aist Gennadievna\",\"date\":\"23.9.1999\"}," +
                "\"flats\":[{\"number\":3,\"area\":66,\"owners\":[{\"fullName\":\"Victoria Aist Gennadievna\",\"date\":\"23.9.1999\"}]}]}";
        assertEquals(expected, ServiceClass.toJsonHouse(house));
    }

    @Test
    public void testToHouseFromJson() throws IOException {
        String expected = "{\"CNumber\":\"111111111\",\"adress\":\"Petra Ilicheva\",\"TheOldest\":{\"fullName\":\"Victoria Aist Gennadievna\",\"date\":\"23.9.1999\"}," +
                "\"flats\":[{\"number\":3,\"area\":66,\"owners\":[{\"fullName\":\"Aist Victoria Gennadievna\",\"date\":\"23.9.1999\"}]}]}";
        House house1 = ServiceClass.toHouseFromJson(expected);
        assertEquals(house, ServiceClass.toHouseFromJson(ServiceClass.toJsonHouse(house)));
    }

}

