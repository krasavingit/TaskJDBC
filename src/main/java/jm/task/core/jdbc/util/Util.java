package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    public static Statement statement = null;
    static {
        try {
            statement = getCon();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Statement getCon() throws SQLException {
        Connection connection;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false","root","122123qq");
            statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            System.out.println("Smth went wrong");
        }
        return statement;
    }
}
