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

        for (Person p : person) {
            System.out.println(p);
        }

        int total = getMalesCount(person);
        System.out.println("There are " + total + " males in the address book.");
    }

    // 1. How many males are in the address book?
    public static int getMalesCount(ArrayList<Person> person) {
        int count = 0;
        for (Person p : person) {
            if (p.getGender().equals("Male")) {
                count++;
            }
        }
        return count;
    }

    // 2. Who is the oldest person in the address book?
    // 3. How many days older is Bill than Paul?
}