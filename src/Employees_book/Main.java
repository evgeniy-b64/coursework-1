package Employees_book;

import java.util.Scanner;

import static Employees_book.Menu.viewMenu;

public class Main {
    public static int numberOfVacancies = 10;

    public static void main(String[] args) {
        viewMenu(0);
        EmployeeBook DPS = new EmployeeBook();      // создаём объект книги сотрудников (DPS = Dead Poets Society)
        DPS.initialiseBook(numberOfVacancies);      // инициализируем книгу сотрудников
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            switch (scanner.nextInt()) {
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
                    System.out.printf("Средняя зарплата = %.2f", DPS.findAverageSalary());
                    break;
            }
        }
        scanner.close();
    }
}