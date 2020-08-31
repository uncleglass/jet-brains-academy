package search;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class SearchEngine {
    public abstract List<Integer> search(Map<String, List<Integer>> indexes, String dataToSearch);

    protected List<Integer> intersection(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
    }
}
