class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagementSystem {

    static Task head = null;

    // Add Task
    public static void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }

        System.out.println("Task Added Successfully");
    }

    // Search Task
    public static void searchTask(int id) {
        Task temp = head;

        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("Task Found:");
                System.out.println("ID: " + temp.taskId +
                        ", Name: " + temp.taskName +
                        ", Status: " + temp.status);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Task Not Found");
    }

    // Traverse Tasks
    public static void traverseTasks() {
        Task temp = head;

        System.out.println("\nTask List:");

        while (temp != null) {
            System.out.println("ID: " + temp.taskId +
                    ", Name: " + temp.taskName +
                    ", Status: " + temp.status);
            temp = temp.next;
        }
    }

    // Delete Task
    public static void deleteTask(int id) {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted Successfully");
            return;
        }

        Task temp = head;
        Task prev = null;

        while (temp != null && temp.taskId != id) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Task Not Found");
            return;
        }

        prev.next = temp.next;
        System.out.println("Task Deleted Successfully");
    }

    public static void main(String[] args) {

        addTask(101, "Design Module", "Pending");
        addTask(102, "Develop Code", "In Progress");
        addTask(103, "Testing", "Pending");

        traverseTasks();

        System.out.println("\nSearching Task:");
        searchTask(102);

        System.out.println("\nDeleting Task:");
        deleteTask(102);

        traverseTasks();
    }
}