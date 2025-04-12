import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PersonHelper {
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
        LocalDate date1 = bill.getBirthDate();
        LocalDate  date2 = paul.getBirthDate();
        return Math.abs(ChronoUnit.DAYS.between(date1, date2));
    }
}
