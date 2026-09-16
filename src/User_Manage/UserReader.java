package User_Manage;

import Registration.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class UserReader {

    private static final String FileName = "Users.txt";

    public static List<User> readUsers() {

        List<User> users = new ArrayList<>();

        File file = new File(FileName);

        if (!file.exists()) {
            return users;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length == 7) {

                    User user = new User(
                            data[0],
                            data[1],
                            data[2],
                            data[4],
                            data[3],
                            data[5],
                            data[6]
                    );

                    users.add(user);
                }
            }

        } catch (Exception e) {

            System.out.println("Error reading users: " + e.getMessage());
        }

        return users;
    }
}
