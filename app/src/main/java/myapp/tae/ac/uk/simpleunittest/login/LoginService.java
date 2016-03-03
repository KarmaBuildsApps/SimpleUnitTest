package myapp.tae.ac.uk.simpleunittest.login;

/**
 * Created by Karma on 03/03/16.
 */
public class LoginService {
    public boolean login(String username, String password) {
        boolean isLoginSuccess = false;
        if (username.equals("james") & password.equals("bond")) {
            isLoginSuccess = true;
        }
        return isLoginSuccess;
    }
}
