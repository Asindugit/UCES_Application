package Registration;

import java.io.*;
import java.util.HashMap;

public class UserManager {

    private static final String FileName = "Users.txt";

    // Save one user details to file -------------------------------------------
    public static boolean saveUser(User user) {

        try (BufferedWriter writer
                = new BufferedWriter(new FileWriter(FileName, true))) {

            writer.write(
                    user.getUserID() + ","
                    + user.getName() + ","
                    + user.getGender() + ","
                    + user.getContact() + ","
                    + user.getType() + ","
                    + user.getUsername() + ","
                    + user.getPassword());

            writer.newLine();

            return true;

        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
            return false;
        }
    }

    // Load all users from file ------------------------------------------------
    public static void loadUsers(UserHashTable hashTable) {

        File file = new File(FileName);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader
                = new BufferedReader(new FileReader(file))) {

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
                            data[3],
                            data[4],
                            data[5],
                            data[6]
                    );

                    hashTable.addUser(user);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }
}