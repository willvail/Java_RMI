import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * 
 * @author William Vail #100941960
 * @version 1.3
 * @since 11/7/2016
 *
 */
public interface Rmi_Interface extends Remote {
    public String getBiz(int arrayVal) throws RemoteException;
    public String getEcon(int arrayVal) throws RemoteException;
    public String RMI_Implement(String type, String name, int seat) throws RemoteException;
}

