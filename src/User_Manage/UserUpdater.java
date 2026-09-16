package User_Manage;

import Registration.User;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class UserUpdater {

    private static final String FileName = "Users.txt";

    public static boolean updateUser(User updatedUser) {

        List<User> users = UserReader.readUsers();

        boolean found = false;

        // Find the user and replace the details -------------------------------
        for (int i = 0; i < users.size(); i++) {

            User user = users.get(i);

            if (user.getUserID().equalsIgnoreCase(updatedUser.getUserID())) {
                users.set(i, updatedUser);
                found = true;
                break;
            }
        }

        if (!found) {
            return false;
        }

        // Rewrite the entire file ---------------------------------------------
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileName))) {

            for (User user : users) {

                writer.write(
                        user.getUserID() + ","
                        + user.getName() + ","
                        + user.getGender() + ","
                        + user.getContact() + ","
                        + user.getType() + ","
                        + user.getUsername() + ","
                        + user.getPassword());

                writer.newLine();
            }

            return true;

        } catch (Exception e) {

            System.out.println("Error updating user: " + e.getMessage());
            return false;
        }
    }
}
