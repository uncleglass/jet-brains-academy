package search;

public class Person {
    private String firstName;
    private String lastName;
    private String email;

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
                (lastName != null && lastName.toLowerCase().contains(dataToSearch.toLowerCase())) ||
                (email != null && email.toLowerCase().contains(dataToSearch.toLowerCase()));
    }

    @Override
    public String toString() {
        return firstName + " " +
                (lastName.isEmpty() ? "" : lastName + " ") +
                (email.isEmpty() ? "" : email);
    }
}
