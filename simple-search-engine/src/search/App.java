package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static search.UserInterface.getInput;
import static search.UserInterface.sendMessage;

public class App {
    private final Data appData = new Data();

    public void loadData(String[] args) {
        if (args.length == 0) {
            readFromInput();
        } else {
            readFromFile(args);
        }
        invertIndex();
    }

    private void invertIndex() {
        List<String> lines = appData.getLines();
        for (int i = 0; i < lines.size(); i++) {
            String[] line = lines.get(i).split(" ");
            for (String s : line) {
                appData.addIndex(s.toLowerCase(), i);
            }
        }
    }

    private void readFromFile(String[] args) {
        String pathToFile = args[1];
        File file = new File(pathToFile);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                appData.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }
    }

    private void readFromInput() {
        sendMessage("Enter the number of people:");
        int numberOfPeople = Integer.parseInt(getInput());

        sendMessage("Enter all people:");
        for (int i = 0; i < numberOfPeople; i++) {
            appData.add(getInput());
        }
        sendMessage("");
    }

    public void run() {
        boolean runApp = true;
        while (runApp) {
            printMenu();
            String input = getInput();
            sendMessage("");
            switch (input) {
                case "0":
                    runApp = false;
                    break;
                case "1":
                    findData();
                    break;
                case "2":
                    printData();
                    break;
                default:
                    sendMessage("Incorrect option! Try again.");
            }
            sendMessage("");
        }
        sendMessage("Bye!");
    }

    private void printData() {
        sendMessage("=== List of people ===");
        for (String line : appData.getLines()) {
            sendMessage(line);
        }
        sendMessage("");
    }

    private void findData() {
        sendMessage("Select a matching strategy: ALL, ANY, NONE");
        String strategy = getInput();
        sendMessage("");
        switch (strategy.toUpperCase()) {
            case "ALL":
                appData.setSearchEngine(new AllSearchEngine());
                break;
            case "ANY":
                appData.setSearchEngine(new AnySearchEngine());
                break;
            case "NONE":
                appData.setSearchEngine(new NoneSearchEngine());
                break;
            default:
                sendMessage("Unknown strategy");
                return;
        }

        sendMessage("Enter a name or email to search all suitable people.");
        String dataToSearch = getInput();
        List<Integer> indexes = appData.search(dataToSearch);
        if (indexes == null) {
            sendMessage("No matching people found.");
        } else {
            sendMessage(indexes.size() + " persons found:");
            for (Integer index : indexes) {
                sendMessage(appData.getLine(index));
            }
        }
        sendMessage("");
    }

    private void printMenu() {
        sendMessage("=== Menu ===");
        sendMessage("1. Find a person");
        sendMessage("2. Print all people");
        sendMessage("0. Exit");
    }
}
