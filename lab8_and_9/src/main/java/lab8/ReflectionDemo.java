package lab8;


import lab6.Human;
import lab6.Student;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class    ReflectionDemo {
    // Метод для подсчета объектов типа Human и его подтипов
    public static int countHumanAndSubtypes(List<Object> objects) {
        int count = 0;
        if (objects == null || objects.isEmpty()){
            throw new IllegalArgumentException("List is Empty");
        }
        for (Object obj : objects) {
            if (isInstanceOfHuman(obj)) {
                count++;
            }
        }
        return count;
    }

    // Вспомогательный метод для проверки, является ли объект экземпляром Human или его подкласса
    private static boolean isInstanceOfHuman(Object obj) {
        return Human.class.isAssignableFrom(obj.getClass());
    }
    //можно использовать и instanceOf, для этого надо знать класс на этапе компиляции, это хуман так что без особой разницы

    // Метод для получения списка имен открытых методов объекта
    //можно и через гетметодс но тогда вообще всё вернется
    public static List<String> getDeclaredPublicMethodNames(Object obj) {
        List<String> methodNames = new ArrayList<>();
        Class<?> objClass = obj.getClass();
        Method[] declaredMethods = objClass.getDeclaredMethods();

        for (Method method : declaredMethods) {
            if (Modifier.isPublic(method.getModifiers())) {
                methodNames.add(method.getName());
            }
        }

        return methodNames;
    }
    // Метод для получения списка имен всех суперклассов до Object
    public static List<String> getSuperclassNames(Object obj) {
        List<String> superclassNames = new ArrayList<>();
        Class<?> objClass = obj.getClass();

        while (objClass != null) {
            superclassNames.add(objClass.getName());
            objClass = objClass.getSuperclass();
        }

        return superclassNames;
    }


}

