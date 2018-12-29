public class album {
    private album next;
    private album previous;

    private String artistName;
    private  String albumName;

    //Constructor method for album
    public album (album next, String artistName, String albumName) {
        this.next = next;
        this.artistName = artistName;
        this.albumName = albumName;
    }

    //Sets an album
    public void set(album newA) {
        this.setAlbumName(newA.albumName);
        this.setArtistName(newA.artistName);
    }

    //Returns next in list
    public album getNext() {
        return next;
    }

    //Sets next in list
    public void setNext(album next) {
        this.next = next;
    }

    //Gets previous album in list
    public album getPrevious() {
        return previous;
    }

    //Sets previous album in list
    public void setPrevious(album previous) {
        this.previous = previous;
    }

    //Returns name of album
    public String getArtistName() {
        return artistName;
    }

    //Sets artist name
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    //Returns album name
    public String getAlbumName() {
        return albumName;
    }

    //Sets album name
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    //Appends new album to bottom of the list
    public void join (album data) {
        album current = this;

        while (current.getNext () != null) {
            current = current.getNext ();
        }

        current.setNext (new album (null, data.artistName, data.albumName));
    }

    //TODO: implement
    //Deletes album from list
    public album delete (int index) {
        album current = this;
        int currentIndex = 0;

        if (index == 0) {
            return next;
        }

        while (current != null) {
            if (currentIndex+1 == index) {
                if(current.getNext() != null) {
                    current.setNext ( current.getNext().getNext());
                }


                return this; // remember, the delete method was called on the first item
            }
            currentIndex += 1;
            current = current.getNext ();
        }
        throw new ArrayIndexOutOfBoundsException (index);
    }
}

