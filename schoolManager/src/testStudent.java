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

        classOfStudents schoolClass = new classOfStudents();
        schoolClass.setStudents(dataLists.getDataList1(35));

        //Test get album and get artist
        checkStringValues(schoolClass.getStudents()[1].getForename(),"Robert");
        checkStringValues(schoolClass.getStudents()[1].getSurname(),"Lynn");

        //Test get next via get album and get artist
        checkStringValues(schoolClass.getStudents()[2].getForename(),"Daisy");
        checkStringValues(schoolClass.getStudents()[2].getSurname(),"Flowers");

        //TODO: Update methods for array
        //using set head method
        //schoolClass.getStudents()[1].set(schoolClass.getHead().getNext().getNext());

        //Testing set head was successful
        //checkStringValues(schoolClass.getHead().getForename(),"Gerrie");
        //checkStringValues(schoolClass.getHead().getSurname(),"Bennett");

        //using set previous method
        //schoolClass.getHead().setPrevious(new student(schoolClass.getHead(),"Mike", "Crew"));

        //Testing set previous was successful via the get previous
        //checkStringValues(schoolClass.getHead().getPrevious().getForename(),"Mike");
        //checkStringValues(schoolClass.getHead().getPrevious().getSurname(),"Crew");

        //using set methods
        //schoolClass.getHead().setForename("John");
        //schoolClass.getHead().setSurname("Barns");//(albumList.getHead().getNext().getNext());

        //Testing set was successful
        //checkStringValues(schoolClass.getHead().getForename(),"John");
        //checkStringValues(schoolClass.getHead().getSurname(),"Barns");

        //using set methods
        //schoolClass.getHead().set(new student(schoolClass.getHead().getNext(), "Rose", "Timpson"));

        //Testing set was successful
        //checkStringValues(schoolClass.getHead().getForename(),"Rose");
        //checkStringValues(schoolClass.getHead().getSurname(),"Timpson");

        if(!errorTrigger){
            System.out.println("Tests complete: All tests passed, No errors found");
        }
    }
}
