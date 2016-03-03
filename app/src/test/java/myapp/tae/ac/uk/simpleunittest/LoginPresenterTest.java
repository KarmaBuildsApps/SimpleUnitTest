package myapp.tae.ac.uk.simpleunittest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import myapp.tae.ac.uk.simpleunittest.login.LoginPresenter;
import myapp.tae.ac.uk.simpleunittest.login.LoginService;
import myapp.tae.ac.uk.simpleunittest.login.LoginView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Karma on 03/03/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Mock
    private LoginView view;
    @Mock
    private LoginService service;
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(view, service);

    }

    @Test
    public void displayErrorWhenUserNameIsEmpty() throws Exception {
        when(view.getUserName()).thenReturn("");
        presenter.onLoginButtonClicked();

        verify(view).showUserNameError(R.string.login_user_name_error);
    }

    @Test
    public void displayErrorWhenPasswordIsInvalid() throws Exception {
        when(view.getUserName()).thenReturn("james");
        when(view.getUserPassword()).thenReturn("");
        presenter.onLoginButtonClicked();

        verify(view).showUserPasswordError(R.string.login_password_error);
    }

    @Test
    public void shouldStartMainActivityWhenUsernameAndPasswordAreCorrect() throws Exception {
        when(view.getUserName()).thenReturn("james");
        when(view.getUserPassword()).thenReturn("bond");
        when(service.login("james", "bond")).thenReturn(true);
        presenter.onLoginButtonClicked();

        verify(view).startMainActivity();
    }

    @Test
    public void displayErrorWhenUserNameAndPasswordAreMismatched() throws Exception {
        when(view.getUserName()).thenReturn("james");
        when(view.getUserPassword()).thenReturn("bond");
        when(service.login("james", "bond")).thenReturn(false);
        presenter.onLoginButtonClicked();

        verify(view).showLoginErrorMessage(R.string.login_fail_error);

    }
}