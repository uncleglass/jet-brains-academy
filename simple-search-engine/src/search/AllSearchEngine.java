package search;

import java.util.List;
import java.util.Map;

public class AllSearchEngine extends SearchEngine {
    //If the strategy is ALL, the program should print lines containing all words from the query.
    @Override
    public List<Integer> search(Map<String, List<Integer>> indexes, String dataToSearch) {
        List<Integer> result;
        String[] data = dataToSearch.split(" ");
        for (String s : data) {
            if (!indexes.containsKey(s.toLowerCase())) {
                return null;
            }
        }
        result = indexes.get(data[0]);
        for (int i = 1; i < data.length; i++) {
            result = intersection(result, indexes.get(data[i]));
        }
        return result.size() > 0 ? result : null;
    }
}
