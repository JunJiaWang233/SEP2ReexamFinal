package sep2.dataBase.dao;

import sep2.dataBase.entity.Friend;

import java.sql.SQLException;

public interface FriendDao {
    int insertFriend(Friend friend) throws SQLException;
    Friend selectFriendByHash(String f1, String f2) throws SQLException;
}
