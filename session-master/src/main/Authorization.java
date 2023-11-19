package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import users.DataClass;


import java.io.IOException;
import java.util.Objects;

public class Authorization {

    @FXML
    private Button btn_login;

    @FXML
    private TextField field_login;

    @FXML
    private PasswordField field_password;

    @FXML
    void initialize(ActionEvent event) throws IOException {
        String loginText = field_login.getText().trim();
        String loginPassword = field_password.getText().trim();
        if (!loginText.equals("") && !loginPassword.equals("")){
            loginUser(loginText, loginPassword);
        }
    }

    private void loginUser(String loginText, String loginPassword) throws IOException {
        DataClass dbManager = new DataClass();
        String role = dbManager.authenticate(loginText, loginPassword);
        System.out.println(role);
        switch (role){
            case "student" -> {
                Stage stage = (Stage) btn_login.getScene().getWindow();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource
                        ("users/student/student_menu.fxml")));
                stage.setTitle("Session");
                stage.setScene(new Scene(root));
                stage.show();
            }
            case "admin" -> {
                Stage stage = (Stage) btn_login.getScene().getWindow();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource
                        ("users/administrator/administratorMenu.fxml")));
                stage.setTitle("Session");
                stage.setScene(new Scene(root));
                stage.show();
            }
            case "deputy" -> {
                Stage stage = (Stage) btn_login.getScene().getWindow();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource
                        ("users/deputy/deputy_menu.fxml")));
                stage.setTitle("Session");
                stage.setScene(new Scene(root));
                stage.show();
            }
            case "teacher" -> {
                Stage stage = (Stage) btn_login.getScene().getWindow();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource
                        ("users/teacher/teacher_groupSelection.fxml")));
                stage.setTitle("Session");
                stage.setScene(new Scene(root));
                stage.show();
            }
            default -> System.out.println("wrong login or password");
        }
    }
}
