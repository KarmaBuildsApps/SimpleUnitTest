package myapp.tae.ac.uk.simpleunittest.calculator;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import myapp.tae.ac.uk.simpleunittest.R;
import myapp.tae.ac.uk.simpleunittest.calculator.extras.Operation;

/**
 * Created by Karma on 03/03/16.
 */
public class CalculatorActivity extends AppCompatActivity implements CalculatorView {
    @Bind(R.id.etNumber1)
    EditText etNumber1;
    @Bind(R.id.etNumber2)
    EditText etNumber2;
    @Bind(R.id.btCalculate)
    Button btCalculate;
    @Bind(R.id.rgOperations)
    RadioGroup rgOperations;
    @Bind(R.id.tvResult)
    TextView tvOperationResult;
    private CalculatorPresenter calPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity_layout);
        ButterKnife.bind(this);
        calPresenter = new CalculatorPresenter(this, new CalculatorService());
    }

    @OnClick(R.id.btCalculate)
    public void onCalculateButtonClicked(View view) {
        calPresenter.onCalculateButtonClicked();
    }

    @Override
    public String getInputField1Value() {
        return etNumber1.getText().toString();
    }

    @Override
    public String getInputField2Value() {
        return etNumber2.getText().toString();
    }

    @Override
    public void showInputField1EmptyError(int resId) {
        etNumber1.setError(getString(resId));
    }

    @Override
    public void showInputField2EmptyError(int resId) {
        etNumber2.setError(getString(resId));
    }

    @Override
    public void showInputField1InvalidError(int resId) {
        etNumber1.setError(getString(resId));
    }

    @Override
    public void showInputField2InvalidError(int resId) {
        etNumber2.setError(getString(resId));
    }

    @Override
    public Operation getOperation() {
        Operation operation = null;
        int checkedRadioButtonId = rgOperations.getCheckedRadioButtonId();
        switch (checkedRadioButtonId) {
            case R.id.rbAddition:
                operation = Operation.ADD;
                break;
            case R.id.rbSubtraction:
                operation = Operation.SUBSTRACT;
                break;
            case R.id.rbMultiplication:
                operation = Operation.MULTIPLY;
                break;
            case R.id.rbDivision:
                operation = Operation.DIVIDE;
                break;
            default:
                operation = Operation.EMPTY;
        }
        return operation;
    }

    @Override
    public String getResult() {
        return tvOperationResult.getText().toString();
    }

    @Override
    public void showDenominatorError(int resId) {
        Snackbar.make(etNumber2, getString(resId), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void setResult(String s) {
        tvOperationResult.setText(s);
    }

    @Override
    public void showOperationNotSelectedError(int resId) {
        Snackbar.make(rgOperations, getString(resId), Snackbar.LENGTH_LONG).show();
    }
}
