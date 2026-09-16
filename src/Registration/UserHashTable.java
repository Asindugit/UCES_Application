package Registration;

import java.util.HashMap;

public class UserHashTable {

    private HashMap<String, User> userTable;

    public UserHashTable() 
    {
        userTable = new HashMap<>();
    }

    // Register a new user -----------------------------------------------------
    public boolean addUser(User user) {

        // Check username already exists ---------------------------------------
        if (userTable.containsKey(user.getUsername())) {
            return false;
        }

        // Check User ID already exists ----------------------------------------
        for (User existingUser : userTable.values()) {
            if (existingUser.getUserID().equals(user.getUserID())) {
                return false;
            }
        }

        userTable.put(user.getUsername(), user);

        return true;
    }

    // Search user using username ----------------------------------------------
    public User getUser(String username) {
        return userTable.get(username);
    }

    // Check username exists ---------------------------------------------------
    public boolean usernameExists(String username) {
        return userTable.containsKey(username);
    }

    // Check User ID exists ----------------------------------------------------
    public boolean userIDExists(String userID) {

        for (User user : userTable.values()) {
            if (user.getUserID().equals(userID)) {
                return true;
            }
        }

        return false;
    }

    // Login validation --------------------------------------------------------
    public boolean login(String username, String password) {

        User user = userTable.get(username);

        if (user == null) {
            return false;
        }

        return user.getPassword().equals(password);
    }

    // Get all users -----------------------------------------------------------
    public HashMap<String, User> getAllUsers() {
        return userTable;
    }

    // Remove user -------------------------------------------------------------
    public boolean removeUser(String username) {

        if (!userTable.containsKey(username)) {
            return false;
        }

        userTable.remove(username);
        return true;
    }
}
