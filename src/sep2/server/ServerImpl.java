package sep2.server;

import sep2.dataBase.dao.UserDao;
import sep2.dataBase.dao.UserDaoImpl;
import sep2.dataBase.entity.User;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class ServerImpl implements Server{

    private UserDao userDao;


    public ServerImpl() throws RemoteException, AlreadyBoundException {
        UnicastRemoteObject.exportObject(this,0);
        Registry registry= LocateRegistry.createRegistry(10086);
        registry.bind("server", this);

        this.userDao= new UserDaoImpl();
    }

    @Override
    public int insertUserToD(User user) throws RemoteException, SQLException {
       int i= userDao.insertUser(user);
       return i;
    }

    @Override
    public User selectUserByEmailPhone(String emailPhone, String password) throws RemoteException, SQLException {

       User user= userDao.selectUserByEmailPhone(emailPhone, password);
        return user;
    }
}
