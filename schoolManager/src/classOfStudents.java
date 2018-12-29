import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;

public class classOfStudents {
    private staffMember teacher;

    private student head;

    public classOfStudents(student head, staffMember teacher) {
        this.head = head;
        this.teacher = teacher;
    }

    public classOfStudents() {
        this.head = null;
        this.teacher = null;
    }

    public staffMember getTeacher() {
        return teacher;
    }

    public void setTeacher(staffMember teacher) {
        this.teacher = teacher;
    }

    //Adds Student to class
    public void addStudent(String forename, String surname) {

        student current = this.head;

        while (current.getNext () != null) {
            current = current.getNext ();
        }

        current.setNext (new student (null, forename, surname));

    }

    //Sorts students by surname
    public void sortStudentsBySurname() {
        int initialCount = getSize();
        boolean madeSwap;
        student tempArray = head;
        int siz = this.getSize();
        //If collection > 0
        if (siz != 0) {
            //Loop through list of students until no swap is made
            do {
                //Set trigger to false for swap
                madeSwap = false;
                //Loop through each student to check for a swap
                for (int i = 0; i < siz ; i = i + 1) {
                    //If next student exists
                    if (tempArray != null) {
                        //If there is an item to swap it with
                        if (tempArray.getNext() != null) {
                            //Compare items to see if they are the right way round.
                            //If not enter statement
                            if (tempArray.getSurname().compareTo(tempArray.getNext().getSurname()) > 0) {
                                //Swap items
                                swap(tempArray);
                                madeSwap = true;
                            } else if ((tempArray.getSurname().compareTo(tempArray.getNext().getSurname()) == 0) && (tempArray.getSurname().compareTo(tempArray.getNext().getSurname()) > 0)) {
                                //Swap items
                                swap(tempArray);
                                madeSwap = true;
                            }
                        }
                    }
                    //Set the current head to the next item, unless this is last item
                    if (tempArray.getNext() != null) {
                        tempArray = tempArray.getNext();
                    } else {
                        tempArray = head;
                    }
                }
                //Following loop, reset head of list to start.
                tempArray = resetHead(tempArray);

            } while (madeSwap);
        }
        //Reset head to temp
        this.head = tempArray;
    }

    //Swaps students in list, used for sort
    private student swap(student tempArray) {
        student temp = tempArray;
        student prev = tempArray.getPrevious();
        student next = tempArray.getNext();
        student nextPlusOne = tempArray.getNext().getNext();

        if(prev == null) {  //If first and second items in list
            next.setPrevious(null);
            temp.setNext(nextPlusOne);
            nextPlusOne.setPrevious(temp);

        } else if(nextPlusOne == null) {    //If last and second to last items in list
            next.setPrevious(prev);
            temp.setNext(null);
            prev.setNext(next);
        } else {    //All other swaps
            next.setPrevious(prev);
            temp.setNext(nextPlusOne);
            prev.setNext(next);
            nextPlusOne.setPrevious(temp);
        }
        //Generic swaps
        next.setNext(temp);
        temp.setPrevious(next);

        return tempArray;
    }

    //Returns head of list
    public student getHead() {
        return head;
    }

    //Sets head of class list
    public void setHead(student head) {
        this.head = head;
    }

    //Gets size of class
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

    //Returns an average of all students grades for teachers
    public int getClassScoreAverage() {
        int totalScore = 0;
        if (head != null) {
            student current = head;
            while (current.getNext() != null) {
                if(current.getexamScore() != 0){
                    totalScore = totalScore + current.getexamScore();
                }
                current = current.getNext();
            }
        }
        return totalScore / this.getSize();
    }

    //Returns a string with all students, their scores and grades
    @Override
    public String toString() {
        student current = head;
        String result = "\n{" + current.getSurname() + ", " + current.getForename() + ", " + current.getNext().getexamScore() + ", " + current.getNext().getExamGrade() +"}, ";

        while (current.getNext() != null) {
            result = result + "\n{" + current.getNext().getSurname() + ", " + current.getNext().getForename() + ", " + current.getNext().getexamScore() + ", " + current.getNext().getExamGrade() + "}, ";
            current = current.getNext();
        }
        return result;
    }

    //Used to reset head of list after iterating through list
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

    //Iterates through class asking teacher to set scores for students
    public void setScores(BufferedReader br) throws IOException {

        student current = head;
        while (current.getNext() != null) {
            System.out.println("Please type score for: " + current.getForename() + " " + current.getSurname());
            int score = Integer.parseInt((br.readLine()));
            current.setexamScore(score);
            current = current.getNext();
        }
        //Covers last student in list
        System.out.println("Please type score for: " + current.getForename() + " " + current.getSurname());
        int score = Integer.parseInt((br.readLine()));
        current.setexamScore(score);

        while (current.getPrevious() != null) {
            current = current.getPrevious();
        }
    }

    //TEST METHOD - To set random scores as examples
    public void setRandomScores(){
        Random rand = new Random();
        student current = head;
        while (current.getNext() != null) {
            current.setexamScore(rand.nextInt(80) + 20);
            current = current.getNext();
        }
        current.setexamScore(rand.nextInt(80) + 20);

        while (current.getPrevious() != null) {
            current = current.getPrevious();
        }
    }
}
