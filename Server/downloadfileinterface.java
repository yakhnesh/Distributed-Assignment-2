import java.rmi.Remote;
import java.rmi.RemoteException;

//Creting downloadfile interface
public interface downloadfileinterface extends Remote {
    // Declaring the method
    public byte[] downloadfile(String fileName) throws RemoteException;
}
