// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Todo manager = new Todo();

        while (true) {
            System.out.print("""
                    Would you like to:
                    1) View tasks
                    2) Add a task
                    3) Mark task complete
                    4) Exit
                    Enter choice: """);

            if (!in.hasNextLine()) break;
            char choice = in.nextLine().trim().charAt(0);

            switch (choice) {
                case '1' -> manager.viewTasks();
                case '2' -> {
                    System.out.print("Task description: ");
                    manager.addTask(in.nextLine());
                }
                case '3' -> {
                    System.out.print("ID to complete: ");
                    int id = Integer.parseInt(in.nextLine());
                    manager.completeTask(id);
                }
                case '4' -> { in.close(); return; }
                default -> System.out.println("Not a valid choice.");
            }
            System.out.println();
        }
    }
}
