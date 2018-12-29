import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class schoolManager {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main (String[] args) throws IOException {

        boolean exit = false;

        scoreToGrade<Integer> nodeAA = new scoreToGrade<>(95,100, "A*");
        scoreToGrade<Integer> nodeA = new scoreToGrade<>(85, 94, "A");
        scoreToGrade<Integer> nodeB = new scoreToGrade<>(75, 84, "B");
        scoreToGrade<Integer> nodeC = new scoreToGrade<>(65, 74, "C");
        scoreToGrade<Integer> nodeD = new scoreToGrade<>(45, 64, "D");
        scoreToGrade<Integer> nodeF = new scoreToGrade<>(20, 44, "F");
        scoreToGrade<Integer> nodeU = new scoreToGrade<>(0,  19,"U");

        nodeC.setLeftChild(nodeA);
        nodeC.setRightChild(nodeF);
        nodeA.setLeftChild(nodeAA);
        nodeA.setRightChild(nodeB);
        nodeF.setLeftChild(nodeD);
        nodeF.setRightChild(nodeU);

        scoreToGrade<Integer> node = nodeC;

        student topStudent = dataLists.getDataList1();
        classOfStudents y7c2 = new classOfStudents(topStudent, new staffMember("Mrs Simpson", "", "Year7 Teacher", null));

        while (!exit) {
            System.out.println();
            System.out.println("The students listed above have been imported");
            System.out.println("Please type 'view' to see students:");
            System.out.println("Please type 'sort' to sort them by surname:");
            System.out.println("Please type 'score' to run through them and apply scores:");
            System.out.println("To skip and apply random scores for testing, please type 'random':");
            System.out.println("To search for a student type 'search':");
            System.out.println("To set grades please type 'grade':");
            System.out.println("To get class size please type 'count':");
            System.out.println("To add a new student please type 'add' and to delete a student please type 'delete'"); //TODO: add delete
            System.out.println("Please type 'exit' to end:");
            String input = (br.readLine());

            if(input.equals("sort") || input.equals("sort")) {
                y7c2.sortStudentsBySurname();
                printing(y7c2);

            } else if(input.equals("search") || input.equals("Search")) {
                //TODO searching(head);
            } else if(input.equals("view") || input.equals("View")) {
                printing(y7c2);

            }else if(input.equals("score") || input.equals("Score")) {
                y7c2.setScores(br);
            }else if(input.equals("grade") || input.equals("Grade")) {
                node.setGrade(y7c2);

            }else if(input.equals("random") || input.equals("Random")) {
                y7c2.setRandomScores();
                System.out.println(y7c2.toString());
            } else if(input.equals("count") || input.equals("Count")) {
                System.out.println("Class size:  " + y7c2.getSize());

            } else if(input.equals("add") || input.equals("Add")) {
                System.out.println("Please type new students first name:");
                String new_student_f = (br.readLine());
                System.out.println("Please type new students last name:");
                String new_student_s = (br.readLine());

                y7c2.addStudent(new_student_f,new_student_s );
            } else if(input.equals("exit")){

                exit = true;
            } else {
                System.out.println("Error please try again.");
            }
        }



        /*staffMember headTeacher = new staffMember("Gorden", "Newport", "Headteacher", null);

        student topStudent = dataLists.getDataList1();
        classOfStudents y7c2 = new classOfStudents(topStudent, new staffMember("Mrs Simpson", "", "Year7 Teacher", headTeacher), "y7c2");

        System.out.println(y7c2.toString());
        y7c2.setRandomScores();
        y7c2.sortStudentsBySurname();

        student topStudent2 = dataLists.getDataList1();
        classOfStudents y8c1 = new classOfStudents(topStudent2, new staffMember("Mr Rodgers", "", "Year8 Teacher", headTeacher), "y8c1");

        System.out.println(y7c2.toString());
        y8c1.setRandomScores();
        y8c1.sortStudentsBySurname();

        scoreToGrade<Integer> nodeAA = new scoreToGrade<>(95,100, "A*");
        scoreToGrade<Integer> nodeA = new scoreToGrade<>(85, 94, "A");
        scoreToGrade<Integer> nodeB = new scoreToGrade<>(75, 84, "B");
        scoreToGrade<Integer> nodeC = new scoreToGrade<>(65, 74, "C");
        scoreToGrade<Integer> nodeD = new scoreToGrade<>(45, 64, "D");
        scoreToGrade<Integer> nodeF = new scoreToGrade<>(20, 44, "F");
        scoreToGrade<Integer> nodeU = new scoreToGrade<>(0,  19,"U");

        nodeC.setLeftChild(nodeA);
        nodeC.setRightChild(nodeF);
        nodeA.setLeftChild(nodeAA);
        nodeA.setRightChild(nodeB);
        nodeF.setLeftChild(nodeD);
        nodeF.setRightChild(nodeU);

        scoreToGrade<Integer> node = nodeC;

        node.showTree();

        System.out.println();
        node.setGrade(y7c2);
        System.out.println(y7c2.getTeacher().getForename() + " " + y7c2.getTeacher().getSurname());
        System.out.println(y7c2.gradesToString());
        System.out.println(y7c2.getClassScoreAverage());

        System.out.println();
        node.setGrade(y8c1);
        System.out.println(y8c1.getTeacher().getForename() + " " + y8c1.getTeacher().getSurname());
        System.out.println(y8c1.gradesToString());
        System.out.println(y8c1.getClassScoreAverage());*/
    }

    public static void printing(classOfStudents head){
        System.out.println("Class:  ");
        System.out.println(head.toString());
        System.out.println();
    }
}
