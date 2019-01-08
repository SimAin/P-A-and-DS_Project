public class testScoreToGrade {
    //Setting up the grade tree
    //This is also the test for the setGrades method, as, if it dose not work as expected, all the following tests would fail.
    static scoreToGrade<Integer> gradeNode = scoreToGrade.setGrades(95,85,75,65,45,20);
    static boolean errorTrigger = false;

    public static boolean checkStringValues(String data, String expected) {
        if(data.equals(expected)) {
            return false;
        } else {
            errorTrigger = true;
            System.out.println("expected: " + expected);
            System.out.println("actual: " + data);
            System.out.println(" ");
        }
        return true;
    }

    public static boolean checkIntValues(int data, int expected) {
        if(data == expected) {
            return false;
        } else {
            errorTrigger = true;
            System.out.println("expected: " + expected);
            System.out.println("actual: " + data);

        }
        return true;
    }

    // Main method to run tests.
    public static void main (String[] args) {

        //Testing get lowest score, get highest score and get grade methods
        checkIntValues(gradeNode.getLowestScore(), 65);
        checkIntValues(gradeNode.getHighestScore(), 74);
        checkStringValues(gradeNode.getGrade(), "C");

        //Testing get left child and get right child methods
        scoreToGrade nodeLeft = gradeNode.getLeftChild();
        scoreToGrade nodeRight = gradeNode.getRightChild();

        checkIntValues(nodeLeft.getLowestScore(), 85);
        checkIntValues(nodeLeft.getHighestScore(), 94);
        checkStringValues(nodeLeft.getGrade(), "A");

        checkIntValues(nodeRight.getLowestScore(), 20);
        checkIntValues(nodeRight.getHighestScore(), 44);
        checkStringValues(nodeRight.getGrade(), "F");

        //Set up for testing set grade
        classOfStudents new_class = new classOfStudents(2, 1);
        student[] students = new student[2];
        students[0] = new student( "Bruce", "Springer");
        students[1] = new student( "Alexa", "Anderson");
        new_class.setStudents(students);
        new_class.getStudents()[0].setExamScore(96);
        new_class.getStudents()[1].setExamScore(46);

        //Testing set grade method
        gradeNode.setGrade(new_class);
        checkStringValues(new_class.getStudents()[0].getExamGrade(), "A*");
        checkStringValues(new_class.getStudents()[1].getExamGrade(), "D");

        //Testing set child methods
        gradeNode.setLeftChild(nodeRight);
        gradeNode.setRightChild(nodeLeft);

        //Testing output of set child methods.
        checkIntValues(nodeRight.getLowestScore(), 20);
        checkIntValues(nodeRight.getHighestScore(), 44);
        checkStringValues(nodeRight.getGrade(), "F");

        checkIntValues(nodeLeft.getLowestScore(), 85);
        checkIntValues(nodeLeft.getHighestScore(), 94);
        checkStringValues(nodeLeft.getGrade(), "A");

        if(!errorTrigger) {
            System.out.println("All tests passed, no errors found.");
        }
    }
}