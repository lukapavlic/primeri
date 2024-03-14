package si.um.feri.local.calc;

public interface CalculatorInterface {
    double add(double a, double b);

    double sub(double a, double b);

    double mul(double a, double b);

    double div(double a, double b);

    double getHistory();

    Calculation getLastCalculation();
}
