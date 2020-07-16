package sep2.client.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sep2.client.viewModel.SignUpVM;
import sep2.dataBase.entity.constraints.Gender;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.function.UnaryOperator;

public class SignUpC {

    private ViewHandler viewHandler;
    private SignUpVM signUpVM;

    @FXML
    private ChoiceBox<Gender> genderChoiceBox;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField verifyPw;

    @FXML
    private TextField email;

    @FXML
    private TextField phone;


    public void initView(SignUpVM signUpVM, ViewHandler viewHandler){
        this.signUpVM= signUpVM;
        this.viewHandler= viewHandler;
        setGenderChoiceBox();
        setTextField();
    }

    public void setGenderChoiceBox(){
        genderChoiceBox.getItems().addAll(Gender.secrecy, Gender.male, Gender.female);
        genderChoiceBox.valueProperty().bindBidirectional(signUpVM.genderObjectProperty());
    }

    public void setTextField(){
        username.textProperty().bindBidirectional(signUpVM.usernameProperty());
        password.textProperty().bindBidirectional(signUpVM.passwordProperty());
        verifyPw.textProperty().bindBidirectional(signUpVM.verifyPwProperty());
        email.textProperty().bindBidirectional(signUpVM.emailProperty());
        phone.setTextFormatter(new TextFormatter<Object>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String value= change.getText();
                if (value.matches("[0-9]{0,20}")){
                    return change;
                }
                return null;
            }
        }));
        phone.textProperty().bindBidirectional(signUpVM.phoneProperty());
    }

    public void submitAction(){
        boolean verifyPassword= (password.getText().equals(verifyPw.getText()));
        if (!verifyPassword){
            initDialog("Entered passwords differ, please try again! ");
        }else {
            try {
                int i= signUpVM.insertUserToD();
                if (i>0){

                    initDialog("Congratulations. You have registered successfully!");
                }else {
                    initDialog("Sorry, Your Sign up Failed, please try again!");
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }catch (SQLIntegrityConstraintViolationException throwables){
                initDialog("The email or phone number has exist, please change a new one");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void cancelAction(){
        viewHandler.openLoginView();
    }

    private void initDialog( String contentText){
        Dialog dl= new Dialog<>();
        dl.setContentText(contentText);
        dl.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dl.setTitle("Alert");
        dl.show();
    }
}
