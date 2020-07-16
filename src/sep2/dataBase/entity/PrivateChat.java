package sep2.dataBase.entity;

import java.io.Serializable;

public class PrivateChat implements Serializable {
    private String sender;
    private String receiver;

    public PrivateChat(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
