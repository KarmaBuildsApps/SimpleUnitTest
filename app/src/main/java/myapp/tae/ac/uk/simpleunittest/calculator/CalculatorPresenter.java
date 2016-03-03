package myapp.tae.ac.uk.simpleunittest.calculator;

import android.util.Log;

import myapp.tae.ac.uk.simpleunittest.R;
import myapp.tae.ac.uk.simpleunittest.calculator.extras.Operation;

/**
 * Created by Karma on 03/03/16.
 */
public class CalculatorPresenter {

    private final static String TAG = CalculatorPresenter.class.getName();
    private CalculatorView view;
    private CalculatorService calService;

    public CalculatorPresenter(CalculatorView view, CalculatorService calculatorService) {
        this.view = view;
        this.calService = calculatorService;
    }

    public void onCalculateButtonClicked() {
        String sField1Value = view.getInputField1Value().replaceAll(" ", "");//remove all spaces
        if (sField1Value.isEmpty()) {
            view.showInputField1EmptyError(R.string.calculator_entry_empty);
            return;
        } else if (!sField1Value.matches("^\\d+(\\.?\\d*)?")) { //is not an integer or a decimal number
            view.showInputField1InvalidError(R.string.calculator_entry_error);
            return;
        }

        String sField2Value = view.getInputField2Value().replaceAll(" ", "");
        if (sField2Value.isEmpty()) {
            view.showInputField2EmptyError(R.string.calculator_entry_empty);
            return;
        } else if (!sField2Value.matches("^\\d+(\\.?\\d*)?")) { //is not an integer or a decimal number
            view.showInputField2InvalidError(R.string.calculator_entry_error);
            return;
        }

        Operation operation = view.getOperation();

        if (operation == Operation.DIVIDE && Double.parseDouble(sField2Value) == 0.0) {
            view.showDenominatorError(R.string.calculator_denominator_error);
            return;
        }

        double value = calculateForMathOperation(operation, sField1Value, sField2Value);

        view.setResult("" + value);
    }

    private double calculateForMathOperation(Operation operation, String sField1Value, String sField2Value) {
        double operationResult = 0.0;
        double dField1Value = Double.parseDouble(sField1Value);
        double dField2Value = Double.parseDouble(sField2Value);
        switch (operation) {
            case ADD:
                operationResult = calService.add(dField1Value, dField2Value);
                break;
            case SUBSTRACT:
                operationResult = calService.substract(dField1Value, dField2Value);
                break;
            case MULTIPLY:
                operationResult = calService.multiply(dField1Value, dField2Value);
                break;
            case DIVIDE:
                operationResult = calService.divide(dField1Value, dField2Value);
                break;
        }

        return operationResult;
    }
}
