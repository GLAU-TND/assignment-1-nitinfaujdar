package contact;
import java.util.ArrayList;

public class Person {
    String firstName;
    String lastName;
    ArrayList<String> phoneNumber;
    String email;

    public Person(){
    }
    public Person(String firstName, String lastName, String email, ArrayList<String> phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
