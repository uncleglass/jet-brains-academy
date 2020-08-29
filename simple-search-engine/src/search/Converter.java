package search;

public class Converter {
    public static Person toPerson(String input) {
        String[] split = input.split(" ");
        if (split.length == 1) {
            return new Person(split[0]);
        }
        if (split.length == 2) {
            return new Person(split[0], split[1]);
        }
        return new Person(split[0], split[1], split[2]);
    }
}
