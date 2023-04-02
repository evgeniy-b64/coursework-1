package Employees_book;

public class Menu {
    //int menuItem;
    //int submenuItem;

    public static void viewMenu(int menuItem) {
        System.out.println("=====================");
        System.out.println("| Книга сотрудников |");
        System.out.println("=====================");
        System.out.println();
        System.out.println("Выберите действие:");
        switch (menuItem) {
            case 0:
                System.out.println("1 - Получить список всех сотрудников");
                System.out.println("2 - Посчитать сумму затрат на зарплаты");
                System.out.println("3 - Найти сотрудника с минимальной заплатой");
                System.out.println("4 - Найти сотрудника с максимальной зарплатой");
                System.out.println("5 - Подсчитать среднее значение зарплат");
                //System.out.println("0 - Завершить работу");
                System.out.println();
                break;
            case 1:
                System.out.println("1 - Получить список Ф.И.О. всех сотрудников");
                System.out.println("2 - Получить список сотрудников по отделам");
                System.out.println("3 - Добавить сотрудника");
                System.out.println("4 - Удалить сотрудника");
                System.out.println("5 - Изменить отдел");
                System.out.println("0 - Вернуться в предыдущее меню");
                System.out.println();
                break;
        }
    }
}
