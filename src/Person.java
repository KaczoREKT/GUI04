import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.time.LocalDate;

public class Person {

    public enum Gender {
        MALE, FEMALE
    }

    @CsvBindByName(column = "firstName")
    private String firstName;
    @CsvBindByName(column = "lastName")
    private String lastName;
    @CsvBindByName(column = "email")
    private String email;
    @CsvBindByName(column = "gender")
    private Gender gender;
    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByName(column = "birthDate")
    private LocalDate birthDate;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                '}';
    }
}
