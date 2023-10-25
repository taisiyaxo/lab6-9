package lab7;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Objects;
@JsonSerialize(using = PersonSerializer.class)
@JsonDeserialize(using = PersonDeserializer.class)
public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String date;

    Person(){}

    public Person(String firstName, String lastName, String patronymic, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.date = date;
    }
    public Person(Person person) {
        this(person.getFirstName(), person.getLastName(), person.getPatronymic(), person.getDate());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(patronymic, person.patronymic) && Objects.equals(date, person.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic, date);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", date=" + date +
                '}';
    }


}
