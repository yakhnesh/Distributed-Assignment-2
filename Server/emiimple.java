import java.rmi.server.*;
import java.rmi.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class emiimple extends UnicastRemoteObject
    implements emiinterface, downloadfileinterface {

    //Default constructor to throw remote exception from its parent constructor

        public emiimple() throws RemoteException{
            super();
        }

   //Implement the interfaces
        public double emicalc(double loan, double rate, double t){
            double emi = loan*((rate*(Math.pow(1+rate,t)))/((Math.pow(1+rate,t))-1));
            return emi;
        }

    public byte[] downloadfile(String fileName){
        try {
            File file = new File(fileName);
            byte buffer[] = new byte[(int)file.length()];
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName));
            input.read(buffer,0,buffer.length);
            input.close();
            return(buffer);
        } catch(Exception e){
            System.out.println("emiimple: "+e.getMessage());
            e.printStackTrace();
            return(null);
        }
    }

    }
