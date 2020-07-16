package sep2.client.model;

import sep2.client.networking.Client;
import sep2.dataBase.entity.User;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class SignUpM {
    private Client client;

    public void setClient(Client client){
        this.client= client;
    }

    public int insertUserToD(User user) throws RemoteException, SQLException {
       int i= client.insertUserToD(user);
       return i;
    }
}
