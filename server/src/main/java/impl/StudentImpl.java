package impl;

import entity.Person;
import inter.StudentInter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StudentImpl extends UnicastRemoteObject implements StudentInter{

    public StudentImpl() throws RemoteException                                                                  {
        super();
    }

    public String getStudentName(String str) throws RemoteException {
        return str + "x";
    }
}
