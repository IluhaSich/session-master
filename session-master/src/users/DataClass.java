package users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataClass {

    private Connection connection;

    public DataClass() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx", "root", "123456789");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    Connection conn = null;
    public static Connection ConnectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx", "root", "123456789");
            // JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            return null;
        }
    }


    public String authenticate(String login, String password) {
        try {
            String query = "SELECT role FROM users WHERE login = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }

        return "not found";
    }
    public String registration(String username, String password, String role, String subject){
        try {
            String query = "INSERT INTO users (username, password, role, subject) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, role);
            statement.setString(4, subject);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0){
                return "Пользователь успешно зарегистрирован";

            }
            else {
                return "Ошибка при регистрации пользователя";
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка при регистрации пользователя";

        }
        finally {
            closeConnection();
        }
    }
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Users> getDatausers(){
        Connection conn = ConnectDb();
        ObservableList<Users> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Users(Integer.parseInt(rs.getString("id")), rs.getString("username"), rs.getString("password"), rs.getString("role"), rs.getString("subject")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static ObservableList<Exam_Details_Class> getExamDetails(){
        Connection conn = ConnectDb();
        ObservableList<Exam_Details_Class> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from exam_details");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Exam_Details_Class(Integer.parseInt(rs.getString("id")),Integer.parseInt(rs.getString("id3")),
                        Integer.parseInt(rs.getString("id2")),Integer.parseInt(rs.getString("id4")),
                        Integer.parseInt(rs.getString("id6")),Integer.parseInt(rs.getString("id5"))));

            }
        } catch (Exception e) {
        }
        return list;
    }
}
