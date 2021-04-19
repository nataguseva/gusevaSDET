package ru.list.nataguseva;
import ru.list.nataguseva.ConfProperties;


public class SetupData {
    private final String login  = ConfProperties.getProperty("login");
    private final String password = ConfProperties.getProperty("password");

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
