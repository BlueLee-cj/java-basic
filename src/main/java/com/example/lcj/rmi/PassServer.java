package com.example.lcj.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class PassServer extends UnicastRemoteObject implements PassIn {

    protected PassServer() throws RemoteException {
        super();
    }

    @Override
    public String pass(String name) throws RemoteException {
        System.out.println("welcome " + name);
        return "ok";
    }

    public static void main(String[] args) {
        try {
            //��1099�Ķ˿�������һ������ע����
            LocateRegistry.createRegistry(1413);
            PassServer server = new PassServer();
            //Զ�̷������󶨵�ע����񣬹��ͻ��˺ͷ���˽������м价��������DNS������
            Naming.rebind("rmi://localhost:1413/Hello", server);
            System.out.println("ready!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
