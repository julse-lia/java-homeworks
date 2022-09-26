package homework10;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;

public class UserToJsonConverter extends AbstractFile{
    private final File jsonFile = new File("src/main/java/homework10/user.json");

    public UserToJsonConverter(File file) {
        super(file);
    }

    public ArrayList<User> convertStringToUser(){
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.file)))
        {
            String line;
            // omit header
            br.readLine();
            while ((line = br.readLine()) != null) {
                users.add(new User(line.split(" ")[0], Integer.parseInt(line.split(" ")[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void convertUserToJson() {
        ArrayList<User> users = convertStringToUser();
        JSONArray jsonArray = new JSONArray();
        for(User user: users) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", user.getName());
            jsonObject.put("age", user.getAge());
            jsonArray.put(jsonObject);
        }
        try(FileWriter file = new FileWriter(jsonFile)) {
            jsonArray.write(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
