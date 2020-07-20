package sep2.test;

import sep2.dataBase.dao.*;
import sep2.dataBase.entity.Friend;
import sep2.dataBase.entity.PrivateChat;
import sep2.dataBase.entity.User;
import sep2.dataBase.entity.constraints.Gender;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException {
        try {
            FileWriter fw= new FileWriter("user_config\\test.properties");
            Properties properties= new Properties();
            properties.setProperty("email", "123456@mail.com");
            properties.store(fw, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
