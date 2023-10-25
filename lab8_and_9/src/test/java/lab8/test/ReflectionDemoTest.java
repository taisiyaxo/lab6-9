package lab8.test;

import lab6.Human;
import lab6.Student;
import lab8.ReflectionDemo;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReflectionDemoTest {

    @Test
    public void testCountOfHuman(){
        List<Object> list = new ArrayList<>();
        Human human1 = new Human("Тиньков", "Олег", "Олегович",19);
        Human human2 = new Human("Тинькофф", "Ольга", "Олеговна",20);
        Human human3 = new Human("Тиньков", "Алек", "Олегович",19);
        Student student1 = new Student("Иванов","Иван","Иванович",19,"FCTK");
        Student student2 = new Student("Иванова","Ива","Ивановна",19,"FCTK");
        list.add(human1);
        list.add(human2);
        list.add(human3);
        list.add(student1);
        list.add(student2);
        assertEquals(5, ReflectionDemo.countHumanAndSubtypes(list));
    }

    @Test
    public void testListOfOpenMethods(){
        Human human1 = new Human("Тиньков", "Олег", "Олегович",19);
        List<String> list = new ArrayList<>(new TreeSet<>(ReflectionDemo.getDeclaredPublicMethodNames(human1)
                .stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList())));
        String[] strings = {"compareTo", "equals", "getAge", "getFirstName", "getLastName", "getMiddName", "hashCode", "setAge", "setFirstName", "setLastName", "setMiddName", "toString" };
        List<String> expected = new ArrayList<>(Arrays.asList(strings));
        assertEquals(expected, list);
    }

    @Test
    public void testGetSuperClass(){
        Student student2 = new Student("Иванова","Ива","Ивановна",19,"FCTK");
        List<String> actual = ReflectionDemo.getSuperclassNames(student2);
        List<String> expected = new ArrayList<>(Arrays.asList("lab6.Student","lab6.Human", "java.lang.Object"));
        assertEquals(expected, actual);
    }

}

