package myapp.tae.ac.uk.simpleunittest.calculator;

import myapp.tae.ac.uk.simpleunittest.calculator.extras.Operation;

/**
 * Created by Karma on 03/03/16.
 */
public interface CalculatorView {
    String getInputField1Value();

    void showInputField1EmptyError(int resId);

    String getInputField2Value();

    void showInputField2EmptyError(int resId);

    void showInputField1InvalidError(int resId);

    void showInputField2InvalidError(int resId);


    Operation getOperation();

    String getResult();

    void showDenominatorError(int resId);

    void setResult(String s);

    void showOperationNotSelectedError(int resId);
}
