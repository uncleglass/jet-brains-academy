package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        String wordToFound = scanner.next();
        int index = 1;
        boolean found = false;
        for (String word : words) {
            if (word.equals(wordToFound)) {
                found = true;
                break;
            }
            index++;
        }
        System.out.println(found ? index : "Not found");
    }
}
