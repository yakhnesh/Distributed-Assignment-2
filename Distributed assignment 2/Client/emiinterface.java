import java.rmi.*;

//Creting downloadfile interface
public interface emiinterface extends Remote {
    //declaring the method
    public double emicalc(double x, double y, double z ) throws RemoteException;
}

