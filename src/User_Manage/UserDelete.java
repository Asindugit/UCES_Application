package User_Manage;

import Registration.User;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class UserDelete {

    private static final String FileName = "Users.txt";

    public static boolean deleteUser(String userID) {

        List<User> users = UserReader.readUsers();

        boolean found = false;

        // Find user -----------------------------------------------------------
        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getUserID().equalsIgnoreCase(userID)) {

                users.remove(i);
                found = true;
                break;
            }
        }

        // User not found ------------------------------------------------------
        if (!found) {
            return false;
        }

        // Rewrite Users.txt ---------------------------------------------------
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileName))) {

            for (User user : users) {

                writer.write(
                        user.getUserID() + ","
                        + user.getName() + ","
                        + user.getGender() + ","
                        + user.getContact() + ","
                        + user.getType() + ","
                        + user.getUsername() + ","
                        + user.getPassword()
                );

                writer.newLine();
            }

            return true;

        } catch (Exception e) {

            System.out.println("Error deleting user: " + e.getMessage());

            return false;
        }
    }
}
