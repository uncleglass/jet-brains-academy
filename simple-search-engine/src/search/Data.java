package search;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private final List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }
}
