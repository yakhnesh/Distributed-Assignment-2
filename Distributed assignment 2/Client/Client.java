import java.util.*;
import java.lang.*;
import java.rmi.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception
    {

        Scanner scan = new Scanner(System.in);
        while(true) {
            //Start page
            System.out.println("what option would you like?");
            System.out.println("\n1.Emi\n2.downloadfile\n3.Exit");
            int opt = scan.nextInt();

            //ends connection
            if (opt ==3){
                break;
            }
            switch (opt) {
                //emi calculator
                case 1:
                    System.out.println("Welcome to emi calc");
                    System.out.println("Enter loan amount");
                    double loan = scan.nextDouble();
                    System.out.println("Enter rate amount");
                    double rate = scan.nextDouble();
                    rate = rate/1200;
                    System.out.println("Enter tenure amount");
                    double t = scan.nextDouble();
                    emiinterface obj = (emiinterface)Naming.lookup("EMI");
                    double n = obj.emicalc(loan,rate,t);
                    System.out.println("Your monthly emi is "+n);
                    break;
                //download file
                case 2:
                    try {
                        System.out.println("write your file name");
                        String name = scan.next();
                        downloadfileinterface fi = (downloadfileinterface)Naming.lookup("EMI");
                        byte[] filedata = fi.downloadfile(name);
                        File file = new File(name);
                        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file.getName()));
                        output.write(filedata,0,filedata.length);
                        output.flush();
                        output.close();
                        System.out.println("Download sent");
                    } catch(Exception e) {
                        System.err.println("FileServer exception: "+ e.getMessage());
                        e.printStackTrace();
                    }
                    break;
            }


        }
    }
}

