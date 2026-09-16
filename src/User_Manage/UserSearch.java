package User_Manage;

import Registration.User;
import java.util.List;

public class UserSearch {

    public static User searchByUserID(String userID) {

        List<User> users = UserReader.readUsers();

        for (User user : users) {

            if (user.getUserID().equalsIgnoreCase(userID)) {
                return user;
            }
        }

        return null;
    }
}
