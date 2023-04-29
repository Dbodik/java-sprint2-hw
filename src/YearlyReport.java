import java.util.HashMap;
import java.util.List;

public class YearlyReport {
    HashMap<String, List<String>> yearlyReport  = new HashMap<>();;

    FilesManager filesManager = new FilesManager();

    HashMap<String, List<String>> readYearlyReport(){
            String filesName = ("resources/y.2021.csv");
            System.out.println(filesName);
            List<String> data = filesManager.readFileContents(filesName);
            yearlyReport.put(filesName, data);
        return yearlyReport;
    }
}
