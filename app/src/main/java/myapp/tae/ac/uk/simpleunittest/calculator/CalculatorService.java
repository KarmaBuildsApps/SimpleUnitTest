package myapp.tae.ac.uk.simpleunittest.calculator;

import java.security.PublicKey;

/**
 * Created by Karma on 03/03/16.
 */
public class CalculatorService {
    public double add(double dField1Value, double dField2Value) {
        return dField1Value + dField2Value;
    }

    public double substract(double dField1Value, double dField2Value) {
        return dField1Value - dField2Value;
    }

    public double multiply(double dField1Value, double dField2Value) {
        return dField1Value * dField2Value;
    }

    public double divide(double dField1Value, double dField2Value) {
        return dField1Value / dField2Value;
    }
}
