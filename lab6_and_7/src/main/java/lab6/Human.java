package lab6;

import java.util.Objects;

public class Human implements Comparable<Human> {
    private String lastName;
    private String firstName;
    private String middName;
    private int age;

    public Human(String lastName, String firstName, String middName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middName = middName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddName() {
        return middName;
    }

    public void setMiddName(String middName) {
        this.middName = middName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(lastName, human.lastName) && Objects.equals(firstName, human.firstName) && Objects.equals(middName, human.middName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middName, age);
    }

    @Override
    public String toString() {
        return "Human{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middName='" + middName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Human o) {
        int a = lastName.compareTo(o.getLastName());
        if(a == 0){
            a = firstName.compareTo(o.getFirstName());
            if(a == 0){
                a = lastName.compareTo(o.getLastName());
            }
        }
        return a;
    }
}