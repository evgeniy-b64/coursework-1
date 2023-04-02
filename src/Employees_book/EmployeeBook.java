package Employees_book;

public class EmployeeBook {
    private Employee[] storage;
    private static int idCounter = 0;
    //private int id = 0;
    //private static int employeesNumber = 0;

    void initialiseBook(int employeeNumber) {       //инициализация книги
        storage = new Employee[employeeNumber];     //объявляем переменную для массива, создаём массив размера employeeNumber
        for (int i = 0; i < employeeNumber; i++) {
            storage[i] = new Employee();            //создаём в цикле пустые объекты "сотрудников"
            idCounter++;
            storage[i].setID(idCounter);
        }
        storage[0].setInfo("Александр", "Сергеевич", "Пушкин", 1, 56000);
        storage[1].setInfo("Михаил", "Юрьевич", "Лермонтов", 1, 55000);
        storage[2].setInfo("Афанасий", "Афанасьевич", "Фет", 2, 44000);
        storage[3].setInfo("Владимир", "Владимирович", "Маяковский", 3, 58000);
        storage[4].setInfo("Сергей", "Александрович", "Есенин", 3, 54000);
        storage[5].setInfo("Николай", "Алексеевич", "Заболоцкий", 4, 44000);
        storage[6].setInfo("Анна", "Андреевна", "Ахматова", 5, 52000);
        storage[7].setInfo("Марина", "Ивановна", "Цветаева", 5, 52000);
        storage[8].setInfo("Иосиф", "Александрович", "Бродский", 5, 59000);
        storage[9].setInfo("Борис", "Леонидович", "Пастернак", 5, 59000);
    }

    private int countEmployees() {    // считаем количество сотрудников в штате
        int employeesNumber = 0;
        for (Employee i : storage) {
            if (i != null) employeesNumber++;
        }
        return employeesNumber;
    }

    private int countEmployees(int department) {    // считаем, сколько сотрудников в отделе
        int employeesInDepartment = 0;
        for (Employee i : storage) {
            if (i.getDepartment() == department) employeesInDepartment++;
        }
        return employeesInDepartment;
    }

    public void printBook() {       // задание 1.1 печать всей книги сотрудиков
        for (Employee i : storage) {
            System.out.println(i.toString());
        }
    }

    public void printBook(int department) {       // задание 2.1 вывод данных сотрудиков отдела
        for (Employee i : storage) {
            if (i.getDepartment() == department) System.out.println(i.toString(department));
        }
    }

    public long countSalaryExpenses() {       // задание 1.2 подсчитать сумму затрат на зарплату всех сотрудиков
        long sum = 0;
        for (Employee i : storage) {
            sum += i.getSalary();
        }
        return sum;
    }

    public long countSalaryExpenses(int department) {       // задание 2.2 подсчитать сумму затрат на зарплату всех сотрудиков отдела
        long sum = 0;
        for (Employee i : storage) {
            if (i.getDepartment() == department) sum += i.getSalary();
        }
        return sum;
    }

    public void findBySalary(int salary) {   // вывод в консоль всех сотрудников с заданной зарплатой
        for (Employee i : storage) {
            if (i.getSalary() == salary) System.out.println(i);
        }
    }

    public void findMinSalary() {       // поиск размера наименьшей зарплаты
        int minSalary = storage[0].getSalary();
        for (Employee i : storage) {
            if (i.getSalary() < minSalary) minSalary = i.getSalary();
        }
        System.out.println("Наименьшая зарплата у сотрудников:");
        findBySalary(minSalary);
    }

    public void findMinSalary(int department) {       // поиск размера наименьшей зарплаты по отделу
        int minSalary = 0;
        for (Employee i : storage) {
            if (i.getDepartment() != department) continue;
            if (minSalary == 0 || i.getSalary() < minSalary) {
                minSalary = i.getSalary();
            }
        }
        System.out.println("Наименьшая зарплата у сотрудников:");
        findBySalary(minSalary);
    }

    public void findMaxSalary() {       // поиск значения наибольшей зарплаты
        int maxSalary = storage[0].getSalary();
        for (Employee i : storage) {
            if (i.getSalary() > maxSalary) maxSalary = i.getSalary();
        }
        System.out.println("Наибольшая зарплата у сотрудников:");
        findBySalary(maxSalary);
    }

    public void findMaxSalary(int department) {       // поиск значения наибольшей зарплаты по отделу
        int maxSalary = 0;
        for (Employee i : storage) {
            if (i.getDepartment() != department) continue;
            if (i.getSalary() > maxSalary) maxSalary = i.getSalary();
        }
        System.out.println("Наибольшая зарплата у сотрудников:");
        findBySalary(maxSalary);
    }

    public float findAverageSalary() {                  // вычисление средней зарплаты
        return (float) countSalaryExpenses() / countEmployees();
    }

    public float findAverageSalary(int department) {    // вычисление средней зарплаты по отделу
        return (float) countSalaryExpenses(department) / countEmployees(department);
    }

    public void raiseSalary (int department, int percent){           // индексация зарплаты сотрудников отдела на указанный процент
        for (Employee i : storage) {
            if (i.getDepartment() != department) continue;
            if (percent > 0 ) i.setSalary(i.getSalary() + i.getSalary()* percent/100);
        }
    }
    public void findAllBelow(int department, int value){            // Найти сотрудников отдела с зарплатой ниже указанной
        for (Employee i : storage) {
            if (i.getDepartment() == department && i.getSalary() < value) System.out.println(i);
        }
    }
    public void findAllAbove(int department, int value){            // Найти сотрудников отдела с зарплатой выше указанной
        for (Employee i : storage) {
            if (i.getDepartment() == department && i.getSalary() > value) System.out.println(i);
        }
    }
}
