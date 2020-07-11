package jm.task.core.jdbc.model;

import jm.task.core.jdbc.util.Util;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private Byte age;

    public User() {

    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public long getId() throws SQLException {
        long value = 0;
        try {
            ResultSet rs = Util.getCon().executeQuery("SELECT id FROM users WHERE firstName = '" + name + "'");
            rs.next();
            value = rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Пользователя не существует");
        }
        return value;
    }

    public void setId(Long id) {
        try {
            Util.getCon().execute("UPDATE users SET id = '" + id + "' where firstName = '" + name + "'");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Пользователя не существует");
        }
    }

    public String getName() {
        String name = null;
        try {
            ResultSet rs = Util.getCon().executeQuery("SELECT firstName FROM users WHERE id = '" + getId() + "'");
            rs.next();
            name = rs.getString("firstName");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Пользователя не существует");
        }
        return name;
    }

    public void setName(String name) {
        try {
            Util.getCon().execute("UPDATE users SET firstName = '" + name + "' where id = '" + getId() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Пользователя не существует");
        }
    }

    public String getLastName() {
        String lname = null;
        try {
            ResultSet rs = Util.getCon().executeQuery("SELECT lastName FROM users WHERE id = '" + getId() + "'");
            rs.next();
            lname = rs.getString("lastName");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Пользователя не существует");
        }
        return lname;
    }

    public void setLastName(String lastName) {
        try {
            Util.getCon().execute("UPDATE users SET lastName = '" + name + "' where id = '" + getId() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Пользователя не существует");
        }
    }

    public Byte getAge() {
        Byte bage = 0;
        try {
            ResultSet rs = Util.getCon().executeQuery("SELECT age FROM users WHERE id = '" + getId() + "'");
            rs.next();
            bage = (byte)rs.getInt("age");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Пользователя не существует");
        }
        return bage;
    }

    public void setAge(Byte age) {
        try {
            Util.getCon().execute("UPDATE users SET age = '" + (int)age + "' where id = '" + getId() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Пользователя не существует");
        }
    }

    @Override
    public String toString() {
        long tid = 0;
        try {
            tid = getId();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "User{" +
                "id=" + tid +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
