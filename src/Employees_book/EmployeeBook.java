package Employees_book;

public class EmployeeBook {
    private Employee[] storage;

    void initialiseBook(int employeeNumber) {       //инициализация книги
        storage = new Employee[employeeNumber];     //объявляем переменную для массива, создаём массив размера employeeNumber

        storage[0] = new Employee("Александр", "Сергеевич", "Пушкин", 1, 56000);
        storage[1] = new Employee("Михаил", "Юрьевич", "Лермонтов", 1, 55000);
        storage[2] = new Employee("Афанасий", "Афанасьевич", "Фет", 2, 44000);
        storage[3] = new Employee("Владимир", "Владимирович", "Маяковский", 3, 58000);
        storage[4] = new Employee("Сергей", "Александрович", "Есенин", 3, 54000);
        storage[5] = new Employee("Николай", "Алексеевич", "Заболоцкий", 4, 44000);
        storage[6] = new Employee("Анна", "Андреевна", "Ахматова", 5, 52000);
        storage[7] = new Employee("Марина", "Ивановна", "Цветаева", 5, 52000);
        storage[8] = new Employee("Иосиф", "Александрович", "Бродский", 5, 59000);
        storage[9] = new Employee("Борис", "Леонидович", "Пастернак", 5, 59000);
    }

    private int countEmployees() {    // считаем количество сотрудников в штате
        int employeesNumber = 0;
        for (Employee i : storage) {
            if (i != null) employeesNumber++;
        }
        return employeesNumber;
    }

    private int countDepartEmployees(int department) {    // считаем количество сотрудников в отделе
        int employeesInDepartment = 0;
        for (Employee i : storage) {
            if (i != null && i.getDepartment() == department) employeesInDepartment++;
        }
        return employeesInDepartment;
    }

    public void printBook() {       // задание 1.1 печать всей книги сотрудиков
        for (Employee i : storage) {
            if (i != null) System.out.println(i);
        }
    }

    public void printBook(int department) {       // задание 2.1 вывод данных сотрудиков отдела
        for (Employee i : storage) {
            if (i != null && i.getDepartment() == department) System.out.println(i.toString(department));
        }
    }

    public long countSalaryExpenses() {       // задание 1.2 подсчитать сумму затрат на зарплату всех сотрудиков
        long sum = 0;
        for (Employee i : storage) {
            if ( i != null) sum += i.getSalary();
        }
        return sum;
    }

    public long countDepartSalaryExpenses(int department) {       // задание 2.2 подсчитать сумму затрат на зарплату сотрудиков отдела
        long sum = 0;
        for (Employee i : storage) {
            if (i != null && i.getDepartment() == department) sum += i.getSalary();
        }
        return sum;
    }

    public void findBySalary(int salary) {   // вывод в консоль всех сотрудников с заданной зарплатой
        for (Employee i : storage) {
            if (i != null && i.getSalary() == salary) System.out.println(i);
        }
    }

    public void findMinSalary() {       // поиск размера наименьшей зарплаты
        int minSalary = storage[0].getSalary();
        for (Employee i : storage) {
            if (i != null && i.getSalary() < minSalary) minSalary = i.getSalary();
        }
        System.out.println("Наименьшая зарплата у сотрудников:");
        findBySalary(minSalary);
    }

    public void findMinSalary(int department) {       // поиск размера наименьшей зарплаты по отделу
        int minSalary = 0;
        for (Employee i : storage) {
            if (i != null && i.getDepartment() != department) continue;
            if (i != null && minSalary == 0 || i.getSalary() < minSalary) {
                minSalary = i.getSalary();
            }
        }
        System.out.println("Наименьшая зарплата у сотрудников:");
        findBySalary(minSalary);
    }

    public void findMaxSalary() {       // поиск значения наибольшей зарплаты
        int maxSalary = storage[0].getSalary();
        for (Employee i : storage) {
            if (i != null && i.getSalary() > maxSalary) maxSalary = i.getSalary();
        }
        System.out.println("Наибольшая зарплата у сотрудников:");
        findBySalary(maxSalary);
    }

    public void findMaxSalary(int department) {       // поиск значения наибольшей зарплаты по отделу
        int maxSalary = 0;
        for (Employee i : storage) {
            if (i != null && i.getDepartment() != department) continue;
            if (i != null && i.getSalary() > maxSalary) maxSalary = i.getSalary();
        }
        System.out.println("Наибольшая зарплата у сотрудников:");
        findBySalary(maxSalary);
    }

    public float findAverageSalary() {                  // вычисление средней зарплаты
        return (float) countSalaryExpenses() / countEmployees();
    }

    public float findAverageSalary(int department) {    // вычисление средней зарплаты по отделу
        return (float) countDepartSalaryExpenses(department) / countDepartEmployees(department);
    }

    public void raiseSalary(int department, int percent) {           // индексация зарплаты сотрудников отдела на указанный процент
        for (Employee i : storage) {
            if (i != null && i.getDepartment() != department) continue;
            if (i != null && percent > 0) i.setSalary(i.getSalary() + i.getSalary() * percent / 100);
        }
    }

    public void findAllBelow(int department, int value) {            // Найти сотрудников отдела с зарплатой ниже указанной
        for (Employee i : storage) {
            if (i != null && i.getDepartment() == department && i.getSalary() < value) System.out.println(i);
        }
    }

    public void findAllAbove(int department, int value) {            // Найти сотрудников отдела с зарплатой выше указанной
        for (Employee i : storage) {
            if (i != null && i.getDepartment() == department && i.getSalary() > value) System.out.println(i);
        }
    }

    public void addEmployee(String fName, String sName, String lName, int department, int salary) {
        boolean noVacancyFound = true;
        for (int i = 0; i < countEmployees(); i++) {
            if (storage[i] == null) {
                storage[i] = new Employee(fName, sName, lName, department, salary);
                System.out.printf("Добавлен сотрудник %s %s\n",fName, lName);
                noVacancyFound = false;
                break;
            }
        }
        if (noVacancyFound) System.out.println("Невозможно добавить сотрудника. Вакансии отсутствуют");
    }

    public void deleteEmployee(int id){
        for (int i = 0; i < countEmployees(); i++)
         {
            if (storage[i] != null && storage[i].id == id) {
                System.out.printf("Сотрудник %s %s удалён \n",storage[i].getFirstName(), storage[i].getLastName());
                storage[i] = null;
                break;
            }
        }
    }
}
