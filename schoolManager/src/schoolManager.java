public class schoolManager {

    public static void main (String[] args) {

        student topStudent = dataLists.getDataLists();
        classOfStudents y7c2 = new classOfStudents(topStudent, "Mrs Simpson", "y7c2");
        //y7c2.setHead(topStudent);

        System.out.println(y7c2.toString());

        y7c2.setRandomScores();

        System.out.println(y7c2.scoresToString());

        /*95-100 = A*
        85-95 = A
        75-85 = B
        65-75 = C
        45-65 = D
        20-45 = F
        0-20 = U*/

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

        node.setGrade(y7c2);
        System.out.println(y7c2.gradesToString());
    }
}
