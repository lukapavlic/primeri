package si.um.feri.rmi.calc.rmi.server;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote, Serializable {

	double add(double a, double b) throws RemoteException;

	double sub(double a, double b) throws RemoteException;

	double mul(double a, double b) throws RemoteException;

	double div(double a, double b) throws RemoteException;

	double getHistory() throws RemoteException;

	Calculation getLastCalculation() throws RemoteException;

}