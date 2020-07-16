package sep2.start;

import sep2.server.Server;
import sep2.server.ServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class StartServer {
    public static void main(String[] args) throws AlreadyBoundException, RemoteException {
        Server server= new ServerImpl();
    }
}
