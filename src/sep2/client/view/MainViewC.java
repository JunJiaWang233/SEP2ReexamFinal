package sep2.client.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import sep2.client.viewModel.MainVM;
import sep2.dataBase.entity.User;
import sep2.dataBase.entity.Users;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class MainViewC {
    @FXML
    private ListView<HBox> hBoxLv;
    @FXML
    private ListView<String> mLv;

    private ViewHandler viewHandler;
    private MainVM mainVM;

    public void initView(MainVM mainVM, ViewHandler viewHandler) throws RemoteException, SQLException {
        this.mainVM= mainVM;
        this.viewHandler= viewHandler;
        setFriendLv();
    }

    public void sethBoxLv(){
        ObservableList<HBox> hBoxes = FXCollections.observableArrayList();
        Text t1= new Text("Junjia");
        Text t2= new Text("Bowen");
        Text t3= new Text("Taiqun");

        HBox h1= new HBox();
        HBox h2= new HBox();
        HBox h3= new HBox();
        h1.setAlignment(Pos.CENTER);
        h2.setAlignment(Pos.CENTER);
        h3.setAlignment(Pos.CENTER);

        h1.getChildren().add(t1);
        h2.getChildren().add(t2);
        h3.getChildren().add(t3);
        hBoxes.addAll(h1, h2, h3);
        hBoxLv.getItems().addAll(hBoxes);
        
    }

   public void setFriendLv() throws RemoteException, SQLException {
       Users users= mainVM.getFriendByEmail();
       String[] usernames= users.getUsernames();
       ObservableList<String> uns= FXCollections.observableArrayList();
       uns.addAll(usernames);
       mLv.getItems().addAll(uns);

   }
}
