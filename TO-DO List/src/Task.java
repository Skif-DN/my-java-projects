import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements Serializable {
    private String title;
    private String description;
    private boolean isDone;
    private LocalDateTime createdTask;
    private LocalDateTime completedTask;

    public Task (String title, String description) {
        this.title = title;
        this.description = description;
        this.isDone = false;
        this.createdTask = LocalDateTime.now();
        this.completedTask = null;
    }

    public void markAsDone() {
        if (!isDone){
            isDone = true;
            completedTask = LocalDateTime.now();
        }
    }

    public boolean isDone (){
        return isDone;
    }

    public String toString (){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String createdStr = createdTask.format(formatter);
        String completedStr = (completedTask != null ? completedTask.format(formatter) : "The task is not completed");

        return  title + " - " + description +
                "\n Created: " + createdStr +
                "\n Completed: " + completedStr + "\n";
    }

    public LocalDateTime getCreatedTask(){
        return createdTask;
    }

    public LocalDateTime getCompletedTask() {
        return completedTask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle (String title){
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
