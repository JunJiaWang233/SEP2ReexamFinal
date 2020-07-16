package sep2.dataBase.dao;

import sep2.dataBase.entity.PrivateChat;

import java.sql.SQLException;

public interface PrivateChatDao {
    PrivateChat selectPrivateChatByPK(String sender, String receiver) throws SQLException;
    int insertPrivateChat(String sender, String receiver) throws SQLException;

}
