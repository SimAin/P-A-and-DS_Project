public class album {
    private album next;
    //private album previous;

    private String artistName;
    private  String albumName;

    //public String genera;
    //public int numberOfTracks;

    public album (album next, String artistName, String albumName) {
        this.next = next;
        this.artistName = artistName;
        this.albumName = albumName;
    }

    //public album () {}

    public album getNext() {
        return next;
    }
    public void setNext(album next) {
        this.next = next;
    }

    /*public album getPrevious() {
        return previous;
    }
    public void setPrevious(album previous) {
        this.previous = previous;
    }*/

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

    public String toString() throws ArrayIndexOutOfBoundsException {
        String result = "[" + "{" + this.getArtistName() + ", " + this.getAlbumName() + "}, ";
        while (this.next != null) {
            result = result + "{" + this.next.getArtistName() + ", " + this.next.getAlbumName() + "}, ";
            this.next = this.next.getNext ();   // <3>
        }
        result = result + "]";
        return result;
    }

    public String findArtistFromAlbum (String searchkey) {
        System.out.println("0 " + albumName );
        if (this.getAlbumName().equals(searchkey)) {
            System.out.println("1");
            return this.artistName;
        }
        System.out.println(next.getAlbumName());
        if (next == null) {
            return null;
        } else {
            System.out.println("2");
            return next.findArtistFromAlbum(searchkey);
        }
    }
}

