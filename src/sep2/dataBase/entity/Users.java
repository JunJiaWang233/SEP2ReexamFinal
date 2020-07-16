package sep2.dataBase.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Users implements Serializable {
    private List<User> users;

    public Users() {
        users= new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    public String getStr(){
        String s= "";
        for (User user: users){
            s+= user+System.getProperty(System.lineSeparator());
        }
        return s;
    }
}
