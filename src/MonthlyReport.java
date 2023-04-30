import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MonthlyReport {
    HashMap<String, List<String>> monthlyReport  = new HashMap<>();;

    FilesManager filesManager = new FilesManager();

    HashMap<String, List<String>> readMonthlyReport(int monthsCount){
        for (int i = 1; i<monthsCount+1; i++){
            String filesName = ("resources/m.20210"+i+".csv");
            List<String> data = filesManager.readFileContents(filesName);
            monthlyReport.put("0" +Integer.toString(i), data);
        }
        return monthlyReport;
    }

        List<Integer> monthSum(HashMap<String, List<String>> month,String monthNumber){
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
    void monthVsYearReport(HashMap<String, List<String>> yReport, HashMap<String, List<Integer>> sumPerMonth){
        List<String> expenses = yReport.get("2021");
        int marker = 0;
        for(int i = 1; i<expenses.size(); i++){
            String[] lineContent = expenses.get(i).split(",");
            List<Integer> sumList = sumPerMonth.get(lineContent[0]);
            if (lineContent[2].equals("true")){
                if (Integer.parseInt(lineContent[1])!= sumList.get(0)){
                    marker = 1;
                    System.out.println("Обнаружено неоответствие расход за "+monthsName(lineContent[0])+" месяц");
                }
            } else{
                if (Integer.parseInt(lineContent[1])!= sumList.get(1)){
                    marker = 1;
                    System.out.println("Обнаружено неоответствие доходов за "+monthsName(lineContent[0])+" месяц");
                }
            }
        }
        if (marker == 0) {
            System.out.println("Сверка отчетов завершена. Ошибок не обнаружено.");
        }
    }
    String monthsName(String monthNumber){
        if (monthNumber.equals("01")){
            return "Январь";
        }else if (monthNumber.equals("02")){
            return "Февраль";
        } else if(monthNumber.equals("03")){
            return "Март";
        }else{
            return "Месяц не добавлен в программу, ввведите месяц от 1 до 3";
        }
    }

    void reportPerMonth(HashMap<String, List<String>> months){
        int count = 1;
        for (List<String> expenses : months.values()){
            String monthName = "0";
            int maxSum = 0;
            int maxExpense = 0;
            String forMonthName = String.valueOf(count);
            String nameOfExpense = "";
            String nameOfSum = "";
            for (int i = 1; i<expenses.size();i++) {
                String[] lineContent = expenses.get(i).split(",");
                if(lineContent[1].equals("FALSE")){
                    if (maxSum<(Integer.parseInt(lineContent[2])*Integer.parseInt(lineContent[3]))){
                        maxSum = Integer.parseInt(lineContent[2])*Integer.parseInt(lineContent[3]);
                        nameOfSum = lineContent[0];
                    }
                }else {
                    if (maxExpense<(Integer.parseInt(lineContent[2])*Integer.parseInt(lineContent[3]))){
                        maxExpense = Integer.parseInt(lineContent[2])*Integer.parseInt(lineContent[3]);
                        nameOfExpense = lineContent[0];
                    }
                }
            }
            System.out.println("Максимальная сумма дохода - "+maxSum+" за "+monthsName(monthName+forMonthName)+" месяц в категории "+nameOfSum);
            System.out.println("Максимальная трата - "+maxExpense+" за "+monthsName(monthName+forMonthName)+" месяц в категории "+nameOfExpense);
            count++;
        }

    }

    }

