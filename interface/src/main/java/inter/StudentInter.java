package inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInter extends Remote{

    public String getStudentName(String str)throws RemoteException;

}
