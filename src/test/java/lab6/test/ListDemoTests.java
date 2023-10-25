package lab6.test;

import lab6.Human;
import lab6.ListDemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListDemoTests {
    //2 Список однофамильцев заданного человека среди людей из входного списка
    @Test
    public void findSurnameMatchesTest() {
        Human human1 = new Human("Ivanova", "Alina", "Alexandrovna", 19);
        Human human2 = new Human("Seedorowa", "Kate", "Andreevna", 19);
        Human human3 = new Human("Ivanova", "Stasy", "Alekseevna", 20);
        ArrayList<Human> people = new ArrayList<>();
        Collections.addAll(people, human1, human2, human3);
        ArrayList<Human> expected = new ArrayList<>();
        Collections.addAll(expected, human1, human3);
        Human human = new Human("Ivanova", "Nova", "Alexandrovna", 19);
        Assertions.assertEquals(ListDemo.findSurnameMatches(people, human), expected);
    }

    //3 Копия входного списка, не содержащая выделенного человека
    @Test
    public void copyWithOutHumanTest() {
        Human human1 = new Human("Ivanova", "Alina", "Alexandrovna", 19);
        Human human2 = new Human("Seedorowa", "Kate", "Andreevna", 19);
        Human human3 = new Human("Ivanova", "Stasy", "Alekseevna", 20);
        ArrayList<Human> people = new ArrayList<>();
        Collections.addAll(people, human1, human2, human3);
        ArrayList<Human> expected = new ArrayList<>();
        Collections.addAll(expected, human2, human3);
        Assertions.assertEquals(ListDemo.copyWithOutHuman(people,human1),expected);
    }

    //4 Список всех множеств входного списка, которые не пересекаются с заданным множеством
    @Test
    public void findDisjoinSetTest() {
        Human human1 = new Human("Ivanova", "Alina", "Alexandrovna", 25);
        Human human2 = new Human("Seedorowa", "Kate", "Andreevna", 21);
        Human human3 = new Human("Ivanova", "Stasy", "Alekseevna", 20);
        Human human4 = new Human("Petrova", "Olga", "Olegovna", 19);
        Human human5 = new Human("Cup", "Chashka", "Lozhka", 18);
        Human human6 = new Human("Plov", "Rice", "Sushivna", 22);
        HashSet<Integer> peopleSet = new HashSet<>();
        ArrayList<Set<Integer>> people = new ArrayList<>();
        //положили всех людей(21,20,19,18,22) исходное множество
        Collections.addAll(peopleSet, human1.getAge(), human2.getAge(), human3.getAge(), human4.getAge(), human5.getAge(), human6.getAge());
        people.add(peopleSet);
        HashSet<Integer> people2 = new HashSet<>();
        HashSet<Integer> people3 = new HashSet<>();
        Collections.addAll(people2, human4.getAge(), human5.getAge(), human6.getAge(), human3.getAge());
        Collections.addAll(people3, human1.getAge(), human2.getAge());
        people.add(people2); //20 18 19 22
        people.add(people3); //25 21
        ArrayList<Set<Integer>> expected = new ArrayList<>();
        Collections.addAll(expected, people3);
        Assertions.assertEquals(ListDemo.filterByRetain(people, people2), expected);
    }

        @Test
        public void findTheOldestTest() {
            Human human1 = new Human("Ivanova", "Alina", "Alexandrovna", 19);
            Human human2 = new Human("Seedorowa", "Kate", "Andreevna", 19);
            Human human3 = new Human("Ivanova", "Stasy", "Alekseevna", 20);

            List<Human> people = Arrays.asList(human1, human2, human3);
            Set<Human> expectedOldest = new HashSet<>();
            expectedOldest.add(human3);

            Set<Human> oldestPeople = ListDemo.findTheOldest(people);

            assertEquals(expectedOldest, oldestPeople);
        }


    //5 Множество людей из входного списка с максимальным возрастом
    @Test
    public void personMaxAgeTest() {
        Human human1 = new Human("Alina", "Akimova", "Alexandrovna", 19);
        Human human2 = new Human("Kate", "Pinchyck", "Andreevna", 21);
        Human human3 = new Human("Kate", "Akimova", "Alekseevna", 20);
        Human human4 = new Human("Anastasia", "Sobol", "Alekseevna", 21);
        ArrayList<Integer> people = new ArrayList<>();
        Collections.addAll(people, human1.getAge(), human2.getAge(), human3.getAge(), human4.getAge());
        //assertEquals(personMaxAge(people), );
    }

    //7 Множество людей, идентификаторы которых содержатся во входном множестве
    @Test
    public void filterByIdentifierTest() {
        Human human1 = new Human("Alina", "Akimova", "Alexandrovna", 19);
        Human human2 = new Human("Kate", "Pinchyck", "Andreevna", 21);
        Human human3 = new Human("Kate", "Akimova", "Alekseevna", 20);
        Human human4 = new Human("Anastasia", "Sobol", "Alekseevna", 19);
        Human human5 = new Human("Kate", "Pinchyck", "Andreevna", 18);
        Human human6 = new Human("Daria", "Kniazeva", "Alekseevna", 22);
        HashSet<Integer> peopleSet = new HashSet<>();
        Collections.addAll(peopleSet, human1.getAge(), human2.getAge(), human3.getAge(), human4.getAge(), human5.getAge(), human6.getAge());
        HashMap<Integer, Human> peopleMap = new HashMap<>();
        peopleMap.put(human1.getAge(), human1);
        peopleMap.put(human2.getAge(), human2);
        peopleMap.put(human3.getAge(), human3);
        HashSet<Human> expected = new HashSet<>();
        Collections.addAll(expected, human1, human2, human3);
        Assertions.assertEquals(ListDemo.getHumanId(peopleMap, peopleSet), expected);
    }

    //8 Список идентификаторов людей, чей возраст не менее 18 лет
    @Test
    public void listOfIdentifierTest() {
        Human human1 = new Human("Alina", "Akimova", "Alexandrovna", 19);
        Human human2 = new Human("Kate", "Pinchyck", "Andreevna", 10);
        Human human3 = new Human("Kate", "Akimova", "Alekseevna", 20);
        Human human4 = new Human("Anastasia", "Sobol", "Alekseevna", 17);
        HashMap<Integer, Human> peopleMap = new HashMap<>();
        peopleMap.put(1, human1);
        peopleMap.put(2, human2);
        peopleMap.put(3, human3);
        peopleMap.put(4, human4);
        ArrayList<Integer> peopleAge = new ArrayList<>();
        Collections.addAll(peopleAge, 1, 3);
        System.out.println(ListDemo.getIdsByAge(peopleMap));
        Assertions.assertEquals(ListDemo.getIdsByAge(peopleMap), peopleAge);
    }

    //9 Отображение сопоставляет идентификатору возраст человека
    @Test
    public void makeMapByTheAgeTest() {
        Human human1 = new Human("Alina", "Akimova", "Alexandrovna", 19);
        Human human2 = new Human("Kate", "Pinchyck", "Andreevna", 10);
        Human human3 = new Human("Kate", "Akimova", "Alekseevna", 20);
        Human human4 = new Human("Anastasia", "Sobol", "Alekseevna", 17);
        HashMap<Integer, Human> peopleMap = new HashMap<>();
        peopleMap.put(1, human1);
        peopleMap.put(2, human2);
        peopleMap.put(3, human3);
        peopleMap.put(4, human4);

        HashMap<Integer, Integer> peopleMapExpected = new HashMap<>();
        peopleMapExpected.put(1, human1.getAge());
        peopleMapExpected.put(2, human2.getAge());
        peopleMapExpected.put(3, human3.getAge());
        peopleMapExpected.put(4, human4.getAge());

        Assertions.assertEquals(ListDemo.getIdToAgeMap(peopleMap), peopleMapExpected);
    }

    //10 отображение, которое целому числу сопоставляет список всех людей данного возраста из входного множества
    @Test
    public void makeAgeToListOfHumanTest() {
        Human human1 = new Human("Alina", "Akimova", "Alexandrovna", 20);
        Human human2 = new Human("Kate", "Pinchyck", "Andreevna", 10);
        Human human3 = new Human("Kate", "Akimova", "Alekseevna", 20);
        Human human4 = new Human("Anastasia", "Sobol", "Alekseevna", 17);
        HashSet<Human> peopleSet = new HashSet<>();
        Collections.addAll(peopleSet, human1, human2, human3, human4);
        List<Human> people1 = new ArrayList<>();
        List<Human> people2 = new ArrayList<>();
        List<Human> people3 = new ArrayList<>();
        Collections.addAll(people1, human1, human3);
        people2.add(human2);
        people3.add(human4);
        Map<Integer, List<Human>> expected = new HashMap<>();
        expected.put(20, people1);
        expected.put(10, people2);
        expected.put(17, people3);
        Assertions.assertEquals(expected, ListDemo.getAgeToHumanMap(peopleSet));
    }
}