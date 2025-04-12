import java.time.LocalDate;

public class Person {
    private String name;
    private String gender;
    private LocalDate birthDate;

    public Person(String name, String gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", Birth Date: " + birthDate;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}