package sep2.client.viewModel;

import sep2.client.model.MainM;
import sep2.dataBase.entity.User;
import sep2.dataBase.entity.Users;

import java.io.FileInputStream;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class MainVM {
    private MainM mainM;

    public MainVM(MainM mainM) {
        this.mainM = mainM;
    }

    public Users getFriendByEmail() throws RemoteException, SQLException {

        return mainM.getFriendByEmail();
    }
}
