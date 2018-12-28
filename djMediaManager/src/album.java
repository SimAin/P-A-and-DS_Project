public class album {
    private album next;
    private album previous;

    private String artistName;
    private  String albumName;

    public album (album next, String artistName, String albumName) {
        this.next = next;
        this.artistName = artistName;
        this.albumName = albumName;
    }

    public void set(album newA) {
        this.setAlbumName(newA.albumName);
        this.setArtistName(newA.artistName);
    }

    public album getNext() {
        return next;
    }

    public void setNext(album next) {
        this.next = next;
    }

    public album getPrevious() {
        return previous;
    }

    public void setPrevious(album previous) {
        this.previous = previous;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void join (album data) {
        album current = this;

        while (current.getNext () != null) {
            current = current.getNext ();
        }

        current.setNext (new album (null, data.artistName, data.albumName));
    }

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

