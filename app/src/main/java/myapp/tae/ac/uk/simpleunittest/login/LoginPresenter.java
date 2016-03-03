package myapp.tae.ac.uk.simpleunittest.login;

import android.content.Intent;

import myapp.tae.ac.uk.simpleunittest.R;
import myapp.tae.ac.uk.simpleunittest.main.ActivityUtil;

/**
 * Created by Karma on 03/03/16.
 */
public class LoginPresenter {
    private final LoginView view;
    private final LoginService service;

    public LoginPresenter(LoginView view, LoginService service) {
        this.view = view;
        this.service = service;
    }

    public void onLoginButtonClicked() {
        String userName = view.getUserName();
        if (userName.isEmpty()) {
            view.showUserNameError(R.string.login_user_name_error);
            return;
        }
        String userPassword = view.getUserPassword();
        if (userPassword.isEmpty()) {
            view.showUserPasswordError(R.string.login_password_error);
            return;
        }

        boolean isLoginSuccess = service.login(userName, userPassword);
        if (isLoginSuccess) {
            view.startMainActivity();
            return;
        }
        view.showLoginErrorMessage(R.string.login_fail_error);
    }


}
