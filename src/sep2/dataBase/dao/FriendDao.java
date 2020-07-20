package sep2.dataBase.dao;

import sep2.dataBase.entity.Friend;
import sep2.dataBase.entity.Users;

import java.sql.SQLException;

public interface FriendDao {
    int insertFriend(Friend friend) throws SQLException;
    Friend selectFriendByHash(String f1, String f2) throws SQLException;
    Users getFriendByEmail(String email) throws SQLException;
}
