public class student {
    private String forename;
    private String surname;

    private int examScore = 0;
    private String examGrade;

    //Constructor for student class
    public student(String forename, String surname) {
        this.forename = forename;
        this.surname = surname;
    }

    //Set details of a student
    public void set(student newStudent) {
        this.setForename(newStudent.forename);
        this.setSurname(newStudent.surname);
    }

    //Get forename of student
    public String getForename() {
        return forename;
    }

    //Set forename of student
    public void setForename(String forename) {
        this.forename = forename;
    }

    //Get surname of student
    public String getSurname() {
        return surname;
    }

    //Set surname of student
    public void setSurname(String surname) {
        this.surname = surname;
    }

    //Get exam score of student
    public int getExamScore() {
        return examScore;
    }

    //Set exam score of student
    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }

    //Get exam grade of student
    public String getExamGrade() {
        return examGrade;
    }

    //Set exam score of student
    public void setExamGrade(String examGrade) {
        this.examGrade = examGrade;
    }
}
