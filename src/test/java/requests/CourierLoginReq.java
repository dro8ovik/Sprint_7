package requests;

public class CourierLoginReq {
    private String login;
    private String password;

    public CourierLoginReq() {
    }

    public CourierLoginReq(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
