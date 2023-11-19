package users;

public class Exam_Details_Class {
    int id_exam;
    int id_subject;
    int id_teacher;
    int id_student;
    int grade;
    int attempt;

    public Exam_Details_Class(int id_exam, int id_subject, int id_teacher, int id_student, int grade, int attempt) {
        this.id_exam = id_exam;
        this.id_subject = id_subject;
        this.id_teacher = id_teacher;
        this.id_student = id_student;
        this.grade = grade;
        this.attempt = attempt;
    }

    public void setId_exam(int id_exam) {
        this.id_exam = id_exam;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public int getId_exam() {
        return id_exam;
    }

    public int getId_subject() {
        return id_subject;
    }

    public int getId_teacher() {
        return id_teacher;
    }

    public int getId_student() {
        return id_student;
    }

    public int getGrade() {
        return grade;
    }

    public int getAttempt() {
        return attempt;
    }
}
