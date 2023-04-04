package Employees_book;

//import java.util.Scanner;

public class Menu {

    public static void viewMenu(int menu) {
        System.out.println("\nВыберите действие:");
        switch (menu) {
            case 1:
                System.out.println("1 - Все сотрудники");
                System.out.println("2 - Сотрудники по отделам");
                System.out.println("3 - Добавить сотрудника");
                System.out.println("4 - Удалить сотрудника");
                //System.out.println("5 - Изменить данные сотрудника");
                System.out.println("0 - Завершить работу");
                break;
            case 11:
                System.out.println("1 - Получить список всех сотрудников");
                System.out.println("2 - Подсчитать сумму затрат на зарплаты");
                System.out.println("3 - Найти сотрудника с минимальной заплатой");
                System.out.println("4 - Найти сотрудника с максимальной зарплатой");
                System.out.println("5 - Подсчитать среднюю зарплату");
                System.out.println("0 - Вернуться в предыдущее меню");
                System.out.println();
                break;
            case 12:
                System.out.println("1 - Получить список сотрудников отдела");
                System.out.println("2 - Подсчитать сумму затрат на зарплаты отдела");
                System.out.println("3 - Найти сотрудника с минимальной заплатой в отделе");
                System.out.println("4 - Найти сотрудника с максимальной зарплатой в отделе");
                System.out.println("5 - Подсчитать среднюю зарплату в отделе");
                System.out.println("6 - Проиндексировать зарплату сотрудников отдела");
                System.out.println("7 - Найти сотрудников отдела с зарплатой ниже указанной");
                System.out.println("8 - Найти сотрудников отдела с зарплатой выше указанной");
                System.out.println("0 - Вернуться в предыдущее меню");
                System.out.println();
                break;
        }
    }
}
