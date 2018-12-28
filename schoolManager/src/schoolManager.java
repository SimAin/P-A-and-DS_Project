public class schoolManager {

    public static void main (String[] args) {

        staffMember headTeacher = new staffMember("Gorden", "Newport", "Headteacher", null);

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
        System.out.println(y8c1.getClassScoreAverage());
    }
}
