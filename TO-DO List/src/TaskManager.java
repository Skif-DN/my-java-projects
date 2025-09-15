import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    private static final String FILE_NAME = "tasks.ser";

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int index){
        int realIndex = index - 1;
        if (realIndex >= 0 && realIndex < tasks.size()){
            tasks.remove((realIndex));
        } else {
            System.out.println("Incorrect index!");
        }
    }

    public void markTaskAsDone(int index) {
        int realIndex = index - 1;
        if (realIndex >= 0 && realIndex < tasks.size()) {
            tasks.get(realIndex).markAsDone();
        } else {
            System.out.println("Incorrect index!");
        }
    }

    public void editTask(int index, String newTitle, String newDescription){
        int realIndex = index - 1;
        if(realIndex >= 0 && realIndex < tasks.size()) {
            Task task = tasks.get(realIndex);
            task.setTitle(newTitle);
            task.setDescription(newDescription);
        } else {
            System.out.println("Incorrect index!");
        }
    }

    public void printAllTasks(){
        if(tasks.isEmpty()){
            System.out.println("Task list is empty");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
     }

     public  void saveTasks(){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Unable to save task " + e.getMessage());
        }
     }

    public void loadTasks() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tasks = (ArrayList<Task>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Unable to load task " + e.getMessage());
        }
    }

    public void sortBeCreatedDate(){
        Collections.sort(tasks, Comparator.comparing(Task::getCreatedTask));
    }

    public void sortByCompletedDate() {
        Collections.sort(tasks, Comparator.comparing(
                task -> task.getCompletedTask() == null ? LocalDateTime.MAX : task.getCompletedTask()
        ));
    }

    public void sortByTitle() {
        Collections.sort(tasks, Comparator.comparing(Task::getTitle));
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
