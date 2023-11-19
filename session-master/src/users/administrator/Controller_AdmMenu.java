package users.administrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controller_AdmMenu {

    @FXML
    private Button addUser;

    @FXML
    private Button btbBck;

    @FXML
    private Button userList;

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btbBck.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource
                ("users/authorization.fxml")));
        stage.setTitle("Session");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void goToUsers(ActionEvent event) {
        Stage stage = (Stage) userList.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource
                    ("users/administrator/list-of-users.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Session");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void goUserCreation(ActionEvent event) throws IOException {
        Stage stage = (Stage) addUser.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource
                ("users/administrator/admin-registration.fxml")));
        stage.setTitle("Session");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
