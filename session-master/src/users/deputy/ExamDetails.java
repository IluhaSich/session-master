package users.deputy;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import users.DataClass;
import users.Exam_Details_Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExamDetails {

    @FXML
    private TableView<Exam_Details_Class> tb_exams;

    @FXML
    private TableColumn<Exam_Details_Class, Integer> attempt;

    @FXML
    private TableColumn<Exam_Details_Class, Integer> grade;

    @FXML
    private TableColumn<Exam_Details_Class, Integer> id_exam;

    @FXML
    private TableColumn<Exam_Details_Class, Integer> id_subject;

    @FXML
    private TableColumn<Exam_Details_Class, Integer> id_teacher;

    @FXML
    private TableColumn<Exam_Details_Class, Integer> id_student;

    ObservableList<Exam_Details_Class> listED;
    int index = -1;
    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public void UpdateTable(){
        id_exam.setCellValueFactory(new PropertyValueFactory<Exam_Details_Class,Integer>("id"));
        id_subject.setCellValueFactory(new PropertyValueFactory<Exam_Details_Class,Integer>("id_subject"));
        id_teacher.setCellValueFactory(new PropertyValueFactory<Exam_Details_Class,Integer>("id_teacher"));
        id_student.setCellValueFactory(new PropertyValueFactory<Exam_Details_Class,Integer>("id_student"));
        grade.setCellValueFactory(new PropertyValueFactory<Exam_Details_Class,Integer>("grade"));
        attempt.setCellValueFactory(new PropertyValueFactory<Exam_Details_Class,Integer>("attempt"));

        listED = DataClass.getExamDetails();
        tb_exams.setItems(listED);
    }
}
