package homework10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator extends AbstractFile{

    private Pattern pattern = Pattern.compile("\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}|[0-9]{3}-[0-9]{3}-[0-9]{4}");

    public NumberValidator(File file) {
        super(file);
    }

    public void validate(){

        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()){
                    System.out.println(line.substring(matcher.start(), matcher.end()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
