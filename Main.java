import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        File file = new File("file1.txt");

        Pattern pattern1 = Pattern.compile("^\\W\\d{3}\\W\\s\\d{3}\\W\\d{3}$");
        Pattern pattern2 = Pattern.compile("^\\d{3}\\W\\d{3}\\W\\d{4}");
        try {
            FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);
            while(scanner.hasNext()){
                String fileLine = scanner.nextLine();
                Matcher matcher1 = pattern1.matcher(fileLine);
                Matcher matcher2 = pattern2.matcher(fileLine);
                if (matcher1.find()){
                    System.out.println(fileLine);
                }else if(matcher2.find()){
                    System.out.println(fileLine);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
