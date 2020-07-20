package sep2.test;

import sep2.dataBase.dao.*;
import sep2.dataBase.entity.Friend;
import sep2.dataBase.entity.PrivateChat;
import sep2.dataBase.entity.User;
import sep2.dataBase.entity.constraints.Gender;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException {
        FriendDao friendDao= new FriendDaoImpl();
//        UserDao userDao= new UserDaoImpl();
//        User user=  userDao.getUserByEmailPhone("test002");
//        System.out.println(user);
        System.out.println(friendDao.getFriendByEmail("test001").getStr());



    }
}
