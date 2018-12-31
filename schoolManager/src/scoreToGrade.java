import java.io.BufferedReader;
import java.io.IOException;

public class scoreToGrade<T> {
    private int lowestScore;
    private int highestScore;
    private String grade;
    private scoreToGrade<T> leftChild;
    private scoreToGrade<T> rightChild;

    //Constructor class for score to grade
    public scoreToGrade(int lscore, int hscore, String grade) {
        this.lowestScore = lscore;
        this.highestScore = hscore;
        this.grade = grade;
        this.leftChild = null;
        this.rightChild = null;
    }

    //Gets lower boundary of grade
    public int getLowestScore() {
        return lowestScore;
    }

    //Gets higher boundary of grade
    public int getHighestScore() {
        return highestScore;
    }

    //Returns grade
    public String getGrade() {
        return grade;
    }

    //Set grade
    public void setGrade (classOfStudents schoolClass) {

        scoreToGrade current = this;
        scoreToGrade reset = this;
        for (int i = 0; i < schoolClass.getCurrentSize() ; i++) {

            boolean done = false;

            while (!done) {
                //If either of the child nodes are null, it must be that grade so set.
                //OR
                //If the scores are in the bandwidth for the current node set.
                if((current.getRightChild() == null || current.getLeftChild() == null) || (schoolClass.getStudents()[i].getExamScore() <= current.getHighestScore() && schoolClass.getStudents()[i].getExamScore() >= current.getLowestScore())){
                    schoolClass.getStudents()[i].setExamGrade(current.getGrade());
                    current = reset;
                    done = true;
                } else if (schoolClass.getStudents()[i].getExamScore() > current.getHighestScore()){
                    current = current.getLeftChild();
                } else if (schoolClass.getStudents()[i].getExamScore() < current.getLowestScore()){
                    current = current.getRightChild();
                }
            }



        }

    }

    //Returns left child of grade
    public scoreToGrade getLeftChild() {
        return this.leftChild;
    }

    //Sets left child of grade
    public void setLeftChild(scoreToGrade<T> leftChild) {
        this.leftChild = leftChild;
    }

    //Returns right child of grade
    public scoreToGrade getRightChild() {
        return this.rightChild ;
    }

    //Sets right child of Grade
    public void setRightChild(scoreToGrade<T> rightChild) {
        this.rightChild = rightChild;
    }

    //Displays node tree in grade order.
    //(Other orders are commented out.)
    public void showTree () {

        //System.out.println ("Node: " + grade);   // Pre Order
        if (leftChild != null) {
            leftChild.showTree ();
        }
        System.out.println ("Grade: " + grade + " " + lowestScore + " - " + highestScore);   // Order
        if (rightChild != null) {
            rightChild.showTree ();
        }
        //System.out.println ("Node: " + grade);  // Post Order
    }

    //Sets node tree to given grade boundaries
    public static scoreToGrade<Integer> setGrades(int AA, int A, int B, int C, int D, int F) {
        scoreToGrade<Integer> nodeAA = new scoreToGrade<>(AA,100, "A*");
        scoreToGrade<Integer> nodeA = new scoreToGrade<>(A, AA-1, "A");
        scoreToGrade<Integer> nodeB = new scoreToGrade<>(B, A-1, "B");
        scoreToGrade<Integer> nodeC = new scoreToGrade<>(C, B-1, "C");
        scoreToGrade<Integer> nodeD = new scoreToGrade<>(D, C-1, "D");
        scoreToGrade<Integer> nodeF = new scoreToGrade<>(F, D-1, "F");
        scoreToGrade<Integer> nodeU = new scoreToGrade<>(0,  F-1,"U");

        nodeC.setLeftChild(nodeA);
        nodeC.setRightChild(nodeF);
        nodeA.setLeftChild(nodeAA);
        nodeA.setRightChild(nodeB);
        nodeF.setLeftChild(nodeD);
        nodeF.setRightChild(nodeU);

        return nodeC;
    }

    //Takes user input, verifies it, then sets it to grade tree.
    public static scoreToGrade<Integer> customGrades(BufferedReader br) throws IOException {
        boolean math_error = true;
        int AA,A,B= 0,C= 0,D= 0,F = 0;

        do {
            System.out.println("Type lower boundary for A* grade  :");
            AA = Integer.parseInt((br.readLine()));
            System.out.println("Type lower boundary for A grade  :");
            A = Integer.parseInt((br.readLine()));
            if(!(A >= AA)){
                System.out.println("Type lower boundary for B grade  :");
                B = Integer.parseInt((br.readLine()));
                if(!(B >= A)){
                    System.out.println("Type lower boundary for C grade  :");
                    C = Integer.parseInt((br.readLine()));
                    if(!(C >= B)){
                        System.out.println("Type lower boundary for D grade  :");
                        D = Integer.parseInt((br.readLine()));
                        if(!(D >= C)) {
                            System.out.println("Type lower boundary for F grade  :");
                            F = Integer.parseInt((br.readLine()));
                            if(!(F >= D)){
                                math_error = false;
                            }
                        }
                    }
                }
            }
            if (math_error) {
                System.out.println("Numeric error, one boundary overlapped another. Please retry.");
            }
        } while (math_error);
        return scoreToGrade.setGrades(AA,A,B,C,D,F);
    }
}
