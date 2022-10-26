package si.unimb.lisa.tdd;

public class SalaryCalculator {

    public SalaryCalculator(double hourRate, double hoursWorked, double stimulation) {
        this.hourRate=hourRate;
        this.hoursWorked=hoursWorked;
        this.stimulation=stimulation;
    }

    double hourRate;
    double hoursWorked;
    double stimulation;

    public double calculate() {
        double ret=hourRate * hoursWorked;
        ret=ret + ret * stimulation;
        return ret;
    }

}
/*
    Empty impl:

    public SalaryCalculator(double hourRate, double hoursWorked, double stimulation) {

    }

    public double calculate() {
        return 0;
    }

*/

/*
    Finished impl:

    public SalaryCalculator(double hourRate, double hoursWorked, double stimulation) {
        this.hourRate=hourRate;
        this.hoursWorked=hoursWorked;
        this.stimulation=stimulation;
    }

    double hourRate;
    double hoursWorked;
    double stimulation;

    public double calculate() {
        double ret=hourRate * hoursWorked;
        ret=ret + ret * stimulation;
        return ret;
    }

* */