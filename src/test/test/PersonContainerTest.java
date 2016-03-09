import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class PersonContainerTest {

    ArrayList<Person> arrayOfPersons = new ArrayList<>();
    ArrayList<Person> arrayOfFoundPersons = new ArrayList<>();


    public void findPersonByName(String searchQuery) {
        ArrayList<Person> arrayOfFoundPersons = new ArrayList<>();
        arrayOfPersons.add(new Person("Ivan", 25, "dsfjdf@gmail.com"));
        arrayOfPersons.add(new Person("Sam", 43, "dsfjdf@gmail.com"));

        searchQuery = searchQuery.toLowerCase();

        System.out.println("SEARCH RESULTS:\n");

        for (Person p : arrayOfPersons) {
            if (p.getName().toLowerCase().equals(searchQuery)) {
                arrayOfFoundPersons.add(p);
                System.out.println(searchQuery.toUpperCase() + " found. He/she is " + p.getAge() + " years old.\n");
            }
        }
        if(arrayOfFoundPersons.isEmpty()) {
            System.out.println("Nothing were found....");

        }
    }

    @Test
    public void shouldFindIvanInArray25YearsOld() {
        findPersonByName("Ivan");
        String name = arrayOfFoundPersons.get(0).getName();
        int age = arrayOfFoundPersons.get(0).getAge();
        assertEquals(name, "Ivan");
        assertEquals(age, 25);
    }

    @Test
    public void shouldFindSam43YearsOldIgnoringCase() {
        findPersonByName("sAm");
        String name = arrayOfFoundPersons.get(0).getName();
        int age = arrayOfFoundPersons.get(0).getAge();
        assertEquals(name, "Sam");
        assertEquals(age,43);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void shouldFailWithIndexOutOfBounds() {
        findPersonByName("Steve");
        String name = arrayOfFoundPersons.get(0).getName();
    }

    public void findPersonByAge(String searchQuery) {
        arrayOfPersons.add(new Person("Tim", 55, "dsfjdf@gmail.com"));
        int age = Converter.convertFromStringToInt(searchQuery);
        System.out.println("SEARCH RESULTS:\n");

        for (Person p : arrayOfPersons) {
            if (p.getAge() == age) {
                arrayOfFoundPersons.add(p);
                System.out.println(p.getName().toUpperCase() + " found (" + p.getAge() +
                        " years old).\n");
            }
        }
        if(arrayOfFoundPersons.isEmpty()) {
            System.out.println("Nothing were found....");

        }
    }

    @Test
    public void shouldFindPerson55YearsOld() {
        findPersonByAge("55");
        int age = arrayOfFoundPersons.get(0).getAge();
        String name = arrayOfFoundPersons.get(0).getName();
        assertEquals(age, 55);
        assertEquals(name, "Tim");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void shouldNotFindPerson18YearsOld() {
        findPersonByAge("18");
        int age = arrayOfFoundPersons.get(0).getAge();
    }

    public void findPersonByEmail(String email) {
        arrayOfPersons.add(new Person("Ivan", 25, "example@gmail.com"));
        System.out.println("Searching by email...");

        System.out.println("SEARCH RESULTS:\n");

        for(Person p : arrayOfPersons) {
            if(p.getEmail().equalsIgnoreCase(email)) {
                arrayOfFoundPersons.add(p);
                System.out.println(p.getName().toUpperCase() + " found (" + p.getAge() + " years old. " +
                        "Email: " + p.getEmail() + "\n");
            }
        }

    }

    @Test
    public void shouldFindIvanByEmail() {
        findPersonByEmail("example@gmail.com");
        String email = arrayOfFoundPersons.get(0).getEmail();
        String name = arrayOfFoundPersons.get(0).getName();
        int age = arrayOfFoundPersons.get(0).getAge();
        assertEquals(email, "example@gmail.com");
        assertEquals(name, "Ivan");
        assertEquals(age, 25);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void searchShouldFail() {
        findPersonByEmail("notexisting@gmail.com");
        String email = arrayOfFoundPersons.get(0).getEmail();
    }
}
