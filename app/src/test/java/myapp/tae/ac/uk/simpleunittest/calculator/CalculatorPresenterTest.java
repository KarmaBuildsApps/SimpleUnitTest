package myapp.tae.ac.uk.simpleunittest.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import myapp.tae.ac.uk.simpleunittest.R;
import myapp.tae.ac.uk.simpleunittest.calculator.extras.Operation;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Karma on 03/03/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculatorPresenterTest {
    private CalculatorPresenter calPresenter;
    @Mock
    private CalculatorView view;
    @Mock
    private CalculatorService service;

    @Before
    public void setUp() throws Exception {
        calPresenter = new CalculatorPresenter(view, service);
    }

    @Test
    public void displayErrorWhenInputField1IsEmpty() throws Exception {
        when(view.getInputField1Value()).thenReturn("");
        calPresenter.onCalculateButtonClicked();

        verify(view).showInputField1EmptyError(R.string.calculator_entry_empty);
    }

    @Test
    public void displayErrorWhenInputField2IsEmpty() throws Exception {
        when(view.getInputField1Value()).thenReturn("0");
        when(view.getInputField2Value()).thenReturn("");
        calPresenter.onCalculateButtonClicked();

        verify(view).showInputField2EmptyError(R.string.calculator_entry_empty);

    }

    @Test
    public void displayErrorWhenInputField1IsInvalid() throws Exception {
        when(view.getInputField1Value()).thenReturn("e");
        calPresenter.onCalculateButtonClicked();

        verify(view).showInputField1InvalidError(R.string.calculator_entry_error);

    }

    @Test
    public void displayErrorWhenInputField2IsInvalid() throws Exception {
        when(view.getInputField1Value()).thenReturn("2.2");
        when(view.getInputField2Value()).thenReturn("e");
        calPresenter.onCalculateButtonClicked();

        verify(view).showInputField2InvalidError(R.string.calculator_entry_error);
    }

    @Test
    public void checkIfAdditionIsPerformedCorrectly() throws Exception {
        when(view.getInputField1Value()).thenReturn("2");
        when(view.getInputField2Value()).thenReturn("3.3");
        when(view.getOperation()).thenReturn(Operation.ADD);
        calPresenter.onCalculateButtonClicked();

        verify(view.getResult()).equals("5.3");

    }

    @Test
    public void checkIfSubstractionIsPerformedCorrectly() throws Exception {
        when(view.getInputField1Value()).thenReturn("6");
        when(view.getInputField2Value()).thenReturn("3.3");
        when(view.getOperation()).thenReturn(Operation.SUBSTRACT);
        calPresenter.onCalculateButtonClicked();

        verify(view.getResult()).equals("2.7");

    }

    @Test
    public void checkIfMultiplicationIsPerformedCorrectly() throws Exception {
        when(view.getInputField1Value()).thenReturn("2");
        when(view.getInputField2Value()).thenReturn("3.3");
        when(view.getOperation()).thenReturn(Operation.MULTIPLY);
        calPresenter.onCalculateButtonClicked();

        verify(view.getResult()).equals("6.6");

    }

    @Test
    public void displayErrorWhenField2ValueIsZeroAndOperationIsDivision() throws Exception {
        when(view.getInputField1Value()).thenReturn("2");
        when(view.getInputField2Value()).thenReturn("0");
        when(view.getOperation()).thenReturn(Operation.DIVIDE);
        calPresenter.onCalculateButtonClicked();

        verify(view).showDenominatorError(R.string.calculator_denominator_error);
    }

    @Test
    public void checkIfDivisionIsPerformedCorrectly() throws Exception {
        when(view.getInputField1Value()).thenReturn("10");
        when(view.getInputField2Value()).thenReturn("2");
        when(view.getOperation()).thenReturn(Operation.DIVIDE);
        calPresenter.onCalculateButtonClicked();

        verify(view.getResult()).equals("5.0");

    }
}