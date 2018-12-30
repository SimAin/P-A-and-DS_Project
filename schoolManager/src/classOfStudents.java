import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;

public class classOfStudents {
    private staffMember teacher;

    private student[] students;
    private int currentSize;
    private int maximumSize;

    public classOfStudents( staffMember teacher, int maximumSize, int currentSize) {
        this.students = new student[maximumSize];
        this.maximumSize = maximumSize;
        this.currentSize = currentSize;

        this.teacher = teacher;
    }

    public classOfStudents() {
        this.students = null;
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
        if (currentSize != maximumSize){
            students[currentSize + 1] = new student(forename, surname);
            currentSize = currentSize + 1;
        } else {
            System.out.println("Class is currently at full capacity");
        }
    }

    //TODO:
    //Sorts students by surname
    /*public void sortStudentsBySurname() {
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
        this.assignId();
    }*/

    //TODO:
    //Swaps students in list, used for sort
    /*private student swap(student tempArray) {
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
    }*/

    //Returns array of students
    public student[] getStudents() {
        return students;
    }

    //Sets array of students
    public void setStudents(student[] students) {
        this.students = students;
    }

    //Gets size of class
    public int getCurrentSize() {
        return currentSize;
    }

    //Returns an average of all students grades for teachers
    public int getClassScoreAverage() {
        int totalScore = 0;
        if (currentSize != 0) {
            for (int i = 0; i < currentSize; i++) {
                if(students[i].getExamScore() != 0){
                    totalScore = totalScore + students[i].getExamScore();
                }
            }
        }
        return totalScore / currentSize;
    }

    //Returns a string with all students, their scores and grades
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < currentSize; i++) {
            result = result + "\n{"  + students[i].getSurname() + ", " + students[i].getForename() + ", " + students[i].getExamScore() + ", " + students[i].getExamGrade() + "}, ";
        }

        return result;
    }

    //Iterates through class asking teacher to set scores for students
    public void setScores(BufferedReader br) throws IOException {

        for (int i = 0; i < currentSize; i++) {
            System.out.println("Please type score for: " + students[i].getForename() + " " + students[i].getSurname());
            int score = Integer.parseInt((br.readLine()));
            students[i].setExamScore(score);
        }
    }

    //TEST METHOD - To set random scores as examples
    public void setRandomScores(){
        Random rand = new Random();
        for (int i = 0; i < currentSize; i++) {
            students[i].setExamScore(rand.nextInt(80) + 20);
        }
    }

    //TODO:
    /*public boolean binarySearch (int[] unNnumbers, String toFind) {
        //Can use any sort, currently insertion

        sortStudentsBySurname();
        student current = head;
        //int[] numbers = SortLibrary.insertionSort(unNnumbers);
        int l = 0;
        int r = getSize() - 1;

        while (l <= r) {
            int m = (l + r)/2;  // compute index of middle-ish number

            if (toFind == numbers[m]) {       // SUCCESS! We found our number, so return its index
                return true;
            } else if (toFind < numbers[m]) { // choose the LEFT part
                r = m-1;
            } else { // (toFind > numbers[m])  choose the RIGHT part
                l = m+1;
            }
        }

        // we get here if the number has not been found
        return false;
    }*/
}
