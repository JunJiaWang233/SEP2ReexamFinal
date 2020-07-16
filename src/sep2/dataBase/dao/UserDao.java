package sep2.dataBase.dao;

import sep2.dataBase.entity.User;

import java.sql.SQLException;

public interface UserDao {
    int insertUser(User user) throws SQLException;
    User selectUserByEmailPhone(String emailPhone, String password) throws SQLException;
}
