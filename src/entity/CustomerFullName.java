package entity;

import javax.persistence.Embeddable;

@Embeddable
public class CustomerFullName {
    private String firstName;
    private String lastName;

    public CustomerFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerFullName() {
    }

    @Override
    public String toString() {
        return "CustomerFullName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
