package lab6;

import java.util.*;
public class ListDemo {
    //список однофамильцев
    public static List<Human> findSurnameMatches(List<Human> humans, Human targetHuman) {
        List<Human> surnameMatches = new ArrayList<>();
        for (Human human : humans
        ) {
            if (human.getLastName().equals(targetHuman.getLastName())) {
                surnameMatches.add(human);
            }

        }
        return surnameMatches;
    }

    //удалить человека из списка
    public static List<Human> copyWithOutHuman(List<Human> humans, Human targetHuman) {
        List<Human> copy = new ArrayList<>(humans);
        copy.remove(targetHuman);
        return copy;
    }

    //список всех множеств входного списка, которые не пересекаются с заданным множеством
    public static List<Set<Integer>> filterByRetain(List<Set<Integer>> list, Set<Integer> set) {
        if (list.size() == 0 || list == null || set == null || set.size() == 0) {
            throw new IllegalArgumentException("Wrong parameters");
        }
        List<Set<Integer>> listNew = new ArrayList<>();
        for (Set<Integer> item : list) {
            if (Collections.disjoint(item, set)) {
                listNew.add(item);
            }
        }
        return listNew;
    }

    //множество людей из входного списка с максимальным возрастом
    //На входе коллекция объектов класса, производного от E. Имя типа
    //этих элементов не важно (не используется), поэтому этот тип
    //заменен на метасимвол ?.
    //hash function
    public static Set<Human> findTheOldest(List<? extends Human> humans) {
        Set<Human> oldestPeople = new HashSet<>();
        int maxAge = 0;
        for (Human human : humans
        ) {
            if (human.getAge() > maxAge) {
                maxAge = human.getAge();
                oldestPeople.clear();
                oldestPeople.add(human);
            } else if (human.getAge() == maxAge) {
                oldestPeople.add(human);
            }
        }
        return oldestPeople;
    }
    //    7 Имеется набор людей, каждому человеку задан уникальный целочисленный
    //    идентификатор. Напишите метод, который получает на вход отображение (Map)
    //    целочисленных идентификаторов в объекты типа Human и множество целых чисел.
    //    Результат — множество людей, идентификаторы которых содержатся во входном
    //    множестве. крч получить значение по ключу

    public static Set<Human> getHumanId(Map<Integer, Human> map, Set<Integer> ids) {
        if (map == null || map.size() == 0 || ids == null || ids.size() == 0) {
            throw new IllegalArgumentException("Wrong parameters");
        }
        Set<Human> result = new HashSet<>();
        for (int id : ids
        ) {
            if (map.containsKey(id)) {
                result.add(map.get(id));

            }

        }
        return result;

    }

    //8 список age>=18
    public static List<Integer> getIdsByAge(Map<Integer, Human> map) {
        if (map == null || map.size() == 0) {
            throw new IllegalArgumentException("Wrong parameters");
        }
        List<Integer> result = new ArrayList<>();
        final int MAX_AGE = 18;
        for (Map.Entry<Integer, Human> item : map.entrySet()
        ) {
            if (item.getValue().getAge() >= MAX_AGE) {
                result.add(item.getKey());
            }
        }
        return result;
    }

    //9 Отображение сопоставляет идентификатору возраст человека
    public static Map<Integer, Integer> getIdToAgeMap(Map<Integer, Human> map) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, Human> item : map.entrySet()
        ) {
            result.put(item.getKey(), item.getValue().getAge());

        }
        return result;
    }

    // 10 отображение, которое целому числу сопоставляет список всех людей данного возраста из входного множества
    public static Map<Integer, List<Human>> getAgeToHumanMap(Set<Human> set) {
        if (set == null || set.size() == 0) {
            throw new IllegalArgumentException("Wrong parameters");
        }
        Map<Integer, List<Human>> map = new HashMap<>();
        Set<Human> sortSet = new TreeSet<>(set);
        for (Human item : sortSet
        ) {
            if (map.containsKey(item.getAge())) {
                map.get(item.getAge()).add(item);
            } else {
                List<Human> list = new ArrayList<>();
                list.add(item);
                map.put(item.getAge(), list);
            }

        }
        return map;
    }

}


