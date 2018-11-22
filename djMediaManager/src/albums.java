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
        if(head != null){
            size++;
            album current = head;
            while (current.getNext() != null) {
                size++ ;
                current = current.getNext();
            }
        }
        return size;

    }



    //TODO: convert string sort to albums in list

    public void bubbleSort () {
        boolean madeSwap;
        album tempArray = head;
        int siz = this.getSize();
        System.out.println(siz);
        if (siz != 0)
        {
            System.out.println("2");
            do {
                System.out.println("3");
                System.out.println(tempArray.getAlbumName());
                madeSwap = false;
                int count = 0;
                for (int i = 0; i < siz -1; i = i + 1) {
                    System.out.println(tempArray.getAlbumName().compareTo(tempArray.getNext().getAlbumName()));
                    if (tempArray.getAlbumName().compareTo(tempArray.getNext().getAlbumName()) > 0) {
                        System.out.println("5");
                        album temp = tempArray;
                        album temp2 = tempArray.getNext();
                        tempArray.delete(0);
                        tempArray.delete(1);
                        tempArray.insert(temp2, count);
                        tempArray.insert(temp, count+1);


                        System.out.println(tempArray.toString());
                        madeSwap = true;
                    }
                    count++;
                    tempArray = tempArray.getNext();
                }
            } while (madeSwap);
        }
        System.out.println("FINAL + " + tempArray.toString());
        this.head = tempArray;
        //Test sort length was the same as at the start
        /*boolean lengthsError = checkEqualIntArraysLength(tempArray, numbers);
        if(lengthsError) {
            addLengthError(tempArray, numbers);
        }*/

        //return numbers;
    }

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