import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CsvWriteClassUtil {

    public static String convertToCSVArr(String[] data) {
        return Stream.of(data)
                .map( data1 -> escapeSpecialCharacters(String.valueOf(data1)))
                .collect(Collectors.joining(","));
    }

    //method to remove unwanted special character if added somehow in data
    public static String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
    //method for writing csv file
    public static void writeToCSVArr(List<String[]> dataLines) {
        try {
            // here mention csv file location
            File csvOutputFile = new File("./mycsvFileArr.csv");
            try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
                dataLines.stream()
                        .map( data -> convertToCSVArr(data))
                        .forEach(pw::println);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
