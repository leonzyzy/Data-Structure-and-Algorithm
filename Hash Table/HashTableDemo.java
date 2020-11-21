package HashTable;
import java.util.Scanner;

public class HashTableDemo {
    // main function
    public static void main(String[] args) {
        // define object hashtable
        HashTable h = new HashTable(5);
        // write a menu for testing
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: add employee");
            System.out.println("delete: delete employee");
            System.out.println("show: show employee");
            System.out.println("find: find employee");
            System.out.println("exit: exit task");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("Enter employee id");
                    int id = scanner.nextInt();
                    System.out.println("Enter employee name");
                    String name = scanner.next();
                    // define a employee
                    h.add(new Employee(id, name));
                    break;
                case "delete":
                    System.out.println("Enter employee id");
                    id = scanner.nextInt();
                    h.delete(id);
                    break;
                case "show":
                    h.show();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                case "find":
                    System.out.println("Enter employee id");
                    id = scanner.nextInt();
                    h.findEmp(id);
                    break;
                default:
                    break;
            }
        }

    }
}

// hashtable to manage linked list
class HashTable {
    private EmployeeLinkedList[] empArray;
    private int size; // how many linked list

    // constructor
    public HashTable(int size) {
        this.size = size;
        this.empArray = new EmployeeLinkedList[size];
        // initialize employee linked list and store into array
        for (int i = 0; i < size; i++) {
            empArray[i] = new EmployeeLinkedList();
        }
    }

    // add
    public void add(Employee emp) {
        // according to employee id to decide which linked list add to
        int index = hashFunction(emp.id);

        // add emp into linked list with index
        empArray[index].add(emp);
    }

    // delete
    public void delete(int id) {
        // hash function to map the id to array index
        int index = hashFunction(id);
        empArray[index].delete(id);
    }

    // iterative all the linked list
    public void show() {
        for (int i = 0; i < size; i++) {
            empArray[i].show(i);
        }
    }

    // find employee
    public void findEmp(int id) {
        // according to employee id to decide which linked list add to
        int index = hashFunction(id);
        Employee emp = empArray[index].findEmp(id);
        if (emp != null) {
            System.out.printf("Find employee at %dth list with info (%d, %s)\n", index, id, emp.name);
        } else {
            System.out.println("Cannot find employee in hash table");
        }
    }

    // hash function to return the index of empArray
    public int hashFunction(int id) {
        return id % size;
    }

}

// employee linked list class
class EmployeeLinkedList {
    private Employee first; // not the head node, this is the first node

    // methods
    // assume when add, id increases, add into last node
    public void add(Employee emp) {
        // if add first employee
        if (first == null) {
            first = emp;
            return;
        }
        // if is not add first employee
        Employee curr = first;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = emp;
    }

    // delete method
    public void delete(int id) {
        // check if linked list is empty
        if (first == null) {
            System.out.println("Empty list");
            return;
        }
        // first node is deleted node
        Employee curr = first;

        // find previous index of id
        while (curr != null) {
            // check if first node is the deleted node
            if (first.id == id) {
                first = curr.next;
                break;
            }
            if (curr.next.id == id) {
                curr.next = curr.next.next;
                break;
            }
            // if curr is the last node
            if (curr.next == null) {
                System.out.println("Cannot find this ID");
                break;
            }
        }
    }
    // iterative
    public void show(int n) {
        if (first == null) {
            System.out.println((n+1) + "th list => Empty list");
            return;
        }
        System.out.print((n+1) + "th list ");
        Employee curr = first;
        while (curr != null) {
            System.out.printf("=> (%d, %s) ", curr.id, curr.name);
            curr = curr.next;
        }
        System.out.println();
    }
    // search the employee by id
    public Employee findEmp(int id) {
        // check if is empty
        if (first == null) {
            return null;
        }
        // search from first node
        Employee curr = first;
        while (curr != null) {
            if (curr.id == id) {
                break;
            }
            if (curr.next == null) {
                curr = null;
                break;
            }
            curr = curr.next;
        }
        return curr;
    }
}
// employee class, this is also a node class
class Employee {
    public int id;
    public String name;
    public Employee next;

    // constructor
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}