package sep2.client.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MainWindowC {
    @FXML
    private ListView<HBox> hBoxLv;

    private ViewHandler viewHandler;

    public void initView(ViewHandler viewHandler){
        this.viewHandler= viewHandler;
        sethBoxLv();
    }

    public void sethBoxLv(){
        ObservableList<HBox> hBoxes = FXCollections.observableArrayList();
        Text t1= new Text("Junjia");
        Text t2= new Text("Bowen");
        Text t3= new Text("Taiqun");

        HBox h1= new HBox();
        HBox h2= new HBox();
        HBox h3= new HBox();
        h1.getChildren().add(t1);
        h2.getChildren().add(t2);
        h3.getChildren().add(t3);
        hBoxes.addAll(h1, h2, h3);
        hBoxLv.getItems().addAll(hBoxes);
    }

    public void addFriendAction(){
        viewHandler.openFriendView();
    }
}
