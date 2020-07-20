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
            s+= user+System.getProperty("line.separator");
        }
        return s;
    }

    public String[] getUsernames(){
        String[] ss= new String[300];
        int i= 0;
        for (User user: users){
            ss[i]= user.getUsername();
            i++;
        }
        return ss;
    }
}
