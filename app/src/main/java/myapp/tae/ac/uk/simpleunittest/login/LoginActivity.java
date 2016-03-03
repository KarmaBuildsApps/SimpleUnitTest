package myapp.tae.ac.uk.simpleunittest.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import myapp.tae.ac.uk.simpleunittest.R;
import myapp.tae.ac.uk.simpleunittest.calculator.CalculatorActivity;
import myapp.tae.ac.uk.simpleunittest.main.ActivityUtil;

public class LoginActivity extends AppCompatActivity implements LoginView {
    @Bind(R.id.etUserName)
    EditText etUserName;
    @Bind(R.id.etPassword)
    EditText etPassword;
    @Bind(R.id.btLogin)
    Button btLogin;
    LoginPresenter presenter;
    LoginService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);
        ButterKnife.bind(this);
        LoginService service = new LoginService();
        presenter = new LoginPresenter(this, service);
    }

    @OnClick(R.id.btLogin)
    public void onLoginButtonClicked(View view) {
        presenter.onLoginButtonClicked();
    }

    @Override
    public String getUserName() {
        return etUserName.getText().toString();
    }

    @Override
    public void showUserNameError(int resId) {
        etUserName.setError(getString(resId));
    }

    @Override
    public String getUserPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void showUserPasswordError(int resId) {
        etPassword.setError(getString(resId));
    }

    @Override
    public void startMainActivity() {
        Intent i = new Intent(this, CalculatorActivity.class);
        startActivity(i);
    }

    @Override
    public void showLoginErrorMessage(int resId) {
        Snackbar.make(btLogin, getString(R.string.login_fail_error), Snackbar.LENGTH_LONG).show();
    }
}
