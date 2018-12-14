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

        student album = dataLists.getDataLists();
        classOfStudents head = new classOfStudents();
        head.setHead(album);

        //Check start order is as expected
        //Enables better data for checking sorting output later
        checkStringValues(head.toString(),"\n{Lynn, Robert}, \n" +
                "{Flowers, Daisy}, \n" +
                "{Bennett, Gerrie}, \n" +
                "{Potter, Franky}, \n" +
                "{Jenkins, Gavin}, \n" +
                "{Skywalker, Luke}, \n" +
                "{Little, Eva}, \n" +
                "{Carr, Ben}, \n" +
                "{McManus, Sam}, \n" +
                "{Auger, Ryan}, \n" +
                "{Roe, Steph}, \n" +
                "{Piper, Phill}, \n" +
                "{Robertson, Janice}, \n" +
                "{Johnson, Zac}, \n" +
                "{Thompson, John}, \n" +
                "{Allen, Alexa}, \n" +
                "{Springer, Bruce}, \n" +
                "{Thorn, Theo}, \n" +
                "{Blaine, Annie}, \n" +
                "{Glasper, Beth}, \n" +
                "{Parker, Percy}, \n" +
                "{White, Dave}, \n" +
                "{Weaver, Lucy}, \n" +
                "{Smith, Rodger}, ");
        checkIntValues(head.getSize(),24);

        if(!errorTrigger){
            System.out.println("Tests complete: All tests passed, No errors found");
        }
    }
}
