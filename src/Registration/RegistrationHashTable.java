package Registration;

import java.util.HashMap;

public class RegistrationHashTable {

    private HashMap<String, StudentCourse> registrationTable;

    public RegistrationHashTable() {
        registrationTable = new HashMap<>();
    }

    // Add registration --------------------------------------------------------
    public boolean addRegistration(StudentCourse student) {

        String registrationID = student.getRegistrationID();

        // Check duplicate Registration ID -------------------------------------
        if (registrationTable.containsKey(registrationID)) {
            return false;
        }

        registrationTable.put(registrationID, student);

        return true;
    }

    // Check Registration ID ---------------------------------------------------
    public boolean containsRegistration(String registrationID) {
        return registrationTable.containsKey(registrationID);
    }

    // Get Hash Table ----------------------------------------------------------
    public HashMap<String, StudentCourse> getRegistrationTable() {
        return registrationTable;
    }
}