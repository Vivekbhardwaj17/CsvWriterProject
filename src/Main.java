import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> dataLines = new ArrayList<>();
        List<String[]> dataLinesArr = new ArrayList<String[]>();

        // need to populate data at run time here mentioned static data for test
        List<String> data1 = new ArrayList<String>();
        data1.add("abc");
        data1.add("def");
        dataLines.add(data1);
        List<String> data2 = new ArrayList<String>();
        data2.add("ABC");
        data2.add("DEF");

        // to convert list of list to list of string array
        for (List<String>  list: dataLines) {
            String[] arr = list.toArray(new String[list.size()]);
            dataLinesArr.add(arr);
        }
        CsvWriteClassUtil.writeToCSVArr(dataLinesArr);
    }
}