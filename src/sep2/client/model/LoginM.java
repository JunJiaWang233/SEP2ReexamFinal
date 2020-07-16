package sep2.client.model;

import sep2.client.networking.Client;
import sep2.dataBase.entity.User;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LoginM {
    private Client client;

    public void setClient(Client client){
        this.client= client;
    }

    public User selectUserByEmailPhone(String emailPhone, String password) throws RemoteException, SQLException {
        return client.selectUserByEmailPhone(emailPhone, password);
    }
}
