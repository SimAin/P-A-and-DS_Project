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

    //Returns array of students
    public student[] getStudents() {
        return students;
    }

    //Sets array of students
    public void setStudents(student[] students) {
        this.students = students;
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

    //Incision sort algorithm for students by students surname
    public student[] sortStudentsBySurname () {

        int t = 0;
        student[] tempArray = students;
        if(tempArray.length != 0) {
            do {
                doInsert (tempArray, t);
                t++;
            } while (t != currentSize);
        }

        return tempArray;
    }

    //Insert function for incision sort
    public void doInsert(student[] temp_students, int counter) {
        student mover = temp_students[counter];
        for (int i = 0; i < counter; i++) {
            System.out.println(temp_students[i].getSurname().compareTo(mover.getSurname()));
            if(temp_students[i].getSurname().compareTo(mover.getSurname()) > 0) {
                swap(temp_students, i, counter);
            }
        }
    }

    //Swaps students in list, used in insert method
    private student[] swap(student[] tempArray, int i1, int i2) {
        student temp;

        temp = tempArray[i1];
        tempArray[i1] = tempArray[i2];
        tempArray[i2] = temp;

        return tempArray;
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
        int r = getCurrentSize() - 1;

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
