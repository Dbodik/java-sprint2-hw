import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class YearlyReport {
    HashMap<String, List<String>> yearlyReport  = new HashMap<>();;
    MonthlyReport monthlyReport = new MonthlyReport();

    FilesManager filesManager = new FilesManager();

    HashMap<String, List<String>> readYearlyReport(int year){
            String filesName = ("resources/y."+String.valueOf(year)+".csv");
            System.out.println(filesName);
            List<String> data = filesManager.readFileContents(filesName);
            yearlyReport.put(String.valueOf(year), data);
        return yearlyReport;
    }

    void reportPerYear(HashMap<String, List<String>> yearR, int year){
        int sumM = 0;
        int expenseM = 0;
        String prevMonth = "";
        System.out.println("Год "+ year);
        int sumOfMonth = 0;
        int sumExpenseOfMonth = 0;
        List<Integer> sumsMonth = new ArrayList<>();
        List<Integer> expensesMonth = new ArrayList<>();
        for (int i = 1;i<yearR.get(String.valueOf(year)).size(); i++){
            List<String> content = yearR.get(String.valueOf(year));
            String[] lineContent = content.get(i).split(",");
            if (!lineContent[0].equals(prevMonth)){
                if(lineContent[2].equals("false")){
                    sumOfMonth = Integer.parseInt(lineContent[1]);
                } else {
                    sumExpenseOfMonth = Integer.parseInt(lineContent[1]);
                }
            } else {
                if(lineContent[2].equals("false")){
                    sumOfMonth = Integer.parseInt(lineContent[1]);
                    int inPlus = sumOfMonth-sumExpenseOfMonth;
                    System.out.println("Прибыль за "+monthlyReport.monthsName(lineContent[0])+" месяц - "+inPlus);
                } else {
                    sumExpenseOfMonth = Integer.parseInt(lineContent[1]);
                    int inPlus = sumOfMonth-sumExpenseOfMonth;
                    System.out.println("Прибыль за "+monthlyReport.monthsName(lineContent[0])+" месяц - "+inPlus);
                }
                sumsMonth.add(sumOfMonth);
                expensesMonth.add(sumExpenseOfMonth);
            }
            prevMonth = lineContent[0];
        }
        for (Integer integer : sumsMonth) {
            sumM += integer;
        }
        System.out.println("Среднемесячный доход - "+sumM/sumsMonth.size());
        for (Integer integer : expensesMonth) {
            expenseM += integer;
        }
        System.out.println("Среднемесячный расход - "+expenseM/expensesMonth.size());
    }
}
