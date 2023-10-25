package lab9;


import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaDemo {
    //1 получить длину строки
    public static final Function<String, Integer> getStringSize = String::length;
    //2 полчить первый элемент строки если он не нулл
    public static final Function<String, Character> getFirstChar = string -> {
        if (string != null) {
            return string.charAt(0);
        }
        throw new IllegalArgumentException("String is null");
    };
    //3 проверить не содердит ли строка пробелов
    public static final Predicate<String> checkSpace = string -> !string.isEmpty() && !string.contains(" ");
    //4 слова разделены запятой кол-во слов в строке
    public static final Function<String, Integer> countWord = string -> string.split(",").length;
    //5 получить возраст человека
    public static final Function<Human, Integer> getAge = Human::getAge;
    //6 по двум людям проверить одинаковая ли фамилия
    public static final BiPredicate<Human, Human> equalsSurName = (human, human2) -> human.getSurName().equals(human2.getSurName());
    //7 получить ФИО
    public static final Function<Human, String> getFullName = human -> human.getSurName() + " " + human.getName() + " " + human.getMiddName();
    //8 +1 год создав нового человека
    public static final UnaryOperator<Human> makePeopleOlder = human -> new Human(human.getName(), human.getSurName(), human.getMiddName(), human.getAge() + 1, human.getGender());
    //9 проверить, что три человека младше заданного возраста
    public static final LambdaDemoInter checkYounger = ((human1, human2, human3, maxAge) -> human1.getAge() < maxAge && human2.getAge() < maxAge && human3.getAge() < maxAge);

}