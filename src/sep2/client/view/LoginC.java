package sep2.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sep2.client.clientUtil.IoUtil;
import sep2.client.viewModel.LoginVM;
import sep2.dataBase.entity.User;

import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Properties;


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
            loginVM.getClient().setUser(user);
            FileWriter fw= null;
            try {
                 fw= new FileWriter("user_config\\"+user.getEmail()+".properties");
                Properties properties= new Properties();
                properties.setProperty("username", user.getUsername());
                properties.setProperty("email", user.getEmail());
                properties.setProperty("phone", user.getPhone());
                properties.setProperty("gender", user.getGender().toString());
                properties.store(fw, "user_info");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                IoUtil.close(fw);
            }
            viewHandler.openMainWindowView();
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
