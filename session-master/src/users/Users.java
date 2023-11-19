package users;

public class Users {

    int id ;
    String username, password, role;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }


    public Users(int id, String username, String password, String role, String subject) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}