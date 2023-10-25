package lab6;

public class Student extends Human{
    private String faculty;

    public Student(String lastName, String firstName, String middName, int age, String faculty) {
        super(lastName, firstName, middName, age);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
