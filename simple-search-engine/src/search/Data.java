package search;

import java.util.*;

public class Data {
    private final List<String> lines = new ArrayList<>();
    private final Map<String, List<Integer>> invertedIndex = new HashMap<>();
    private SearchEngine searchEngine;

    public void setSearchEngine(SearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }

    public List<Integer> search(String dataToSearch) {
        return searchEngine.search(invertedIndex, dataToSearch);
    }
    public void add(String line) {
        lines.add(line);
    }

    public List<String> getLines() {
        return lines;
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

    public String getLine(Integer index) {
        return lines.get(index);
    }
}
