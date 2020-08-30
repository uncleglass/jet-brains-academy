package search;

import java.util.*;

public class Data {
    private final List<Person> persons = new ArrayList<>();
    private final Map<String, List<Integer>> invertedIndex = new HashMap<>();

    public void add(Person person) {
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void addIndex(String data, Integer index) {
        if (invertedIndex.containsKey(data)) {
            List<Integer> integers = invertedIndex.get(data);
            integers.add(index);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(index);
            invertedIndex.put(data, list);
        }
    }

    public Map<String, List<Integer>> getInvertedIndex() {
        return invertedIndex;
    }
}
