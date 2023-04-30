import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        HashMap<String, List<String>> mReport = null;
        HashMap<String, List<String>> yReport = null;
        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 1) {
            mReport = monthlyReport.readMonthlyReport(3);
                System.out.println(mReport);
            } else if (command == 2) {
                yReport = yearlyReport.readYearlyReport(2021);
                System.out.println(yReport);
            } else if (command == 3) {
                System.out.println(yReport);
                if(mReport!= null&& yReport!=null){
                    HashMap<String, List<Integer>> sumPerMonth = new HashMap<>();
                    for (int i = 1; i<4; i++){
                        String month = Integer.toString(i);
                        String monthNumber = "0"+month;
                        sumPerMonth.put(monthNumber, monthlyReport.monthSum(mReport,monthNumber));
                    }
                    System.out.println(sumPerMonth);
                        monthlyReport.monthVsYearReport(yReport, sumPerMonth);
                }
            } else if (command == 4) {
                if(mReport!= null) {
                    monthlyReport.reportPerMonth(mReport);
                }
            } else if (command == 5) {
                if (yReport!=null){
                    yearlyReport.reportPerYear(yReport,2021);
                }
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


