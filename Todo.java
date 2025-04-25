// Todo.java
public class Todo {
    private final TaskRepository repo = new TaskRepository();

    public void addTask(String desc) {
        repo.add(new Task(repo.nextId(), desc));
    }
    public void viewTasks()          { repo.printAll(); }
    public void completeTask(int id) { repo.markDone(id); }

    static class Task {
        final int id;
        String desc;
        boolean done;

        Task(int id, String desc) {
            this.id   = id;
            this.desc = desc;
        }
    }
}
