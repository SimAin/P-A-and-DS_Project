public class student {
    private student next;
    private student previous;

    private String forename;
    private String surname;

    private int examScore = 0;
    private String examGrade;

    public student(student next, String forename, String surname) {
        this.next = next;
        this.forename = forename;
        this.surname = surname;
    }

    public void set(student newStudent) {
        this.setNext(newStudent.next);
        this.setPrevious(newStudent.previous);
        this.setForename(newStudent.forename);
        this.setSurname(newStudent.surname);
    }

    public student getNext() {
        return next;
    }

    public void setNext(student next) {
        this.next = next;
    }

    public student getPrevious() {
        return previous;
    }

    public void setPrevious(student previous) {
        this.previous = previous;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setexamScore(int examScore) {
        this.examScore = examScore;
    }

    public int getexamScore() {
        return examScore;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getExamGrade() {
        return examGrade;
    }

    public void setExamGrade(String examGrade) {
        this.examGrade = examGrade;
    }
}
