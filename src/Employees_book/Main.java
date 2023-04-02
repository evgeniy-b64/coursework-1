package Employees_book;

import java.util.Scanner;

import static Employees_book.Menu.viewMenu;

public class Main {
    public static int numberOfVacancies = 10;
    static byte currentMenu = 0;                   // текущее отображаемое меню
    public static EmployeeBook DPS = new EmployeeBook();      // создаём объект книги сотрудников (DPS = Dead Poets Society)

    public static void main(String[] args) {
        System.out.println("=====================");
        System.out.println("| Книга сотрудников |");
        System.out.println("=====================");
        viewMenu(currentMenu);
        DPS.initialiseBook(numberOfVacancies);      // инициализируем книгу сотрудников
        Scanner scanner = new Scanner(System.in);
        int userAction = 0;                         // переменная для хранения пункта, выбранного пользователем
        do {
            if (scanner.hasNextInt()) {
                userAction = scanner.nextInt();
                switch (userAction) {
                    case 1: // задание 1.1 - получить список всех сотрудников со всеми данными
                        DPS.printBook();
                        break;
                    case 2: // задание 1.2 подсчитать сумму затрат на зарплату всех сотрудиков
                        System.out.println("Сумма затрат на зарплату = " + DPS.countSalaryExpenses());
                        break;
                    case 3: // задание 1.3 найти сотрудников с маименьшей зарплатой
                        DPS.findMinSalary();
                        break;
                    case 4: // задание 1.4 найти сотрудников с маибольшей зарплатой
                        DPS.findMaxSalary();
                        break;
                    case 5: // задание 1.5 найти среднее значение зарплаты
                        System.out.printf("Средняя зарплата = %.2f \n", DPS.findAverageSalary());
                        break;
                }
            }
            if (userAction != 0 ) viewMenu(currentMenu);
        } while (userAction != 0);
        scanner.close();
    }
}