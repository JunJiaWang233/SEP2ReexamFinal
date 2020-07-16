package sep2.client.viewModel;

import javafx.beans.property.*;
import sep2.client.model.SignUpM;
import sep2.client.view.SignUpC;
import sep2.dataBase.entity.User;
import sep2.dataBase.entity.constraints.Gender;

import java.rmi.RemoteException;
import java.sql.SQLException;


public class SignUpVM {

    private SignUpM signUpM;

    private StringProperty username, password, verifyPw, email, phone;

    private ObjectProperty<Gender> genderObject;

    public SignUpVM(SignUpM signUpM) {
        this.signUpM= signUpM;
        username= new SimpleStringProperty();
        password= new SimpleStringProperty();
        verifyPw= new SimpleStringProperty();
        email= new SimpleStringProperty();
        phone= new SimpleStringProperty();
        genderObject= new SimpleObjectProperty<>();
    }


    public int insertUserToD() throws RemoteException, SQLException {
        User user= new User(this.getUsername(), this.getPassword(),
                this.getEmail(), "",Gender.secrecy);
        user.setPhone(this.getPhone());
        user.setGender(this.getGenderObject());
       int i= signUpM.insertUserToD(user);
       return i;
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getVerifyPw() {
        return verifyPw.get();
    }

    public StringProperty verifyPwProperty() {
        return verifyPw;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public Gender getGenderObject() {
        return genderObject.get();
    }

    public ObjectProperty<Gender> genderObjectProperty() {
        return genderObject;
    }
}
