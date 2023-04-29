import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        HashMap<Integer, List<String>> mReport = null;
        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 1) {
            mReport = monthlyReport.readMonthlyReport(3);
                System.out.println(mReport);
            } else if (command == 2) {
                HashMap<String, List<String>> yReport = yearlyReport.readYearlyReport();
                System.out.println(yReport);
            } else if (command == 3) {
                if(mReport!= null){
                    HashMap<Integer, List<Integer>> sumPerMonth = new HashMap<>();
                    for (int i = 1; i<4; i++){
                        sumPerMonth.put(i, monthlyReport.monthSum(mReport,i));

                    }
                    System.out.println(sumPerMonth);

                }
            } else if (command == 4) {

            } else if (command == 5) {

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


