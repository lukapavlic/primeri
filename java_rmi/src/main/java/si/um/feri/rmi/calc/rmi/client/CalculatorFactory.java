package si.um.feri.rmi.calc.rmi.client;

import si.um.feri.rmi.calc.rmi.server.Calculator;
import si.um.feri.rmi.calc.rmi.server.CalculatorImpl;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CalculatorFactory {

    Calculator createCalculator() throws Exception {
        return (Calculator) Naming.lookup("//localhost/calc");
//        return new CalculatorImpl();
    }

}
