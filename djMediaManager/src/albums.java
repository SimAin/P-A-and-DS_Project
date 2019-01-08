public class albums {
    private album head;

    //Constructor for albums
    public albums() {
        head = null;
    }

    //Sets head of list
    public void setHead(album head) {
        this.head = head;
    }

    //Gets head of list
    public album getHead() {
        return head;
    }

    //Returns sting of list of albums with artist and album printed
    @Override
    public String toString() {
        album current = head;
        String result = "\n{" + current.getArtistName() + ", " + current.getAlbumName() + "}, ";

        while (current.getNext() != null) {
            result = result + "\n{" + current.getNext().getArtistName() + ", " + current.getNext().getAlbumName() + "}, ";
            current = current.getNext();
        }
        return result;
    }

    //Returns size of collection
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

    //Returns number of different artists in list
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

    //Does a sort of the collection by artist
    public void artistBubbleSort() {
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
                            if (tempArray.getArtistName().compareTo(tempArray.getNext().getArtistName()) > 0) {
                                //Swap items
                                swap(tempArray);
                                madeSwap = true;
                            } else if ((tempArray.getArtistName().compareTo(tempArray.getNext().getArtistName()) == 0) && (tempArray.getArtistName().compareTo(tempArray.getNext().getArtistName()) > 0)) {
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
        //Reset head to temp
        this.head = tempArray;
    }

    //Does a sort of the albums by artist
    public void albumBubbleSort() {
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

        //Reset head to temp
        this.head = tempArray;
    }

    //Resets the head of the list after an iteration
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

    //Swaps two albums, used in sorting
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

    //Search method for the albums
    public boolean contains (String searchkey, boolean decision) {
        albums current = this;
        boolean equal;
        if(decision){
            equal = current.head.getAlbumName().equals (searchkey);
        } else {
            equal = current.head.getArtistName().equals (searchkey);
        }
        if (equal) {
            current.head = resetHead(current.head);
            return true;
        } else {
            if (current.head.getNext() == null) {
                return false;
            } else {
                current.head = current.head.getNext();
                if(current.contains(searchkey, decision)) {
                    return true;
                }
            }
        }
        current.head = resetHead(current.head);
        return false;
    }

    //Deletes album from list
    public void delete (String AlbumToDelete) {
        boolean found = false;
        if(!contains(AlbumToDelete, true)){
            System.out.println("Album not found please try again.");
        } else {

            do{
                head = head.getNext();
                if(head.getAlbumName().equals(AlbumToDelete)){
                    found = true;
                }
            }
            while (!found);
            head.getNext().setPrevious(head.getPrevious());
            head.getPrevious().setNext(head.getNext());
            resetHead(head);
            System.out.println("Album " + AlbumToDelete + " successfully deleted.");
        }
    }
}