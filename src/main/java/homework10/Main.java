package homework10;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Find valid phone numbers
        File file = new File("src/main/java/homework10/file.txt");
        NumberValidator numberValidator = new NumberValidator(file);
        numberValidator.validate();

        // Convert user objects into json
        System.out.println();
        File file1 = new File("src/main/java/homework10/file2.txt");
        UserToJsonConverter converter = new UserToJsonConverter(file1);
        converter.convertUserToJson();

        // Count frequency of each word
        System.out.println();
        File file2 = new File("src/main/java/homework10/words.txt");
        WordCounter counter = new WordCounter(file2);
        counter.countWords();

    }
}
