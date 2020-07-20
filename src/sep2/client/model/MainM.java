package sep2.client.model;

import sep2.client.networking.Client;
import sep2.dataBase.entity.Users;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class MainM {
    private Client client;

    public void setClient(Client client){
        this.client= client;
    }

    public Users getFriendByEmail() throws RemoteException, SQLException {
        return client.getFriendByEmail();
    }
}
