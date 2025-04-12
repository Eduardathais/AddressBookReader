import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("AddressBook.txt");
        Scanner scan = new Scanner(file);
        ArrayList<Person> person = new ArrayList<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy");
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split(",");
            String name = parts[0];
            String gender = parts[1].trim();
            LocalDate birthDate = LocalDate.parse(parts[2].trim(), format);
            person.add(new Person(name, gender, birthDate));
        }
        scan.close();

        int total = PersonHelper.getMalesCount(person);
        System.out.println("There are " + total + " males in the address book.");
        Person oldest = PersonHelper.getOldestPerson(person);
        System.out.println("The oldest person is: " + oldest.getName());
        long diff = PersonHelper.getDaysOlder(person.get(0), person.get(1));
        System.out.println("Bill is " + diff + " days older than Paul ");
    }

}