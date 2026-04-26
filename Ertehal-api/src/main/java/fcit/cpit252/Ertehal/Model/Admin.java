package fcit.cpit252.Ertehal.Model;

public class Admin implements User{
    private final String username;
    private final String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() { return username; }

    @Override
    public String getPassword() { return password; }

    @Override
    public String getRole() { return "ADMIN"; }
}

