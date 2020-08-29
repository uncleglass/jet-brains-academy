package search;

import java.util.ArrayList;
import java.util.List;

import static search.UserInterface.getInput;
import static search.UserInterface.sendMessage;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        sendMessage("Enter the number of people:");
        int numberOfPeople = Integer.parseInt(getInput());

        sendMessage("Enter all people:");
        for (int i = 0; i < numberOfPeople; i++) {
            Person newPerson = Converter.toPerson(getInput());
            persons.add(newPerson);
        }

        sendMessage("Enter the number of search queries:");
        int numberOfQueries = Integer.parseInt(getInput());

        for (int i = 0; i < numberOfQueries; i++) {
            sendMessage("Enter data to search people:");
            String dataToSearch = getInput();
            List<Person> foundPersons = SearchEngine.search(persons, dataToSearch);

            if (foundPersons.isEmpty()) {
                sendMessage("No matching people found.");
            } else {
                sendMessage("Found people:");
                for (Person person : foundPersons) {
                    sendMessage(person.toString());
                }
            }
        }

    }
}

/*
Write a program that reads text lines from the standard input and processes queries consisting of a single word to search for.
The program must output all lines which contain the string from the query.

You may choose what the text represents in your project. For example, each line may describe:

a person, represented by a first name, last name, and an optional email;

an address of a building, represented by country, city, state, street, and zip code;

information about a book, represented by ISBN, title, author/authors, publisher, and so on.

You can take any of these ideas or use your own, but it is important to work with the same type of dataset throughout
 all stages of the project. As item delimiters, you can use spaces, commas (see CSV), or any other characters.

Here is an example of a line. It contains three items: first name, last name, and this person's email.

Elsa Sanders elsa@gmail.com
In this example, all items are separated by spaces.

The search should ignore letter cases and all the extra spaces.

Firstly, the user should input a number N, which is a number of lines with data they are going to enter next. Then the
user enters N lines with data. After that, the user enters a number M, which is a number of search queries. And after
each query, the program should print the information it managed to find among the data. You can see this searching process
in the example below.

Example
In the following example, we use different names and e-mails as an example of the dataset. The lines that start with
> represent the user input.

Enter the number of people:
> 6
Enter all people:
> Dwight Joseph djo@gmail.com
> Rene Webb webb@gmail.com
> Katie Jacobs
> Erick Harrington harrington@gmail.com
> Myrtle Medina
> Erick Burgess

Enter the number of search queries:
> 3

Enter data to search people:
> ERICK

Found people:
Erick Harrington harrington@gmail.com
Erick Burgess

Enter data to search people:
> unknown
No matching people found.

Enter data to search people:
> WEBB@gmail.com

Found people:
Rene Webb webb@gmail.com
* */