public class albums {
    private album head;


    public albums() {
        head = null;
    }

    public void setHead(album head) {
        this.head = head;
    }

    public album getHead() {
        return head;
    }

    @Override
    public String toString() {
        album current = head;
        String result = "{" + current.getArtistName() + ", " + current.getAlbumName() + "}, ";

        while (current.getNext() != null) {
            result = result + "{" + current.getNext().getArtistName() + ", " + current.getNext().getAlbumName() + "}, ";
            current = current.getNext();
        }
        return result;
    }

    public String toString(boolean vert) {
        album current = head;
        String result = "\n{" + current.getArtistName() + ", " + current.getAlbumName() + "}, ";

        while (current.getNext() != null) {
            result = result + "\n{" + current.getNext().getArtistName() + ", " + current.getNext().getAlbumName() + "}, ";
            current = current.getNext();
        }
        return result;
    }

    public int getSize() {
        int size = 0;
        if (head != null) {
            size++;
            album current = head;
            while (current.getNext() != null) {
                size++;
                current = current.getNext();
            }
        }
        return size;

    }

    public void bubbleSort() {
        boolean madeSwap;
        album tempArray = head;
        int siz = this.getSize();
        //If collection > 0
        if (siz != 0) {
            //Loop through list of albums until no swap is made
            do {
                //Set trigger to false for swap
                madeSwap = false;
                //Loop through each album to check for a swap
                for (int i = 0; i < siz ; i = i + 1) {
                    //If next album exists
                    if (tempArray != null) {
                        //If there is an item to swap it with
                        if (tempArray.getNext() != null) {
                            //Compare items to see if they are the right way round.
                            //If not enter statement
                            if (tempArray.getAlbumName().compareTo(tempArray.getNext().getAlbumName()) > 0) {
                                //Swap items
                                swap(tempArray);
                                madeSwap = true;
                            }
                        }
                    }
                    //Set the current head to the next item, unless this is last item
                    if (tempArray.getNext() != null) {
                        tempArray = tempArray.getNext();
                    } else {
                        tempArray = head;
                    }
                }
                //Following loop, reset head of list to start.
                boolean foundStart = false;
                while (!foundStart) {
                    if (tempArray.getPrevious() == null) {
                        foundStart = true;
                    } else {
                        tempArray = tempArray.getPrevious();
                    }
                }
            } while (madeSwap);
        }
        //Reset head to temp
        this.head = tempArray;
    }

    private album swap(album tempArray) {
        album temp = tempArray;
        album prev = tempArray.getPrevious();
        album next = tempArray.getNext();
        album nextPlusOne = tempArray.getNext().getNext();

        if(prev == null) {  //If first and second items in list
            next.setPrevious(null);
            temp.setNext(nextPlusOne);
            nextPlusOne.setPrevious(temp);

        } else if(nextPlusOne == null) {    //If last and second to last items in list
            next.setPrevious(prev);
            temp.setNext(null);
            prev.setNext(next);
        } else {    //All other swaps
            next.setPrevious(prev);
            temp.setNext(nextPlusOne);
            prev.setNext(next);
            nextPlusOne.setPrevious(temp);
        }
        //Generic swaps
        next.setNext(temp);
        temp.setPrevious(next);

        return tempArray;
    }

        //Test sort length was the same as at the start
        /*boolean lengthsError = checkEqualIntArraysLength(tempArray, numbers);
        if(lengthsError) {
            addLengthError(tempArray, numbers);
        }*/

        //return numbers;


    /*public boolean contains (String searchkey) {
        albums current = this;
        System.out.println(current.head.getAlbumName());
        if (current.head.getAlbumName().equals (searchkey)) {
            System.out.println("2");
            return true;
        } else if (current.head.getAlbumName().compareTo (searchkey) > 0) {
            System.out.println("3");
            if (current.head.getNext() == null) {
                System.out.println("4");
                return false;
            } else {
                System.out.println("5");
                if(current.head.getNext().getAlbumName().equals (searchkey)) {
                    System.out.println(current.head.getNext().getAlbumName().equals (searchkey));
                    return true;
                } else {
                    System.out.println("7");
                    current.head = current.head.getNext();
                    current.contains(searchkey);
                }
                //root.getLeftChild().contains (searchkey);
            }
        }
        System.out.println("8");
        return false;
    }*/

}