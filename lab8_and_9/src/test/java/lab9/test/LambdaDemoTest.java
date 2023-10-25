package lab9.test;
import lab9.Gender;
import lab9.Human;

import lab9.LambdaDemo;
import lab9.LambdaRunner;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class LambdaDemoTest {


    @Test
    public void getStringSizeTest() {
        Human human = new Human("Victoria", "Aist", "Gennadievna", 54, Gender.FEMALE);
        assertEquals(4, LambdaRunner.getFunctionRes(LambdaDemo.getStringSize, human.getSurName()));
    }

    @Test
    public void getFirstCharTest() {
        Human human = new Human("Victoria", "Aist", "Gennadievna", 54, Gender.FEMALE);
        assertEquals('A', LambdaRunner.getFunctionRes(LambdaDemo.getFirstChar, human.getSurName()));
    }

    @Test
    public void checkSpaceTest() {
        Human human = new Human("Victoria", "Aist", "Gennadievna", 54, Gender.FEMALE);
        assertTrue(LambdaRunner.getPredicateRes(LambdaDemo.checkSpace, human.getSurName()));
        assertFalse(LambdaRunner.getPredicateRes(LambdaDemo.checkSpace, " "));
    }

    @Test
    public void countWordTest() {
        assertEquals(5, LambdaRunner.getFunctionRes(LambdaDemo.countWord, "a, b, c, d, e"));
        assertEquals(0, LambdaRunner.getFunctionRes(LambdaDemo.countWord, ","));
        assertEquals(1, LambdaRunner.getFunctionRes(LambdaDemo.countWord, "a,"));
    }

    @Test
    public void getAgeTest() {
        Human human = new Human("Victoria", "Aist", "Gennadievna", 54, Gender.FEMALE);
        assertEquals(54, LambdaRunner.getFunctionRes(LambdaDemo.getAge, human));
    }

    @Test
    public void equalsSurnameTest() {
        Human human = new Human("Victoria", "Aist", "Gennadievna", 54, Gender.FEMALE);
        Human human2 = new Human("Alina", "Aist", "Aleksandrovna", 19, Gender.FEMALE);
        Human human3 = new Human("Alina", "Orlova", "Aleksandrovna", 19, Gender.FEMALE);
        assertTrue(LambdaRunner.getBiPredicateRes(LambdaDemo.equalsSurName, human, human2));
        assertFalse(LambdaRunner.getBiPredicateRes(LambdaDemo.equalsSurName, human, human3));
    }

    @Test
    public void getFullNameTest() {
        Human human = new Human("Victoria", "Aist", "Gennadievna", 54, Gender.FEMALE);
        assertEquals("Aist Victoria Gennadievna", LambdaRunner.getFunctionRes(LambdaDemo.getFullName, human));
    }

    @Test
    public void makePeopleOlderTest() {
        Human human = new Human("Victoria", "Aist", "Gennadievna", 54, Gender.FEMALE);
        Human older = new Human("Victoria", "Aist", "Gennadievna", 55, Gender.FEMALE);
        assertEquals(older, LambdaRunner.getFunctionRes(LambdaDemo.makePeopleOlder, human));
    }

    @Test
    public void checkYoungerTest() {
        Human human = new Human("Victoria", "Aist", "Gennadievna", 54, Gender.FEMALE);
        Human human2 = new Human("Alina", "Aist", "Aleksandrovna", 19, Gender.FEMALE);
        Human older = new Human("Victoria", "Aist", "Gennadievna", 56, Gender.FEMALE);
        Human human3 = new Human("Alina", "Orlova", "Aleksandrovna", 19, Gender.FEMALE);
        assertTrue(LambdaRunner.getLambdaDemoInterRes(LambdaDemo.checkYounger, human, human2, human3, 55));
        assertFalse(LambdaRunner.getLambdaDemoInterRes(LambdaDemo.checkYounger, human, human2, older, 55));
    }

}
