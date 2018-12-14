import java.util.Random;
public class classOfStudents {
    private staffMember teacher; // TODO: swap string to StaffMember
    private String className;

    private student head;

    public classOfStudents(student head, staffMember teacher, String className) { // TODO: swap string to StaffMember
        this.head = head;
        this.teacher = teacher;
        this.className = className;
    }

    public classOfStudents() { // TODO: swap string to StaffMember
        this.head = null;
        this.teacher = null;
        this.className = null;
    }

    public staffMember getTeacher() {
        return teacher;
    }

    public void setTeacher(staffMember teacher) {
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

    public int getSize() {
        int size = 0;
        if (head != null) {
            size++;
            student current = head;
            while (current.getNext() != null) {
                size++;
                current = current.getNext();
            }
        }
        return size;
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

    public String gradesToString() {
        student current = head;
        String result = "\n{" + current.getSurname() + ", " + current.getForename() + ", " + current.getexamScore() + ", " + current.getExamGrade() +"}, ";

        while (current.getNext() != null) {
            result = result + "\n{" + current.getNext().getSurname() + ", " + current.getNext().getForename() + ", " + current.getexamScore() + ", "+ current.getExamGrade() + "}, ";
            current = current.getNext();
        }
        return result;
    }

    public student resetHead(student tempArray){
        boolean foundStart = false;
        while (!foundStart) {
            if (tempArray.getPrevious() == null) {
                foundStart = true;
            } else {
                tempArray = tempArray.getPrevious();
            }
        }
        return tempArray;
    }

    //Test method to set random scores as examples
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
