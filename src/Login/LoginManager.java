package Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginManager {

    private final String FileName = "Users.txt";

    public String checkLogin(String username, String password) {

        try (BufferedReader br = new BufferedReader(new FileReader(FileName))){

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 7) {

                    String email = data[5].trim();
                    String pass = data[6].trim();
                    String role = data[4].trim();

                    // Returns role if login success ---------------------------
                    if (email.equals(username) && pass.equals(password)) {
                        return role;
                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Returns null if login failed ----------------------------------------
        return null;

    }

}
