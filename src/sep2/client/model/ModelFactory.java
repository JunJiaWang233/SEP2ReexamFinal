package sep2.client.model;

import sep2.client.networking.Client;

public class ModelFactory {
    private SignUpM signUpM;
    private Client client;
    private LoginM loginM;
    private MainM mainM;

    public SignUpM getSignUpM(){
        signUpM= null;
        if (signUpM==null){
            signUpM= new SignUpM();
            signUpM.setClient(client);
        }
        return signUpM;
    }

    public LoginM getLoginM(){
        loginM= null;
        if (loginM==null){
            loginM= new LoginM();
            loginM.setClient(client);
        }
        return loginM;
    }
    public MainM getMainM(){
        mainM= null;
        if (mainM== null){
            mainM= new MainM();
            mainM.setClient(client);
        }
        return mainM;
    }

    public void setClientFactory(Client client){
        this.client= client;

    }
}
