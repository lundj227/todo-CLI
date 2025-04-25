// TaskRepository.java
public class TaskRepository {

    private static class Node {
        Todo.Task task;
        Node next;
        Node(Todo.Task t) { this.task = t; }
    }

    private Node head = null, tail = null;
    private int  nextId = 1;
    int nextId() { return nextId++; }

    public void add(Todo.Task t) {
        Node n = new Node(t);
        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail      = n;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("No tasks yet.");
            return;
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            Todo.Task x = cur.task;
            System.out.printf("[%d] %s %s%n",
                    x.id,
                    x.desc,
                    x.done ? "(✓)" : "");
        }
    }

    public void markDone(int id) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.task.id == id) {
                if (cur.task.done) {
                    System.out.println("Task already complete.");
                } else {
                    cur.task.done = true;
                    System.out.println("Marked complete.");
                }
                return;
            }
        }
        System.out.println("ID not found.");
    }
}
