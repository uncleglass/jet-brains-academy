package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static search.UserInterface.getInput;
import static search.UserInterface.sendMessage;

public class App {
    private Data appData = new Data();

    public void loadData(String[] args) {
        if (args.length == 0) {
            readFromInput();
        } else {
            readFromFile(args);
        }
        invertIndex();
    }

    private void invertIndex() {
        List<Person> persons = appData.getPersons();
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            String firstName = person.getFirstName();
            if (firstName != null) {
                appData.addIndex(firstName, i);
            }
            String lastName = person.
                    getLastName();
            if (lastName != null) {
                appData.addIndex(lastName, i);
            }
            String email = person.getEmail();
            if (email != null) {
                appData.addIndex(email, i);
            }
        }
    }

    private void readFromFile(String[] args) {
        String pathToFile = args[1];
        File file = new File(pathToFile);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                Person newPerson = Converter.toPerson(scanner.nextLine());
                appData.add(newPerson);
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
            Person newPerson = Converter.toPerson(getInput());
            appData.add(newPerson);
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
        for (Person person : appData.getPersons()) {
            sendMessage(person.toString());
        }
        sendMessage("");
    }

    private void findData() {
        sendMessage("Enter a name or email to search all suitable people.");
        String dataToSearch = getInput();
//        List<Person> foundPersons = SearchEngine.search(appData.getPersons(), dataToSearch);
        List<Integer> foundIndexes = SearchEngine.search(appData.getInvertedIndex(), dataToSearch);

        if (foundIndexes == null) {
            sendMessage("No matching people found.");
        } else {
            sendMessage(foundIndexes.size() + " persons found:");
            List<Person> persons = appData.getPersons();
            for (int i : foundIndexes) {
                sendMessage(persons.get(i).toString());
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
