package lab7;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonSerialize(using = HouseSerializer.class)
@JsonDeserialize(using = HouseDeserializer.class)
public class House implements Serializable {

    private String CNumber;
    private String address;
    private Person theOldest;
    private List<Flat> flats;

    House(){}
    public House(String CNumber, String address, Person theOldest, List<Flat> flats) {
        this.CNumber = CNumber;
        this.address = address;
        this.theOldest = theOldest;
        this.flats = new ArrayList<>();
        for(Flat flat : flats){
            this.flats.add(new Flat(flat.getFlatNumber(), flat.getSquare(), flat.getPeople()));
        }
    }

    public String getCNumber() {
        return CNumber;
    }

    public String getAddress() {
        return address;
    }

    public Person getTheOldest() {
        return theOldest;
    }

    public List<Flat> getFlats() {
        return flats;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return CNumber.equals(house.CNumber) &&
                getAddress().equals(house.getAddress()) &&
                getTheOldest().equals(house.getTheOldest()) &&
                getFlats().equals(house.getFlats());
    }

    @Override
    public String toString() {
        return "House{" +
                "CNumber='" + CNumber + '\'' +
                ", address='" + address + '\'' +
                ", theOldest=" + theOldest +
                ", flats=" + flats +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(CNumber, getAddress(), getTheOldest(), getFlats());
    }
}
