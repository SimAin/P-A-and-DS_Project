public class testStaffMember {
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

    public static boolean checkStaffValues(staffMember data, staffMember expected) {
        if((data.getForename().equals(expected.getForename())) && (data.getSurname().equals(expected.getSurname())) && (data.getJobTitle().equals(expected.getJobTitle()))) {
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

        staffMember staff = new staffMember("Rogger", "White", "Maths Teacher", null);

        //Testing getters and setters for staff management
        staff.setForename("Rodge");
        staff.setSurname("Peters");
        staff.setJobTitle("Cleaner");
        staff.setSuperior(new staffMember("Lucy", "Cole", "Headteacher", null));

        checkStringValues(staff.getForename(), "Rodge");
        checkStringValues(staff.getSurname(), "Peters");
        checkStringValues(staff.getJobTitle(), "Cleaner");
        checkStaffValues(staff.getSuperior(), new staffMember("Lucy", "Cole", "Headteacher", null));


    }
}
