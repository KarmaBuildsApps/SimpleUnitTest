package myapp.tae.ac.uk.simpleunittest.login;

/**
 * Created by Karma on 03/03/16.
 */
public interface LoginView {
    String getUserName();

    void showUserNameError(int resId);

    String getUserPassword();

    void showUserPasswordError(int resId);

    void startMainActivity();

    void showLoginErrorMessage(int resId);
}
