package com.problem3;
// Class representing a Task in the circular linked list
class Task {
    String taskName;
    int taskId;
    int taskPriority;
    String dueDate; // Due date of the task
    Task next; // Pointer to the next task in the list

    // Constructor to initialize a task
    Task(String taskName, int taskId, int taskPriority, String dueDate) {
        this.taskName = taskName;
        this.taskId = taskId;
        this.taskPriority = taskPriority;
        this.dueDate = dueDate;
        this.next = null; // Initially, next is null
    }
}

// Class to manage the circular linked list of tasks
class TaskManager {
    private Task head = null; // Head of the list
    private Task tail = null; // Tail of the list
    private Task currentTask = null; // Pointer to the current task

    // Method to add a task at the beginning of the list
    public void addAtBeginning(String taskName, int taskId, int taskPriority, String dueDate) {
        Task newTask = new Task(taskName, taskId, taskPriority, dueDate);
        if (head == null) { // If the list is empty
            head = tail = newTask;
            tail.next = head; // Make it circular
            return;
        }
        newTask.next = head; // Point new task to the current head
        head = newTask; // Update head
        tail.next = head; // Maintain circular structure
    }

    // Method to add a task at the end of the list
    public void addAtEnd(String taskName, int taskId, int taskPriority, String dueDate) {
        Task newTask = new Task(taskName, taskId, taskPriority, dueDate);
        if (head == null) { // If the list is empty
            head = tail = newTask;
            tail.next = head; // Make it circular
            return;
        }
        newTask.next = tail.next; // Point new task to the head
        tail.next = newTask; // Update tail's next pointer
        tail = newTask; // Update tail to the new task
    }

    // Method to add a task at a specific position in the list
    public void addAtSpecificPosition(int position, String taskName, int taskId, int taskPriority, String dueDate) {
        if (position <= 0) { // Validate position
            System.out.println("Please Enter valid position.");
            System.out.println("================================================");
            return;
        }
        Task newTask = new Task(taskName, taskId, taskPriority, dueDate);
        if (position == 1) { // Add at the beginning
            newTask.next = head;
            head = newTask;
            tail.next = head; // Maintain circular structure
            return;
        }
        Task current = head;
        int poss;
        // Traverse to the desired position
        for (poss = 1; poss < position - 1 && current.next != head; poss++) {
            current = current.next;
        }
        if (poss != position - 1) { // Check if position is valid
            System.out.println("Invalid Position.");
            System.out.println("================================================");
            return;
        }
        newTask.next = current.next; // Insert the new task
        current.next = newTask;
        if (current == tail) { // If added at the end, update the tail
            tail = newTask;
        }
    }

    // Method to remove a task by its ID
    public void removeTaskByTaskId(int taskId) {
        if (head == null) { // Check if list is empty
            System.out.println("List is Empty.");
            System.out.println("================================================");
            return;
        }
        Task current = head, prev = null;
        // Traverse the list to find the task
        do {
            if (current.taskId == taskId) {
                if (current == head && current == tail) { // Single-node case
                    head = null;
                    tail = null;
                } else if (current == head) { // Removing the head
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) { // Removing the tail
                    tail = prev;
                    tail.next = head;
                } else { // Removing in between
                    prev.next = current.next;
                }
                System.out.println("Task ID " + taskId + " removed.");
                System.out.println("================================================");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head); // Continue until the circular list is traversed
        System.out.println("Task ID " + taskId + " not found.");
        System.out.println("================================================");
    }

    // Method to view the current task and move to the next task
    public void viewCurrentTaskAndMove() {
        if (head == null) { // Check if list is empty
            System.out.println("List is Empty.");
            System.out.println("================================================");
            return;
        }
        if (currentTask == null) { // Initialize currentTask if not set
            currentTask = head;
        }
        System.out.println("Current Task Name: " + currentTask.taskName);
        System.out.println("Current Task Id: " + currentTask.taskId);
        System.out.println("==============================================");
        currentTask = currentTask.next; // Move to the next task
    }

    // Method to display all tasks in the circular linked list
    public void displayAllTasks() {
        if (head == null) { // Check if list is empty
            System.out.println("Task list is empty.");
            System.out.println("================================================");
            return;
        }
        Task current = head;
        System.out.println("All Tasks:");
        do {
            System.out.println();
            System.out.println("Task ID: " + current.taskId);
            System.out.println("Task Name: " + current.taskName);
            System.out.println("Priority: " + current.taskPriority);
            System.out.println("Due Date: " + current.dueDate);
            System.out.println("=============================================");
            current = current.next;
        } while (current != head); // Loop through the circular list
    }

    // Method to search for a task by its priority
    public void searchByPriority(int priority) {
        if (head == null) { // Check if list is empty
            System.out.println("List is Empty.");
            return;
        }
        Task current = head;
        do {
            if (current.taskPriority == priority) {
                System.out.println("Task is found with Priority " + current.taskPriority);
                System.out.println("Task Name: " + current.taskName);
                System.out.println("Task Id: " + current.taskId);
                System.out.println("================================================");
                return;
            }
            current = current.next;
        } while (current != head); // Loop through the circular list
        System.out.println("Task is not found with Priority " + priority);
    }
}

// Main class to test the Task Scheduler
public class TaskScheduler {
    public static void main(String... args) {
        TaskManager scheduler = new TaskManager();

        // Adding tasks
        scheduler.addAtBeginning("Task 1", 1001, 3, "2025-01-28");
        scheduler.addAtEnd("Task 2", 1002, 5, "2025-01-28");
        scheduler.addAtSpecificPosition(2, "Task 3", 1003, 9, "2025-01-28");

        // Display all tasks
        scheduler.displayAllTasks();
        System.out.println();

        // View current task and move to the next
        scheduler.viewCurrentTaskAndMove();
        scheduler.viewCurrentTaskAndMove();
        System.out.println();

        // Search for a task by priority
        scheduler.searchByPriority(4);
        System.out.println();

        // Remove a task by Task ID
        scheduler.removeTaskByTaskId(121);
        System.out.println();

        // Display all tasks after removal
        scheduler.displayAllTasks();
    }
}
