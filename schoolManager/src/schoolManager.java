import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class schoolManager {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static scoreToGrade<Integer> gradeNode = scoreToGrade.setGrades(95,85,75,65,45,20);

    // --- *** ---
    //Main method to run system
    // --- *** ---
    public static void main (String[] args) throws IOException {

        boolean exit = false;

        student[] studentList;
        studentList = dataLists.getDataList1(35);
        classOfStudents currentClass = new classOfStudents( new staffMember("Mrs Simpson", "", "Year7 Teacher", null), 35, 23);
        currentClass.setStudents(studentList);

        while (!exit) {
            menuText();
            String input = (br.readLine());

            if(input.equals("sort") || input.equals("sort")) {
                currentClass.sortStudentsBySurname();
                printing(currentClass);

            } else if(input.equals("search") || input.equals("Search")) {
                System.out.println("To search a full name type 'full', to search a surname, type 'surname', to search a forename, type 'forename': ");
                String searchType = (br.readLine());
                searchOptionsManager(searchType, currentClass);

            } else if(input.equals("view") || input.equals("View")) {
                printing(currentClass);

            } else if(input.equals("score") || input.equals("Score")) {
                currentClass.setScores(br);

            } else if(input.equals("grade") || input.equals("Grade")) {
                gradeOptionsManager(currentClass);

            } else if(input.equals("random") || input.equals("Random")) {
                currentClass.setRandomScores();

                System.out.println(currentClass.toString());
            } else if(input.equals("details") || input.equals("Details")) {
                System.out.println("Class size:  " + currentClass.getCurrentSize());
                System.out.println("Scores average:  " + currentClass.getClassScoreAverage());

            } else if(input.equals("add") || input.equals("Add")) {
                System.out.println("Please type new students first name:");
                String new_student_f = (br.readLine());
                System.out.println("Please type new students last name:");
                String new_student_s = (br.readLine());
                currentClass.addStudent(new_student_f,new_student_s );

            } else if(input.equals("exit")){
                exit = true;

            } else {
                System.out.println("Error please try again.");
            }
        }
    }

    //Block of console text to give user options
    private static void menuText() {
        System.out.println();
        System.out.println("The students listed above have been imported");
        System.out.println("Please type 'view' to see students:");
        System.out.println("Please type 'sort' to sort them by surname:");
        System.out.println("Please type 'score' to run through the students and apply scores:");
        System.out.println("To skip and apply random scores for testing, please type 'random':");
        System.out.println("To search for a student type 'search':");
        System.out.println("To manage grades, set grades or change boundaries (initially set to default) please type 'grade':");
        System.out.println("To get class size and score average please type 'details':");
        System.out.println("To add a new student please type 'add' and to delete a student please type 'delete'"); //TODO: add delete
        System.out.println("Please type 'exit' to end:");
    }

    //Function to manage the options for gradings
    private static void gradeOptionsManager(classOfStudents theClass) throws IOException {
        System.out.println("To see grade structure please type 'display' :");
        System.out.println("To set grades for students please type 'grade' :");
        System.out.println("To change grade boundaries please type 'settings' :");

        String option = (br.readLine());
        if(option.equals("grade") || option.equals("Grade")){
            gradeNode.setGrade(theClass);
        } else if (option.equals("display") || option.equals("Display")){
            gradeNode.showTree();
        } else if (option.equals("settings") || option.equals("Settings")) {
            System.out.println("Type 'default' to set to standard boundaries or 'custom' to set custom options:");
            String grade_choice = (br.readLine());
            if(grade_choice.equals("default") || grade_choice.equals("Default")) {
                gradeNode = scoreToGrade.setGrades(95,85,75,65,45,20);
                gradeNode.showTree();
            } else if (grade_choice.equals("custom") || grade_choice.equals("Custom")) {
                gradeNode = scoreToGrade.customGrades(br);
                gradeNode.showTree();
            } else {
                System.out.println("Error please try again.");
            }
        } else {
            System.out.println("Error please try again.");
        }
    }

    //Function to manage the options for searching for a student
    private static void searchOptionsManager(String searchType, classOfStudents theClass) throws IOException {
        if(searchType.equals("full") || searchType.equals("Full")) {
            System.out.println("Please type the Surname of the student you wish to search for: ");
            String student_sname = (br.readLine());
            System.out.println("Please type the Forename of the student you wish to search for: ");
            String student_fname = (br.readLine());
            int result = theClass.binarySearch(0, student_sname + student_fname);
            searchResults(result, student_sname + ", " + student_fname, theClass);
        } else if(searchType.equals("surname") || searchType.equals("Surname")) {
            System.out.println("Please type the Surname of the student you wish to search for: ");
            String student_name = (br.readLine());
            int result = theClass.binarySearch(1, student_name);
            searchResults(result, student_name, theClass);
        } else if(searchType.equals("forename") || searchType.equals("Forename")) {
            System.out.println("Please type the Forename of the student you wish to search for: ");
            String student_name = (br.readLine());
            int result = theClass.binarySearch(2, student_name);
            searchResults(result, student_name, theClass);
        } else {
            System.out.println("Error please try again: ");
        }
    }

    //Function for managing output based on search results
    private static void searchResults (int result, String search, classOfStudents theClass) {
        if(result == -1) {
            System.out.println("The search for " + search + " did not return any results, please try again.");
        } else {
            System.out.println("The search for " + search + " returned the student: " + theClass.getStudents()[result].getSurname() + ", " + theClass.getStudents()[result].getForename());
        }
    }

    //Method to print students
    private static void printing(classOfStudents head){
        System.out.println("Class:  ");
        System.out.println(head.toString());
        System.out.println();
    }
}
