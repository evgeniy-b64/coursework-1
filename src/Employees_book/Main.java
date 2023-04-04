package Employees_book;

import java.util.Scanner;

import static Employees_book.Menu.*;

public class Main {
    public static int numberOfVacancies = 10;
    static int currentMenu = 1;                         // текущее меню
    public static EmployeeBook poets = new EmployeeBook();      // создаём объект книги сотрудников

    public static void main(String[] args) {
        System.out.println("=====================");
        System.out.println("| Книга сотрудников |");
        System.out.println("=====================");
        poets.initialiseBook(numberOfVacancies);      // инициализируем книгу сотрудников
        viewMenu(currentMenu);
        boolean quit = false;                       // маркер выхода из программы
        Scanner scanner = new Scanner(System.in);
        do {
            if (scanner.hasNextInt()) {
                int menuItem = scanner.nextInt();
                switch (currentMenu * 10 + menuItem) {
                    case 11:
                    case 12:
                        currentMenu = currentMenu * 10 + menuItem;
                        break;
                    case 13: // добавить сотрудника
                        poets.addEmployee("Александр", "Александрович", "Блок", 3, 53000);
                        break;
                    case 14: // удалить сотрудника
                        poets.deleteEmployee(4);
                        break;
                    case 15: // изменить данные сотрудника
                        break;
                    //-------------------------------------
                    case 111: // задание 1.1 - получить список всех сотрудников со всеми данными
                        poets.printBook();
                        break;
                    case 112: // задание 1.2 подсчитать сумму затрат на зарплату всех сотрудиков
                        System.out.println("Сумма затрат на зарплату = " + poets.countSalaryExpenses());
                        break;
                    case 113: // задание 1.3 найти сотрудников с маименьшей зарплатой
                        poets.findMinSalary();
                        break;
                    case 114: // задание 1.4 найти сотрудников с маибольшей зарплатой
                        poets.findMaxSalary();
                        break;
                    case 115: // задание 1.5 найти среднее значение зарплаты
                        System.out.printf("Средняя зарплата = %.2f \n", poets.findAverageSalary());
                        break;
                    //-------------------------------------
                    case 121: // задание 2.1 - получить список всех сотрудников отдела
                        /*System.out.println("Выберите отдел:");
                        poets.printBook(readKey());*/
                        System.out.println("Список сотрудников 5 отдела:");
                        poets.printBook(5);
                        break;
                    case 122: // задание 2.2 подсчитать сумму затрат на зарплату сотрудиков отдела
                        System.out.println("Сумма затрат на зарплату = " + poets.countDepartSalaryExpenses(5));
                        break;
                    case 123: // задание 2.3 найти сотрудников отдела с маименьшей зарплатой
                        poets.findMinSalary(5);
                        break;
                    case 124: // задание 2.4 найти сотрудников отдела с маибольшей зарплатой
                        poets.findMaxSalary(5);
                        break;
                    case 125: // задание 2.5 найти среднее значение зарплаты по отделу
                        System.out.printf("Средняя зарплата = %.2f \n", poets.findAverageSalary(5));
                        break;
                    case 126: // задание 2.6 Проиндексировать зарплату сотрудников отдела
                        System.out.printf("Зарплаты %s отдела проиндексированы на %s\n",5, 15);
                        poets.raiseSalary(5,15);
                        break;
                    case 127: // задание 2.7 Найти сотрудников отдела с з/п ниже указанной
                        System.out.printf("Сотрудники с зарплатой ниже %s:\n",55000);
                        poets.findAllBelow(5,55000);
                        break;
                    case 128: // задание 2.8 Найти сотрудников отдела с з/п выше указанной
                        System.out.printf("Сотрудники с зарплатой выше %s:\n",55000);
                        poets.findAllAbove(5,55000);
                        break;
                    //-------------------------------------
                    case 110:
                    case 120:   // возврат в предыдущее меню
                        currentMenu = currentMenu / 10;
                        break;
                    case 10:     // выход из программы
                        quit = true;
                        break;
                }
            }
            if (!quit) viewMenu(currentMenu);
        } while (!quit);
        scanner.close();
    }
}