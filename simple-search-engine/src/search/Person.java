package search;

public class Person {
    private String firstName = "";
    private String lastName = "";
    private String email = "";

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public boolean containsData(String dataToSearch) {

        return firstName.toLowerCase().contains(dataToSearch.toLowerCase()) ||
                lastName.toLowerCase().contains(dataToSearch.toLowerCase()) ||
                email.toLowerCase().contains(dataToSearch.toLowerCase());
    }

    @Override
    public String toString() {
        return (firstName + " " + lastName + " " + email).trim();
    }

    public boolean noFirstName() {
        return firstName.isEmpty();
    }

    public boolean noLastName() {
        return lastName.isEmpty();
    }

    public boolean noEmail() {
        return email.isEmpty();
    }

    public String getFirstName() {
        if (noFirstName()) {
            return null;
        }
        return firstName;
    }

    public String getLastName() {
        if (noLastName()) {
            return null;
        }
        return lastName;
    }

    public String getEmail() {
        if (noEmail()) {
            return null;
        }
        return email;
    }
}
