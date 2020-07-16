package sep2.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sep2.client.viewModel.LoginVM;
import sep2.dataBase.entity.User;

import java.rmi.RemoteException;
import java.sql.SQLException;


public class LoginC {

    private ViewHandler viewHandler;

    private LoginVM loginVM;

    @FXML
    private TextField emailPhone;

    @FXML
    private PasswordField password;

    public void initView(LoginVM loginVM, ViewHandler viewHandler){
        this.loginVM= loginVM;
        this.viewHandler= viewHandler;
        setTextField();
    }

    public void setTextField(){
        emailPhone.textProperty().bindBidirectional(loginVM.emailPhoneProperty());
        password.textProperty().bindBidirectional(loginVM.passwordProperty());
    }

    public void loginAction() throws RemoteException, SQLException {
        User user= loginVM.selectUserByEmailPhone();
        if (user !=null){
            System.out.println("log in");
        }else {
            initDialog("Login failed, please try again!");
        }
    }

    public void signUpAction(){
            viewHandler.openSignUpView();
    }

    private void initDialog( String contentText){
        Dialog dl= new Dialog<>();
        dl.setContentText(contentText);
        dl.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dl.setTitle("Alert");
        dl.show();
    }
}
