public class testStudent {
    public static boolean errorTrigger = false;
    static scoreToGrade<Integer> gradeNode = scoreToGrade.setGrades(95,85,75,65,45,20);

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
            System.out.println(" ");
        }
        return true;
    }

    // Main method to run tests.
    public static void main (String[] args) {

        student[] studentList;
        studentList = dataLists.getDataList1(35);
        classOfStudents schoolClass = new classOfStudents( 35, 23);
        schoolClass.setStudents(studentList);

        //Test get forename and surname
        checkStringValues(schoolClass.getStudents()[0].getForename(),"Gerrie");
        checkStringValues(schoolClass.getStudents()[0].getSurname(),"Bennett");
        checkStringValues(schoolClass.getStudents()[1].getForename(),"Rodger");
        checkStringValues(schoolClass.getStudents()[1].getSurname(),"Smith");

        //Test set forename and set surname
        schoolClass.getStudents()[0].setForename("Pete");
        schoolClass.getStudents()[0].setSurname("Boulder");
        checkStringValues(schoolClass.getStudents()[0].getForename(),"Pete");
        checkStringValues(schoolClass.getStudents()[0].getSurname(),"Boulder");

        //Test get and set exam score
        checkIntValues(schoolClass.getStudents()[0].getExamScore(),0);
        schoolClass.getStudents()[0].setExamScore(45);
        checkIntValues(schoolClass.getStudents()[0].getExamScore(),45);

        //Test get exam grade
        schoolClass.setRandomScores();
        schoolClass.getStudents()[1].setExamScore(99);
        gradeNode.setGrade(schoolClass);
        checkStringValues(schoolClass.getStudents()[1].getExamGrade(),"A*");

        if(!errorTrigger){
            System.out.println("Tests complete: All tests passed, No errors found");
        }
    }
}

