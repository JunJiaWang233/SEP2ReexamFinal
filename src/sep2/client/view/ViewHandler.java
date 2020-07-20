package sep2.client.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sep2.client.viewModel.ViewModelFactory;


import java.io.IOException;
import java.net.URL;

public class ViewHandler {

    private Stage stage;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory= viewModelFactory;
    }

    public void openSignUpView(){
        FXMLLoader loader= new FXMLLoader();
        String path= "sep2\\client\\view\\SignUpV.fxml";
        Parent root= getRootByPath(path, loader);
        SignUpC signUpC= loader.getController();
        signUpC.initView(viewModelFactory.getSignUpVM(), this);
        Scene scene= new Scene(root);
        this.stage.setScene(scene);
        this.stage.setResizable(false);
        this.stage.setTitle("Sign Up");
        this.stage.show();
    }

    public void openLoginView(){
        FXMLLoader loader= new FXMLLoader();
        String path= "sep2\\client\\view\\LoginV.fxml";
        Parent root= getRootByPath(path, loader);
        LoginC loginC= loader.getController();
        loginC.initView(viewModelFactory.getLoginVM(), this);
        Scene scene= new Scene(root);
        this.stage.setScene(scene);
        this.stage.setResizable(false);
        this.stage.setTitle("Log in");
        this.stage.show();
    }

    public void openMainWindowView(){
        FXMLLoader loader= new FXMLLoader();
        String path= "sep2\\client\\view\\MainView.fxml";
        Parent root= getRootByPath(path, loader);
        MainViewC mainViewC= loader.getController();
        mainViewC.initView(this);
        Scene scene= new Scene(root);
        this.stage.setScene(scene);
        this.stage.setResizable(false);
        this.stage.setTitle("good chat");
        this.stage.show();
    }

    public void openFriendView(){
        FXMLLoader loader= new FXMLLoader();
        String path= "sep2\\client\\view\\FriendV.fxml";
        Parent root= getRootByPath(path, loader);
        FriendC friendC= loader.getController();
        friendC.initView();
        Scene scene= new Scene(root);
        this.stage.setScene(scene);
        this.stage.setResizable(false);
        this.stage.setTitle("friend");
        this.stage.show();
    }

    public Parent getRootByPath(String path, FXMLLoader loader){
        Parent root= null;
        URL fxURL= loader.getClassLoader().getResource(path);
        loader.setLocation(fxURL);
        try {
             root= loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
