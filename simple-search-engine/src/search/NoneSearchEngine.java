package search;

import java.util.*;

public class NoneSearchEngine extends SearchEngine {
    //If the strategy is NONE, the program should print lines that do not contain words from the query at all:
    @Override
    public List<Integer> search(Map<String, List<Integer>> indexes, String dataToSearch) {
        String[] data = dataToSearch.split(" ");
        Set<Integer> resultSet = new HashSet<>();
        for (Map.Entry<String, List<Integer>> entry : indexes.entrySet()) {
            resultSet.addAll(entry.getValue());
        }
        for (String s : data) {
            List<Integer> integers = indexes.get(s.toLowerCase());
            resultSet.removeAll(integers);
        }


        if (resultSet.size() == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
}
