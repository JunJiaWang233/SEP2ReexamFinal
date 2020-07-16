package sep2.client.viewModel;

import sep2.client.model.ModelFactory;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private SignUpVM signUpVM;
    private LoginVM loginVM;
    private MainWindowVM mainWindowVM;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public SignUpVM getSignUpVM(){
        signUpVM= null;
        if (signUpVM==null){
            signUpVM= new SignUpVM(modelFactory.getSignUpM());
        }
        return signUpVM;
    }

    public LoginVM getLoginVM(){
        loginVM= null;
        if (loginVM==null){
            loginVM= new LoginVM(modelFactory.getLoginM());
        }
        return loginVM;
    }

    public MainWindowVM getMainWindowVM(){
        mainWindowVM= null;
        if (mainWindowVM== null){
            mainWindowVM= new MainWindowVM();
        }
        return mainWindowVM;
    }
}
