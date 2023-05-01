
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        FilesManager filesManager = new FilesManager();
        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 1) {
                filesManager.command1();
                System.out.println("Месячный отчет считан");
            } else if (command == 2) {
                filesManager.command2();
                System.out.println("Годовой отчет считан");
            } else if (command == 3) {
                filesManager.command3();
            } else if (command == 4) {
                filesManager.command4();
            } else if (command == 5) {
                filesManager.command5();
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Такой команды нет. Выберите команду от 1 до 5");
            }
        }

    }


    static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчеты");
        System.out.println("2 - Считать годовой очет");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}


