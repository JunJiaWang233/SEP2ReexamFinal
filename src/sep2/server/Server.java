package sep2.server;

import sep2.dataBase.entity.User;
import sep2.dataBase.entity.Users;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface Server extends Remote {
    int insertUserToD(User user) throws RemoteException, SQLException;
    User selectUserByEmailPhone(String emailPhone, String password)throws RemoteException, SQLException;
//    void GenerateUserInfo();
    Users getFriendByEmail(String email)  throws RemoteException, SQLException;
}
