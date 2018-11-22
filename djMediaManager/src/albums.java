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
        album current = head;
        while (current.getNext() != null) {
            size++ ;
            current = current.getNext();
        }
        return size;

    }

    //TODO: convert string sort to albums in list

    public static int[] selectionSort (albums numbers) {
        int t = 0;
        albums tempArray = numbers;

        if(numbers.getSize()  != 0) {
            do {
                int smallest = findSmallestNumberIndex (numbers, t);
                if(numbers[t] != smallest) {

                    swap (numbers, t, smallest);
                }
                t = t + 1;
            } while (t != numbers.length );
        }

        return numbers;
    }

    public static int findSmallestNumberIndex(albums array, int start) {
        int small = start;
        for (int i = start; i < array.getSize(); i++) {
            if(array[i] < array[small]) {
                small = i;
            }
        }
        return small;
    }

    public static void swap (String[] words, int i1, int i2) {
        String temp;

        temp = words[i1];
        words[i1] = words[i2];
        words[i2] = temp;
    }

    public static void doInsert(String[]words, int counter) {
        String mover = words[counter];
        for (int i = 0; i < counter; i++) {
            System.out.println(words[i].compareTo(mover));
            if(words[i].compareTo(mover) > 0) {
                swap(words, i, counter);
            } else {

            }
        }
    }

    public static String[] insertionSort (String[] words) {
        int t = 0;
        String[] tempArray = words;

        if(words.length != 0) {
            do {
                doInsert (words, t);
                t = t + 1;
            } while (t != words.length);
        }
        return words;
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