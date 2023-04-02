package Employees_book;

public class EmployeeBook {
    private Employee[] storage;
    private static int idCounter = 0;
    private int id = 0;
    private static int employeesNumber = 0;

    void initialiseBook(int employeeNumber) {       //инициализация книги
        storage = new Employee[employeeNumber];     //объявляем переменную для массива, создаём массив размера employeeNumber
        for (int i = 0; i < employeeNumber; i++) {
            storage[i] = new Employee();            //создаём в цикле пустые объекты "сотрудников"
            idCounter++;
            storage[i].setID(idCounter);
        }
        storage[0].setInfo("Александр", "Сергеевич", "Пушкин", "1-й Отдел", 56000);
        storage[1].setInfo("Михаил", "Юрьевич", "Лермонтов", "1-й Отдел", 55000);
        storage[2].setInfo("Афанасий", "Афанасьевич", "Фет", "2-й Отдел", 44000);
        storage[3].setInfo("Владимир", "Владимирович", "Маяковский", "3-й Отдел", 58000);
        storage[4].setInfo("Сергей", "Александрович", "Есенин", "3-й Отдел", 54000);
        storage[5].setInfo("Николай", "Алексеевич", "Заболоцкий", "4-й Отдел", 44000);
        storage[6].setInfo("Анна", "Андреевна", "Ахматова", "5-й Отдел", 53000);
        storage[7].setInfo("Марина", "Ивановна", "Цветаева", "5-й Отдел", 52000);
        storage[8].setInfo("Иосиф", "Александрович", "Бродский", "5-й Отдел", 59000);
        storage[9].setInfo("Борис", "Леонидович", "Пастернак", "5-й Отдел", 59000);
        countAllEmployees();    // считаем, сколько в штате сотрудников
    }

    private void countAllEmployees(){    // считаем, сколько в штате сотрудников
        for (Employee i : storage) {
            if (i.getFirstName() != null) employeesNumber++;
        }
    }

    public void printBook() {       // задание 1.1 печать всей книги сотрудиков
        for (Employee i : storage) {
            System.out.println(i.toString());
        }
    }

    public long countSalaryExpenses() {       // задание 1.2 подсчитать сумму затрат на зарплату всех сотрудиков
        long sum = 0;
        for (Employee i : storage) {
            sum += i.getSalary();
        }
        return sum;
    }
    public void findBySalary(int salary){   // вывод в консоль всех сотрудников с заданной зарплатой
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
    public void findMaxSalary() {       // поиск значения наибольшей зарплаты
        int maxSalary = storage[0].getSalary();
        for (Employee i : storage) {
            if (i.getSalary() > maxSalary) maxSalary = i.getSalary();
        }
        System.out.println("Наибольшая зарплата у сотрудников:");
        findBySalary(maxSalary);
    }

    public float findAverageSalary() {
        return  (float) countSalaryExpenses()/employeesNumber;
    }
}
