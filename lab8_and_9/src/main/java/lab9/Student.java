package lab9;

public class Student extends Human {
    private String faculty;
    private String specialty;

    public Student(String name, String surName, String middName, int age, Gender gender, String faculty, String specialty) {
        super(name, surName, middName, age, gender);
        this.faculty = faculty;
        this.specialty = specialty;
    }
}
