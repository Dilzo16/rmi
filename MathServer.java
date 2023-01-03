import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;//
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;


public class MathServer extends UnicastRemoteObject implements MathService{

    public MathServer() throws  RemoteException{
        super();
    }


    @Override
    public int add(int a, int b) throws RemoteException {
       System.out.println("Adding" + a +" and "+b+"in the server");
       return a+b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        System.out.println("Subtracting" + a +" and "+b+"in the server");
        return a-b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        System.out.println("Multiplying" + a +" and "+b+"in the server");
        return a*b;
    }

    public int test (int a){
        System.out.println("this is a test");
        return 0;
    }
    @Override
    public int divide(int a, int b) throws RemoteException {
        System.out.println("Dividing" + a +" and "+b+"in the server");
        return a/b;
    }


    public static void main(String args[]){
        if(System.getSecurityManager()==null)
            System.setSecurityManager(new RMISecurityManager());
        try{
            MathServer svr=new MathServer();
            Registry registry=LocateRegistry.getRegistry();
            registry.bind("CalculatorService",svr);

        }catch(RemoteException re){
            System.err.println(re.getMessage());

        }catch (AlreadyBoundException abe){
            System.err.println(abe.getMessage());
        }
    }
}
