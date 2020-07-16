package sep2.client.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;

public class FriendC {
    @FXML
    private TitledPane all;

    public void initView(){
        setTitledPane();
    }

    public void setTitledPane(){
        ObservableList<String> names= FXCollections.observableArrayList();
        names.addAll("1", "2", "3", "4", "5");
        ListView<String> sLv= new ListView<>();
        sLv.getItems().addAll(names);
        all.setText("All");
        all.setContent(sLv);
    }
}
