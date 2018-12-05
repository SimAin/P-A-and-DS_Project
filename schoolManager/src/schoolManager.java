public class schoolManager {
    private scoreToGrade<Integer> node;
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
        0-20 = U

        scoreToGrade<Integer> nodeA = new scoreToGrade<>(95, "A*");
        scoreToGrade<Integer> nodeB = new scoreToGrade<>(85, "A");
        scoreToGrade<Integer> nodeC = new scoreToGrade<>(75, "B");

        scoreToGrade<Integer> nodeD = new scoreToGrade<>(65, "C");
        scoreToGrade<Integer> nodeE = new scoreToGrade<>(45, "D");
        scoreToGrade<Integer> nodeF = new scoreToGrade<>(20, "F");
        scoreToGrade<Integer> nodeG = new scoreToGrade<>(0, "U");

        nodeA.setLeftChild(nodeC);
        nodeA.setRightChild(nodeB);
        nodeC.setLeftChild(nodeD);
        nodeC.setRightChild(nodeE);

        node = nodeA;*/
    }
}
