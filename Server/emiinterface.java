import java.rmi.*;
//creating emi interface
public interface emiinterface extends Remote {
    //Declaring the method
    public double emicalc(double x, double y, double z ) throws RemoteException;
}

