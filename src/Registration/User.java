package Registration;

// Child Class -----------------------------------------------------------------
public class User extends Person {

    private String gender;
    private String type;
    private String contact;
    private String username;
    private String password;

    // COnstractor -------------------------------------------------------------
    public User(String userID, String name, String gender, String type,
            String contact, String username, String password) {

        super(userID, name);

        this.gender = gender;
        this.type = type;
        this.contact = contact;
        this.username = username;
        this.password = password;
    }

    // Getters -----------------------------------------------------------------
    public String getUserID() {
        return getId();
    }

    public String getName() {
        return super.getName();
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }

    public String getContact() {
        return contact;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters -----------------------------------------------------------------
    public void setUserID(String userID) {
        setId(userID);
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
