package sep2.client.model;

import sep2.client.networking.Client;

public class ModelFactory {
    private SignUpM signUpM;
    private Client client;
    private LoginM loginM;

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

    public void setClientFactory(Client client){
        this.client= client;

    }
}
