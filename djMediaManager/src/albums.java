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

    public int getArtistCount() {
        int size = 0;
        int counter = 0;
        String[] tempList = new String[50];
        if (head != null) {
            size++;
            album current = head;
            while (current.getNext() != null) {
                boolean found = false;
                for (String n:tempList
                     ) {
                    if(n == current.getArtistName()){
                        found = true;
                    }
                }
                if (!found) {
                    tempList[counter] = current.getArtistName();
                    size++;
                    counter++;
                }
                current = current.getNext();
            }
        }
        return size;
    }

    public void bubbleSort() {
        int initialCount = getSize();
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
                tempArray = resetHead(tempArray);

            } while (madeSwap);
        }

        if(initialCount != getSize()) {
            System.out.println("Error: Sizes do not match after bubble sort.");
        }

        //Reset head to temp
        this.head = tempArray;
    }

    public album resetHead(album tempArray) {
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

    public boolean contains (String searchkey) {
        albums current = this;
        if (current.head.getAlbumName().equals (searchkey)) {
            current.head = resetHead(current.head);
            return true;
        }
        if (current.head.getAlbumName().compareTo (searchkey) < 0) {
            if (current.head.getNext() == null) {
                return false;
            } else {
                current.head = current.head.getNext();
                if(current.contains(searchkey)) {
                    return true;
                }
            }
        }
        current.head = resetHead(current.head);
        return false;
    }
}