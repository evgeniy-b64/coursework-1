package Employees_book;

public class Employee {
    int id;
    private static int idCounter = 1;
    private String firstName;
    private String secondName;
    private String lastName;
    private int department;
    private int salary;

    public Employee(String firstName, String secondName, String lastName, int department, int salary) {          // конструктор класса Employee
        this.id = idCounter++;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public void setID(int id) {                // сеттер id сотрудника
        this.id = id;
    }

    public void setFirstName(String firstName) {          // сеттер имени сотрудника
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {        // сеттер отчества сотрудника
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {            // сеттер фамилии сотрудника
        this.lastName = lastName;
    }

    public void setDepartment(int department) {        // сеттер отдела сотрудника
        this.department = department;
    }

    public void setSalary(int salary) {                // сеттер зарплаты сотрудника
        this.salary = salary;
    }

    public String getFirstName() {                      // геттер имени сотрудника
        return this.firstName;
    }

    public String getSecondName() {                      // геттер отчества сотрудника
        return this.secondName;
    }

    public String getLastName() {                      // геттер фамилии сотрудника
        return this.lastName;
    }

    public int getDepartment() {                      // геттер отдела сотрудника
        return this.department;
    }

    public int getSalary() {                            // геттер зарплаты сотрудника
        return this.salary;
    }

    @Override
    public String toString() {      // вывод всей информации о сотруднике
        return id + ": " + lastName + " " + firstName + " " + secondName + "; Отдел №" + department + "; Зарплата: " + salary;
    }

    public String toString(int department) {      // вывод всей информации о сотруднике
        return id + ": " + lastName + " " + firstName + " " + secondName + "; Зарплата: " + salary;
    }
}


