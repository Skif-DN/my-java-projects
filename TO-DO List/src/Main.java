import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.loadTasks();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n---MENU---");
            System.out.println("1. Add task");
            System.out.println("2. Display a list of tasks");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Edit task");
            System.out.println("5. Delete task");
            System.out.println("6. Sort tasks by created date");
            System.out.println("7. Sort tasks by completed date");
            System.out.println("8. Sort tasks by title");
            System.out.println("9. EXIT");

            String input = scanner.nextLine();
            int choice;
            try{
                choice = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("Please enter a number between 1-9");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Task name: ");
                    String title = scanner.nextLine();
                    System.out.println("Description: ");
                    String description = scanner.nextLine();
                    manager.addTask(new Task(title, description));
                    System.out.println("The task successful added.");
                    break;
                case 2:
                    manager.printAllTasks();
                    break;
                case 3:
                    System.out.println("Enter task index: ");
                    int doneIndex = scanner.nextInt();
                    scanner.nextLine();
                    manager.markTaskAsDone(doneIndex);
                    System.out.println("The task is completed.");
                    break;
                case 4:
                    System.out.println("Enter index of task: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.println("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    manager.editTask(editIndex, newTitle, newDescription);
                    System.out.println("The task is edited.");
                    break;
                case 5:
                    System.out.println("Enter task index: ");
                    int removeIndex = scanner.nextInt();
                    scanner.nextLine();
                    manager.removeTask(removeIndex);
                    System.out.println("The task is deleted.");
                    break;
                case 6:
                    manager.sortBeCreatedDate();
                    System.out.println("Tasks sorted by created date.");
                    break;
                case 7:
                    manager.sortByCompletedDate();
                    System.out.println("Tasks sorted by completed date.");
                    break;
                case 8:
                    manager.sortByTitle();
                    System.out.println("Tasks sorted by title.");
                    break;
                case 9:
                    manager.saveTasks();
                    System.out.println(("Exiting..."));
                    return;
                default:
                    System.out.println("Wrong choice!");

            }
        }
    }
}
