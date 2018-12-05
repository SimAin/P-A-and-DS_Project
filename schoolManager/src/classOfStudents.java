import java.util.Random;
public class classOfStudents {
    private String teacher; // TODO: swap string to StaffMember
    private String className;

    private student head;

    public classOfStudents(student head, String teacher, String className) { // TODO: swap string to StaffMember
        this.head = head;
        this.teacher = teacher;
        this.className = className;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public student getHead() {
        return head;
    }

    public void setHead(student head) {
        this.head = head;
    }

    @Override
    public String toString() {
        student current = head;
        String result = "\n{" + current.getSurname() + ", " + current.getForename() + "}, ";

        while (current.getNext() != null) {
            result = result + "\n{" + current.getNext().getSurname() + ", " + current.getNext().getForename() + "}, ";
            current = current.getNext();
        }
        return result;
    }

    public String scoresToString() {
        student current = head;
        String result = "\n{" + current.getSurname() + ", " + current.getForename() + ", " + current.getexamScore() +"}, ";

        while (current.getNext() != null) {
            result = result + "\n{" + current.getNext().getSurname() + ", " + current.getNext().getForename() + ", " + current.getexamScore() + "}, ";
            current = current.getNext();
        }
        return result;
    }

    //Test method to
    public void setRandomScores(){
        Random rand = new Random();
        student current = head;
        while (current.getNext() != null) {
            current.setexamScore(rand.nextInt(80) + 20);
            current = current.getNext();
        }

        while (current.getPrevious() != null) {
            current = current.getPrevious();
        }
    }
}
