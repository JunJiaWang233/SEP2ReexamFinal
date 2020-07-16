package sep2.dataBase.entity;

import java.io.Serializable;

public class Friend implements Serializable {
    private int hashFriend;
    private String f1;
    private String f2;

    public Friend( String f1, String f2) {
        this.hashFriend = f1.hashCode()+ f2.hashCode();
        this.f1 = f1;
        this.f2 = f2;
    }

    public int getHashFriend() {
        return hashFriend;
    }


    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }
}
