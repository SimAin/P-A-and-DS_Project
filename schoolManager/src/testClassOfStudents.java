public class testClassOfStudents {
    public static boolean errorTrigger = false;

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

    public static boolean checkBooleanValues(Boolean data) {
        if(data ) {
            return false;
        } else {
            errorTrigger = true;
            System.out.println("expected: True" );
            System.out.println("actual: False" );

        }
        return true;
    }

    // Main method to run tests.
    public static void main (String[] args) {
        student[] studentList;
        studentList = dataLists.getDataList1(35);
        classOfStudents new_class = new classOfStudents( new staffMember("Mrs Simpson", "", "Year7 Teacher", null), 35, 23);

        //Test set array of students
        new_class.setStudents(studentList);

        //Check start order is as expected
        //Enables better data for checking sorting output later
        //Also test to string function
        checkStringValues(new_class.toString(),"\n{Bennett, Gerrie, 0, null}, \n" +
                "{Smith, Rodger, 0, null}, \n" +
                "{Weaver, Lucy, 0, null}, \n" +
                "{White, Dave, 0, null}, \n" +
                "{Parker, Percy, 0, null}, \n" +
                "{Glasper, Beth, 0, null}, \n" +
                "{Blaine, Annie, 0, null}, \n" +
                "{Thorn, Theo, 0, null}, \n" +
                "{Springer, Bruce, 0, null}, \n" +
                "{Allen, Alexa, 0, null}, \n" +
                "{Thompson, John, 0, null}, \n" +
                "{Johnson, Zac, 0, null}, \n" +
                "{Robertson, Janice, 0, null}, \n" +
                "{Piper, Phill, 0, null}, \n" +
                "{Roe, Steph, 0, null}, \n" +
                "{Auger, Ryan, 0, null}, \n" +
                "{McManus, Sam, 0, null}, \n" +
                "{Carr, Ben, 0, null}, \n" +
                "{Little, Eva, 0, null}, \n" +
                "{Skywalker, Luke, 0, null}, \n" +
                "{Jenkins, Gavin, 0, null}, \n" +
                "{Potter, Franky, 0, null}, \n" +
                "{Flowers, Daisy, 0, null}, \n" +
                "{Lynn, Robert, 0, null}, ");
        checkIntValues(new_class.getCurrentSize(),23);

        //Get count for test.
        int count1 = new_class.getCurrentSize();

        //Test adding a student to the class.
        //Test get students class
        new_class.addStudent("New_test_forename", "New_test_surname");
        checkStringValues(new_class.getStudents()[24].getSurname(), "New_test_surname");
        checkStringValues(new_class.getStudents()[24].getForename(), "New_test_forename");

        //Test class counter.
        int count2 = new_class.getCurrentSize();
        checkIntValues(count1+1, count2);

        //Test sorting
        new_class.sortStudentsBySurname();
        checkStringValues(new_class.toString(),"\n{Allen, Alexa, 0, null}, \n" +
                "{Auger, Ryan, 0, null}, \n" +
                "{Bennett, Gerrie, 0, null}, \n" +
                "{Blaine, Annie, 0, null}, \n" +
                "{Carr, Ben, 0, null}, \n" +
                "{Flowers, Daisy, 0, null}, \n" +
                "{Glasper, Beth, 0, null}, \n" +
                "{Jenkins, Gavin, 0, null}, \n" +
                "{Johnson, Zac, 0, null}, \n" +
                "{Little, Eva, 0, null}, \n" +
                "{Lynn, Robert, 0, null}, \n" +
                "{McManus, Sam, 0, null}, \n" +
                "{New_test_surname, New_test_forename, 0, null}, \n" +
                "{Parker, Percy, 0, null}, \n" +
                "{Piper, Phill, 0, null}, \n" +
                "{Potter, Franky, 0, null}, \n" +
                "{Robertson, Janice, 0, null}, \n" +
                "{Roe, Steph, 0, null}, \n" +
                "{Skywalker, Luke, 0, null}, \n" +
                "{Smith, Rodger, 0, null}, \n" +
                "{Springer, Bruce, 0, null}, \n" +
                "{Thompson, John, 0, null}, \n" +
                "{Thorn, Theo, 0, null}, \n" +
                "{Weaver, Lucy, 0, null}, \n" +
                "{White, Dave, 0, null}, ");

        //Test searching
        //Search key: 0 == Full name, 1 == Surname
        checkIntValues(new_class.binarySearch(0,"New_test_surnameNew_test_forename"), 12);
        checkIntValues(new_class.binarySearch(1,"New_test_surname"), 12);

        //Check setting random scores
        new_class.setRandomScores();
        for (int i = 0; i < new_class.getCurrentSize(); i++) {
            if(new_class.getStudents()[i].getExamScore() == 0) {
                System.out.println("Error found in set random scores iterator.");
                errorTrigger = true;
            }
        }

        //Test average scores -
        //All scores are randomly set, therefore average should be greater than 1 and less than 99
        int average = new_class.getClassScoreAverage();
        if(!(average > 1) && !(average < 99)) {
            System.out.println("Error found in get average of scores.");
            errorTrigger = true;
        }

        if(!errorTrigger){
            System.out.println("Tests complete: All tests passed, No errors found");
        }
    }
}
