public class scoreToGrade<T> {
    private int lowestScore;
    private String grade;
    private scoreToGrade<T> leftChild;
    private scoreToGrade<T> rightChild;

    public scoreToGrade(int score, String grade) {
        this.lowestScore = score;
        this.grade = grade;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getTopScore() {
        return lowestScore;
    }

    public void setTopScore(int topScore) {
        this.lowestScore = topScore;
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

    public void setGrade (classOfStudents students) {

        scoreToGrade current = this;
        scoreToGrade reset = this;

        while (students.getHead().getNext() != null) {
            if(current.getRightChild() == null || current.getLeftChild() == null){
                students.getHead().setExamGrade(current.getGrade());
                students.setHead(students.getHead().getNext());
            } else if((students.getHead().getexamScore() > current.getTopScore()) && (students.getHead().getexamScore() < this.getLeftChild().getTopScore())){
                students.getHead().setExamGrade(current.getGrade());
                students.setHead(students.getHead().getNext());
                current = reset;
            } else if (students.getHead().getexamScore() > current.getTopScore()){
                current = current.getLeftChild();
                //setGrade(students);
            } else if (students.getHead().getexamScore() < current.getTopScore()){
                current = current.getRightChild();
                //setGrade(students);
            }
        }

         students.setHead(resetHead(students.getHead()));
    }

    //TODO move to students
    public student resetHead(student tempArray) {
        boolean foundStart = false;
        while (!foundStart) {
            if (tempArray.getPrevious() == null) {
                foundStart = true;
            } else {
                tempArray = tempArray.getPrevious();
            }
        }
        return tempArray;
    }
}
