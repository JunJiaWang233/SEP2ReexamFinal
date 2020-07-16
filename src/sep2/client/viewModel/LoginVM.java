package sep2.client.viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sep2.client.model.LoginM;
import sep2.dataBase.entity.User;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LoginVM {

    private LoginM loginM;
    private StringProperty emailPhone;
    private StringProperty password;

    public LoginVM(LoginM loginM) {
        this.loginM = loginM;
        this.emailPhone= new SimpleStringProperty();
        this.password= new SimpleStringProperty();
    }

    public User selectUserByEmailPhone() throws RemoteException, SQLException {
        return loginM.selectUserByEmailPhone(this.getEmailPhone(), this.getPassword());
    }

    public String getEmailPhone() {
        return emailPhone.get();
    }

    public StringProperty emailPhoneProperty() {
        return emailPhone;
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }
}
