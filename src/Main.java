import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
        Person oldest = getOldestPerson(person);
        System.out.println("The oldest person is: " + oldest.getName());
        long diff = getDaysOlder(person.get(0), person.get(1));
        System.out.println("Bill is " + diff + " days older than Paul ");
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
    public static Person getOldestPerson(ArrayList<Person> person) {
        Person oldest = person.get(0);
        for (Person p : person) {
            if (p.getBirthDate().isBefore(oldest.getBirthDate())) {
                oldest = p;
            }
        }
        return oldest;
    }

    // 3. How many days older is Bill than Paul?
    public static long getDaysOlder(Person bill, Person paul) {
        LocalDate  date1 = bill.getBirthDate();
        LocalDate  date2 = paul.getBirthDate();
        return Math.abs(ChronoUnit.DAYS.between(date1, date2));
    }
}