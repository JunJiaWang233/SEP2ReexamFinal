package sep2.dataBase.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrivateChats implements Serializable {
    private List<PrivateChat> pcs;

    public PrivateChats() {
        pcs= new ArrayList<>();
    }

    public void addPc(PrivateChat privateChat){
        pcs.add(privateChat);
    }

    public void removePc(PrivateChat privateChat){
        pcs.remove(privateChat);
    }

    public void addAll(PrivateChat... privateChats){
        for (PrivateChat privateChat: privateChats){
            pcs.add(privateChat);
        }
    }
}
