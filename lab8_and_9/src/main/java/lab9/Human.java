package lab9;
import java.util.Objects;

public class Human {
    private String name;
    private String surName;
    private String middName;
    private int age;
    private Gender gender;

    public Human(String name, String surName, String middName, int age, Gender gender) {
        this.name = name;
        this.surName = surName;
        this.middName = middName;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && name.equals(human.name) && surName.equals(human.surName) && middName.equals(human.middName) && gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, middName, age, gender);
    }
}
