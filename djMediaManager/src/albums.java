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
        String result = "[" + "{" + current.getArtistName() + ", " + current.getAlbumName() + "}, ";

        while (current.getNext() != null) {
            result = result + "{" + current.getNext().getArtistName() + ", " + current.getNext().getAlbumName() + "}, ";
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
        if (siz != 0) {
            do {
                madeSwap = false;
                for (int i = 0; i < siz ; i = i + 1) {
                    if (tempArray != null) {
                        if (tempArray.getNext() != null) {
                            if (tempArray.getAlbumName().compareTo(tempArray.getNext().getAlbumName()) > 0) {

                                album temp = tempArray;
                                album prev = tempArray.getPrevious();
                                album next = tempArray.getNext();

                                album nextandOne;
                                if (tempArray.getNext().getNext() == null) {
                                    nextandOne = null;
                                } else {
                                    nextandOne = tempArray.getNext().getNext();
                                }

                                if(prev == null) {
                                    //changer 1
                                    next.setPrevious(null);
                                    next.setNext(temp);
                                    //changer 2
                                    temp.setNext(nextandOne);
                                    temp.setPrevious(next);
                                    //next's next's prev
                                    nextandOne.setPrevious(temp);

                                } else if(nextandOne == null) {
                                    //changer 1
                                    next.setPrevious(prev);
                                    next.setNext(temp);
                                    //changer 2
                                    temp.setNext(null);
                                    temp.setPrevious(next);
                                    //prev's next
                                    prev.setNext(next);
                                } else {
                                    //changer 1
                                    next.setPrevious(prev);
                                    next.setNext(temp);
                                    //changer 2
                                    temp.setNext(nextandOne);
                                    temp.setPrevious(next);
                                    //prev's next
                                    prev.setNext(next);
                                    // next next's prev
                                    nextandOne.setPrevious(temp); ////here
                                }

                                madeSwap = true;
                            }
                        }

                    }

                    if (tempArray.getNext() == null) {
                        tempArray = head;
                    } else {
                        tempArray = tempArray.getNext();
                    }
                }
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
        boolean foundStart = false;

        while (!foundStart) {
            if (tempArray != null) {
                this.head = tempArray;
            }
            if (tempArray.getPrevious() == null) {
                foundStart = true;
            } else {
                tempArray = tempArray.getPrevious();
            }
        }

        this.head = tempArray;
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