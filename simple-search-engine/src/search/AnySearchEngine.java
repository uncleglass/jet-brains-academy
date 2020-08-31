package search;

import java.util.*;

public class AnySearchEngine extends SearchEngine {
    //If the strategy is ANY, the program should print lines containing at least one word from the query.
    @Override
    public List<Integer> search(Map<String, List<Integer>> indexes, String dataToSearch) {
        Set<Integer> resultSet = new HashSet<>();
        String[] data = dataToSearch.split(" ");
        for (String s : data) {
            List<Integer> foundIndexes = indexes.get(s.toLowerCase());
            if (foundIndexes != null) {
                resultSet.addAll(foundIndexes);
            }
        }
        if (resultSet.size() == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
}
