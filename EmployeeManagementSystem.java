import java.util.*;

interface Employee {
    int getEmployeeID();

    String getName();

    String getPosition();

    double getSalary();

    void updateEmployee(String name, String position, double salary);
}

class Employees implements Employee {
    String name = "";
    int id = 0;
    String position = "";
    double salary = 0;

    public Employees(String name, int id, String position, double salary) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.salary = salary;

    }

    public int getEmployeeID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;

    }

    public double getSalary() {
        return this.salary;

    }

    // UPDATE EMPLOYEE
    public void updateEmployee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

class main {
    ArrayList<Employees> employ;

    public main() {
        this.employ = new ArrayList<>();
    }

    // ADD NEW EMPLOYEE
    public void add(Employees e) {
        boolean f = false;
        for (int i = 0; i < employ.size(); i++) {
            if (employ.get(i).getEmployeeID() == e.getEmployeeID()) {
                System.out.println("Employee already with this id");
                f = true;
                break;
            }
        }
        if (!f) {
            employ.add(e);
            System.out.println("Employee Succesfully added !");
        }

    }

    // SEARCH FOR EMPLOYEE
    public void search(int id) {
        boolean f = false;
        for (int i = 0; i < employ.size(); i++) {
            Employees temp = employ.get(i);
            if (temp.getEmployeeID() == id) {
                System.out.println("Infomation of employee with id " + "( " + (id) + " )" + " is ");
                System.out.println("Name = " + temp.getName() + " ,Position = " + temp.getPosition() + " ,Salary = "
                        + temp.getSalary());
                f = true;
                break;
            }
        }
        if (!f) {
            System.out.println("No employee exist with this id");
        }
    }

    // REMOVE EMPLOYEE WITH ID
    public void remove(int id) {
        boolean f = false;
        for (int i = 0; i < employ.size(); i++) {
            if (employ.get(i).getEmployeeID() == id) {
                employ.remove(i);
                f = true;
                System.out.println("Successfully removed");
            }

        }
        if (!f)
            System.out.println("No Employee Exist With This id ");
    }

    public void displayAll() {
        for (int i = 0; i < employ.size(); i++) {
            System.out.println("Id = " + employ.get(i).getEmployeeID() +
                    " ,Name = " + employ.get(i).getName() + " ,Position = " + employ.get(i).getPosition()
                    + " ,Salary = "
                    + employ.get(i).getSalary());
        }
    }

    // DISPLAY TOTAL SALARY OF ALL EMPLOYEE
    public void totalSalary() {
        double ans = 0;
        for (int i = 0; i < employ.size(); i++) {
            ans = ans + employ.get(i).getSalary();
        }

    }

    // SORT EMPLOYEES
    public void sortEmployeesBySalary() {
        Collections.sort(employ, Comparator.comparingDouble(Employee::getSalary));
        displayAll();
    }

    // UPDATE EMPLOYEE INFORMATION
    public void updateEmployeeInfo(int employeeID, String name, String position, double salary) {
        boolean f = false;
        for (Employee employee : employ) {
            if (employee.getEmployeeID() == employeeID) {
                employee.updateEmployee(name, position, salary);
                System.out.println("Employee Updated Successfulyyy....");
                break;
            }
        }
        if (!f)
            System.out.println("Employee with ID " + employeeID + " not found.");
    }
}

class EmployeeManagementSystem {
    public static void main(String[] args) {

        boolean f = true;
        Scanner sc1 = new Scanner(System.in);
        main m = new main();
        do {
            System.out.println(
                    ".............................Welcome to the Employee Management System ..................................");
            System.out.println("1. Add Employy\n" +
                    "2. Remove Employee\n" +
                    "3. Search Employee\n" +
                    "4. Update Employee\n" +
                    "5. Display Total Salary\n" +
                    "6. Sort Employee\n" +
                    "7. Display All Employee\n" +
                    "8. Exit");

            System.out.print("Enter your choice ");
            int n = sc1.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Enter Employy id ");
                    int i = sc1.nextInt();
                    System.out.println("Enter Name ");
                    String name = sc1.next();
                    System.out.println("Enter Postion");
                    String p = sc1.next();
                    System.out.println("Enter Salary");
                    double s = sc1.nextDouble();
                    Employees e = new Employees(name, i, p, s);
                    m.add(e);
                    break;
                case 2:
                    System.out.println("Enter Employy id ");
                    int id = sc1.nextInt();
                    m.remove(id);
                case 3:
                    System.out.println("Enter Employy id ");
                    int i1 = sc1.nextInt();
                    m.search(i1);
                case 4:
                    System.out.println("Enter Employee of that Employee");
                    int i2 = sc1.nextInt();
                    System.out.println("Enter New Name ");
                    String un = sc1.next();
                    System.out.println("Enter New Postion");
                    String up = sc1.next();
                    System.out.println("Enter New Salary");
                    double us = sc1.nextDouble();
                    m.updateEmployeeInfo(i2, un, up, us);
                case 5:
                    m.totalSalary();
                case 6:
                    m.sortEmployeesBySalary();
                    break;
                case 7:
                    m.displayAll();
                case 8:
                    f = false;

            }

        } while (f);
        sc1.close();
        // main m = new main();
        // Employees e = new Employees("Chhaya", 10, "Developer", 12000);
        // Employees e1 = new Employees("Chhaya", 20, "Developer", 12000);
        // m.add(e);
        // m.add(e1);
        // m.search(30);
        // m.displayAll();
        // // m.totalSalary();
        // // m.remove(20);
        // m.updateEmployeeInfo(10, "Tanya", "avi", 500);
        // m.displayAll();
    }

}