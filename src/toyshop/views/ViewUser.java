package toyshop.views;

import java.util.ArrayList;
import java.util.Scanner;
import toyshop.controllers.Controller;
import toyshop.model.Toy;

public class ViewUser {
    private Controller controller;

    public ViewUser(Controller controller) {
        this.controller = controller;
    }

    public int userMenu() {
        System.out.println("Введите номер команды:");
        System.out.println("1 - добавить игрушку в список разыгрываемых игрушек");
        System.out.println("2 - вывести список всех разыгрываемых игрушек");
        System.out.println("3 - изменить вес (частоту выпадения) игрушки");
        System.out.println("4 - провести розыгрыш одной игрушки");
        System.out.println("5 - провести серию розыгрышей");
        System.out.println("6 - вывести список всех разыгранных и не выданных игрушек");
        System.out.println("7- вывести список всех выданных игрушек");
        System.out.println("8 - выход");
        try {
            int choise = Integer.parseInt(prompt("Ваш выбор: "));
            return choise;
        } catch (Exception e) {
            System.out.println("Введено некорректное значение! Программа прекращает свою работу!");
        }
        return 8;
    }

    public void run() {
        while (true) {
            int command = userMenu();

            if (command <= 0 || command > 8) {
                System.out.println("Такой команды нет! Попробуйте еще раз!");
            }

            if (command == 1) { // Добавить игрушку в список разыгрываемых игрушек
                System.out.println("Добавляем новую игрушку:");
                String name = prompt("Название: ");
                int count = Integer.parseInt(prompt("Количество: "));
                int drop = Integer.parseInt(prompt("Частота выпадения (вес в % от 100): "));
                if (drop < 0 || drop > 100) {
                    System.out.println("Частота выпадения должна быть в диапазоне от 0% до 100%!");
                    break;
                }
                controller.saveToy(new Toy(name, count, drop));
                System.out.println("Игрушка добавлена!");
            }

            if (command == 2) { // Вывести список всех разыгрываемых игрушек
                System.out.println("На данный момент для розыгрыша доступны следующие игрушки:");
                ArrayList<Toy> toys = controller.readToyList();
                toys.forEach(i -> System.out.println(i));
            }

            if (command == 3) { // Изменить вес (частоту выпадения) игрушки
                int idToy = Integer.parseInt(prompt("Введите id игрушки: "));
                int dropToy = Integer.parseInt(prompt("Введите новый вес игрушки (в % от 100): "));
                boolean flag = controller.changeToyDrop(idToy, dropToy);
                if (!flag) {
                    System.out.println("Нет игрушки с таким id!");
                } else {
                    System.out.println("Вес (частота выпадения) игрушки обновлена!");
                }
            }

            if (command == 4) { // Провести розыгрыш одной игрушки
                Toy lot = controller.lotToy();
                System.out.println("Розыгрыш проведен! Разыграна игрушка:");
                System.out.println(lot);
            }

            if (command == 8) {
                System.out.println("До свидания!");
                return;
            }

//            try {
//                switch (command) {
//                    case ADDTOY:
//                        System.out.println("Добавляем новую игрушку:");
//                        String name = prompt("Название: ");
//                        int count = Integer.parseInt(prompt("Количество: "));
//                        int drop = Integer.parseInt(prompt("Частота выпадения (вес в % от 100): "));
//                        if (drop < 0 || drop > 100) {
//                            System.out.println("Частота выпадения должна быть в диапазоне от 0% до 100%!");
//                            break;
//                        }
//                        controller.saveToy(new Toy(name, count, drop));
//                        System.out.println("Игрушка добавлена!");
//                        break;
//                    case CHANGEDROP:
//                        System.out.println("Вывести на экран список всех готовых к розыгрышу игрушек? (/N)");
//                        String name = prompt("Название: ");
//                        int count = Integer.parseInt(prompt("Количество: "));
//                        int drop = Integer.parseInt(prompt("Частота выпадения (вес в % от 100): "));
//                        if (drop < 0 || drop > 100) {
//                            System.out.println("Частота выпадения должна быть в диапазоне от 0% до 100%!");
//                            break;
//                        }
//                        controller.saveToy(new Toy(name, count, drop));
//                        System.out.println("Игрушка добавлена!");
//                        break;
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
        }
    }

    private String prompt(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.print(message);
        return scan.nextLine();
    }
}
