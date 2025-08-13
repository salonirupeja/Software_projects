/***************************************************************
 * Filename    : ToDoListApp.java
 * Description : A simple command-line To-Do List application 
 *               that allows users to add, view, and remove tasks.
 * Author Name : Saloni Rupeja
 ***************************************************************/
import java.util.ArrayList;
import java.util.Scanner;
public class ToDoListApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        int choice;

        while (true) {
            System.out.println("\n--- TO-DO LIST MENU ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Check if input is a number
            if (!sc.hasNextInt()) {
                System.out.println("❌ Please enter a valid number!");
                sc.nextLine(); // clear invalid input
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();
                    tasks.add(task);
                    System.out.println("✅ Task added!");
                    break;

                case 2:
                    System.out.println("\nYour Tasks:");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks yet!");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove!");
                        break;
                    }
                    System.out.print("Enter task number to remove: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("❌ Invalid number!");
                        sc.nextLine();
                        break;
                    }
                    int taskNo = sc.nextInt();
                    sc.nextLine(); // consume newline
                    if (taskNo > 0 && taskNo <= tasks.size()) {
                        tasks.remove(taskNo - 1);
                        System.out.println("🗑 Task removed!");
                    } else {
                        System.out.println("❌ Invalid task number!");
                    }
                    break;

                case 4:
                    System.out.println("👋 Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice, try again!");
            }
        }
    }
}
