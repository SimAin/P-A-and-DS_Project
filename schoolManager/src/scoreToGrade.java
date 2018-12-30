public class scoreToGrade<T> {
    private int lowestScore;
    private int highestScore;
    private String grade;
    private scoreToGrade<T> leftChild;
    private scoreToGrade<T> rightChild;

    public scoreToGrade(int lscore, int hscore, String grade) {
        this.lowestScore = lscore;
        this.highestScore = hscore;
        this.grade = grade;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getLowestScore() {
        return lowestScore;
    }

    public void setLowestScore(int topScore) {
        this.lowestScore = topScore;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public scoreToGrade getLeftChild() {
        return this.leftChild;
    }
    public void setLeftChild(scoreToGrade<T> leftChild) {
        this.leftChild = leftChild;
    }

    public scoreToGrade getRightChild() {
        return this.rightChild ;
    }
    public void setRightChild(scoreToGrade<T> rightChild) {
        this.rightChild = rightChild;
    }

    public void showTree () {

        System.out.println ("Node: " + grade);   // Pre Order
        if (leftChild != null) {
            leftChild.showTree ();
        }
        //System.out.println ("Node: " + grade);   // Order
        if (rightChild != null) {
            rightChild.showTree ();
        }
        //System.out.println ("Node: " + grade);  // Post Order
    }

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
}
