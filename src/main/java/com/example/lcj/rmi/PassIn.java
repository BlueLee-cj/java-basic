package com.example.lcj.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PassIn extends Remote {
    //Զ�̵��ýӿڷ���
    public String pass(String name) throws RemoteException;
}
