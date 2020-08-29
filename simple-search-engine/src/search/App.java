package search;

import java.util.List;

import static search.UserInterface.getInput;
import static search.UserInterface.sendMessage;

public class App {
    private Data appData = new Data();
    ;

    public void loadData() {
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
        List<Person> foundPersons = SearchEngine.search(appData.getPersons(), dataToSearch);

        if (foundPersons.isEmpty()) {
            sendMessage("No matching people found.");
        } else {
            sendMessage("Found people:");
            for (Person person : foundPersons) {
                sendMessage(person.toString());
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
