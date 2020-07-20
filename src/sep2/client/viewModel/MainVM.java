package sep2.client.viewModel;

import sep2.client.model.MainM;
import sep2.dataBase.entity.Users;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class MainVM {
    private MainM mainM;

    public MainVM(MainM mainM) {
        this.mainM = mainM;
    }

    public Users getFriendByEmail(String email) throws RemoteException, SQLException {
        return mainM.getFriendByEmail(email);
    }
}
