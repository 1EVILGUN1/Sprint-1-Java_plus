import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вас приветствует список покупок!");// start programm
        int productCount = 0;
        String[] shoppingList = new String[8];
        while (true) {
            // user selection of commands
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");
            int actionNumber = scanner.nextInt();


            if (actionNumber == 1) {//the user chose to add products to the list
                System.out.println("Введите название продукта в список покупок с большой буквы");
                System.out.println("В название где есть пробелы необходимо закрывать _");
                String nameProduct = scanner.next();
                if (productCount < 8) {//checking for the amount of space in the list
                    shoppingList[productCount] = nameProduct;
                    System.out.println("Вы ввели " + nameProduct + ". И он помещен в №" + (productCount + 1) + " по списку.");
                    productCount++;
                } else {//we warn the user that the list has run out of space
                    System.out.println("В списке закончились свободные номера");

                    while (true) {//suggest the user to clear the list
                        System.out.println("Желаете очистить список? да/нет");
                        String clearList = scanner.next();
                        if (clearList.equals("да")) {
                            for (int i = 0; i <= shoppingList.length - 1; i++) {
                                shoppingList[i] = null;
                            }
                            productCount = 0;
                            System.out.println("Список успешно очищен");
                            break;
                        } else if (clearList.equals("нет")) {
                            break;
                        } else {
                            System.out.println("Вы ввели не корректный запрос. ");
                            System.out.println("Пожалуйста повторите попытку. ");
                        }
                    }
                }

            } else if (actionNumber == 2) {// show the user what is in the list
                System.out.println("В списке: ");

                for (int i = 0; i <= shoppingList.length - 1; i++) {
                    if (shoppingList[i] != null) {
                        System.out.println("№" + (i + 1) + " - " + shoppingList[i]);
                    } else if (shoppingList[i] == null) {
                        if (i == 0) {// if the list is empty for some reason
                            System.out.println("Пока ничего не добавлено:(");
                        }
                    }
                }
            } else if (actionNumber == 3) {// allow the user to delete the list
                System.out.println("Вы уверены, что желаете удалить список? да/нет");
                String deleteList = scanner.next();
                while (true) {
                    if (deleteList.equals("да")) {
                        if (shoppingList[0] == null) {
                            System.out.println("Список пуст");
                            break;
                        }
                        for (int i = 0; i <= shoppingList.length - 1; i++) {
                            shoppingList[i] = null;
                        }
                        productCount = 0;
                        System.out.println("Список успешно очищен");
                    } else if (deleteList.equals("нет")) {
                        break;
                    } else {
                        System.out.println("Вы ввели не корректный запрос. ");
                        System.out.println("Пожалуйста повторите попытку. ");
                    }
                }

            } else if (actionNumber == 4) {// completion of the program
                System.out.println("Завершение работы программы.");
                break;
            } else {//
                System.out.println("Неизвестная команда!");
            }
        }
    }
}
