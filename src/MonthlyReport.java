import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MonthlyReport {
    HashMap<Integer, List<String>> monthlyReport  = new HashMap<>();;

    FilesManager filesManager = new FilesManager();

    HashMap<Integer, List<String>> readMonthlyReport(int monthsCount){
        for (int i = 1; i<monthsCount+1; i++){
            String filesName = ("resources/m.20210"+i+".csv");
            System.out.println(filesName);
            List<String> data = filesManager.readFileContents(filesName);
            monthlyReport.put(i, data);
        }
        return monthlyReport;
    }

        List<Integer> monthSum(HashMap<Integer, List<String>> month,int monthNumber){
        HashMap<Integer, List<Integer>> expensesMap = new HashMap<>();
        int sumTrue = 0;
        int sumFalse = 0;
        List<Integer> sumList = new ArrayList<>();
        List<String> expenses = month.get(monthNumber);
        for (int i = 1; i<expenses.size();i++){
            String[] lineContents = expenses.get(i).split(",");
                if (lineContents[1].equals("TRUE")) {
                    sumTrue += Integer.parseInt(lineContents[2]) * Integer.parseInt(lineContents[3]);
                } else {
                    sumFalse += Integer.parseInt(lineContents[2]) * Integer.parseInt(lineContents[3]);
                }
        }
        sumList.add(sumTrue);
        sumList.add(sumFalse);
        return sumList;
        }
    }

