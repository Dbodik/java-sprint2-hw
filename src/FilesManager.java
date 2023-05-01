import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FilesManager {
    MonthlyReport monthlyReport = new MonthlyReport();
    YearlyReport yearlyReport = new YearlyReport();
    HashMap<String, List<String>> mReport = null;
    HashMap<String, List<String>> yReport = null;



    void command1(){
        mReport = monthlyReport.readMonthlyReport(3);
    }
    void command2(){
        yReport = yearlyReport.readYearlyReport(2021);
    }
    void command3(){
        if(mReport!= null&& yReport!=null){
            HashMap<String, List<Integer>> sumPerMonth = new HashMap<>();
            for (int i = 1; i<4; i++){
                String month = Integer.toString(i);
                String monthNumber = "0"+month;
                sumPerMonth.put(monthNumber, monthlyReport.monthSum(mReport,monthNumber));
            }
            System.out.println(sumPerMonth);
            monthlyReport.monthVsYearReport(yReport, sumPerMonth);
        } else if (mReport== null && yReport == null){
            System.out.println("Месячные и годовой отчет не загружены, считайте отчеты");
        } else if(mReport==null){
            System.out.println("Месячные отчеты не загружены, пожалуйста считайте месячные отчеты");
        } else {
            System.out.println("Годовой отчет не загружен, пожалуйста считайте годовой отчет");
        }
    }
    void command4(){
        if(mReport!= null) {
            monthlyReport.reportPerMonth(mReport);
        } else {
            System.out.println("Месячные отчеты не загружены, пожалуйста считайте месячные отчеты");
        }
    }
    void command5(){
        if (yReport!=null){
            yearlyReport.reportPerYear(yReport,2021);
        }else {
            System.out.println("Годовой отчет не загружен, пожалуйста считайте месячный отчет");
        }
    }




}
