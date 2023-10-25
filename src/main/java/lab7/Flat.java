package lab7;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonSerialize(using = FlatSerializer.class)
@JsonDeserialize(using = FlatDeserializer.class)
public class Flat implements Serializable {
    private int flatNumber;
    private int square;
    private List<Person> people;

    public Flat(){}
    public Flat(int flatNumber, int square, List<Person> people) {
        this.flatNumber = flatNumber;
        this.square = square;
        this.people = new ArrayList<>();
        for(Person person : people){
            this.people.add(new Person(person));
        }
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public int getSquare() {
        return square;
    }

    public List<Person> getPeople() {
        return people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return getFlatNumber() == flat.getFlatNumber() &&
                getSquare() == flat.getSquare() &&
                getPeople().equals(flat.getPeople());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlatNumber(), getSquare(), getPeople());
    }

    @Override
    public String toString() {
        return "Flat{" +
                "flatNumber=" + flatNumber +
                ", square=" + square +
                ", people=" + people +
                '}';
    }
}
