package search;

import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {
    public static List<Person> search(List<Person> persons, String dataToSearch) {
        return persons.stream()
                .filter(person -> person.containsData(dataToSearch))
                .collect(Collectors.toUnmodifiableList());
    }
}
