public class testStudent {
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

    // Main method to run tests.
    public static void main (String[] args) {

        student album = dataLists.getDataLists();
        classOfStudents studentList = new classOfStudents();
        studentList.setHead(album);

        //Test get album and get artist
        checkStringValues(studentList.getHead().getForename(),"Robert");
        checkStringValues(studentList.getHead().getSurname(),"Lynn");

        //Test get next via get album and get artist
        checkStringValues(studentList.getHead().getNext().getForename(),"Daisy");
        checkStringValues(studentList.getHead().getNext().getSurname(),"Flowers");

        //using set head method
        studentList.setHead(studentList.getHead().getNext().getNext());

        //Testing set head was successful
        checkStringValues(studentList.getHead().getForename(),"Gerrie");
        checkStringValues(studentList.getHead().getSurname(),"Bennett");

        //using set previous method
        studentList.getHead().setPrevious(new student(studentList.getHead(),"Mike", "Crew"));

        //Testing set previous was successful via the get previous
        checkStringValues(studentList.getHead().getPrevious().getForename(),"Mike");
        checkStringValues(studentList.getHead().getPrevious().getSurname(),"Crew");

        //using set methods
        studentList.getHead().setForename("John");
        studentList.getHead().setSurname("Barns");//(albumList.getHead().getNext().getNext());

        //Testing set was successful
        checkStringValues(studentList.getHead().getForename(),"John");
        checkStringValues(studentList.getHead().getSurname(),"Barns");

        //using set methods
        studentList.getHead().set(new student(studentList.getHead().getNext(), "Rose", "Timpson"));

        //Testing set was successful
        checkStringValues(studentList.getHead().getForename(),"Rose");
        checkStringValues(studentList.getHead().getSurname(),"Timpson");

        if(!errorTrigger){
            System.out.println("Tests complete: All tests passed, No errors found");
        }
    }
}
