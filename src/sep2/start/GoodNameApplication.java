package sep2.start;

import javafx.application.Application;
import javafx.stage.Stage;
import sep2.client.model.ModelFactory;
import sep2.client.networking.Client;
import sep2.client.networking.ClientImpl;
import sep2.client.view.ViewHandler;
import sep2.client.viewModel.ViewModelFactory;

public class GoodNameApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory modelFactory= new ModelFactory();
        Client client= new ClientImpl(modelFactory);
        ViewModelFactory viewModelFactory= new ViewModelFactory(modelFactory);
        ViewHandler viewHandler= new ViewHandler(stage, viewModelFactory);
        viewHandler.openLoginView();

    }
}
