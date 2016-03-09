import java.util.Scanner;

public class InputReader {


    private Scanner scanner;


    public String readNameFromConsole(){
        this.scanner = new Scanner(System.in);
        System.out.println("Enter Person name: ");
        String name = scanner.nextLine();
        return name;
    }

    public String readAgeFromConsole(){
        System.out.println("Enter Person age: ");
        return this.scanner.nextLine();
    }

    public String readEmailFromConsole() {
        System.out.println("Enter Person email: ");
        return this.scanner.nextLine();
    }


    public String askAndReadUserChoise() {

        System.out.println("================================\n" +
                "Select the option you want to perform:\n" +
                "1.Add New Person\n" +
                "2.Find a Person\n" +
                "3.Exit\n" +
                "================================");
        this.scanner = new Scanner(System.in);
        return this.scanner.nextLine();
    }

    public String readSearchQueryFromConsole() {
        System.out.println("Write your search parameter (name or age):");
        return this.scanner.nextLine();
    }

}
