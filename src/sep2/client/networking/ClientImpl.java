package sep2.client.networking;

import sep2.client.model.ModelFactory;
import sep2.dataBase.entity.User;
import sep2.dataBase.entity.Users;
import sep2.server.Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class ClientImpl implements Client{
    private Server server;
    private ModelFactory modelFactory;

    public ClientImpl(ModelFactory modelFactory) throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this,0);
        Registry registry= LocateRegistry.getRegistry(10086);
        this.server= (Server) registry.lookup("server");
        this.modelFactory= modelFactory;
        this.modelFactory.setClientFactory(this);
    }


    @Override
    public int insertUserToD(User user) throws RemoteException, SQLException {
       int i= server.insertUserToD(user);
       return i;
    }

    @Override
    public User selectUserByEmailPhone(String emailPhone, String password) throws RemoteException, SQLException {
        return server.selectUserByEmailPhone(emailPhone, password);
    }

    @Override
    public Users getFriendByEmail(String email) throws RemoteException, SQLException {
        return server.getFriendByEmail(email);
    }


}
