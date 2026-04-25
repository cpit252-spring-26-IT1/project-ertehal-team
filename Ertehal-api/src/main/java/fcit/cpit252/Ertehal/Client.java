package fcit.cpit252.Ertehal;

public class Client implements User{
    private final String username;
    private final String password;

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() { return username; }

    @Override
    public String getPassword() { return password; }

    @Override
    public String getRole() { return "CLIENT"; }
}
