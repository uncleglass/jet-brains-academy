package search;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchEngine {
    public static List<Person> search(List<Person> persons, String dataToSearch) {
        return persons.stream()
                .filter(person -> person.containsData(dataToSearch))
                .collect(Collectors.toUnmodifiableList());
    }

    public static List<Integer> search(Map<String, List<Integer>> indexes, String dataToSearch) {
        return indexes.get(dataToSearch);
    }
}
