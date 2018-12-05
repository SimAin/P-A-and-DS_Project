public class testAlbum {

    public static boolean errorTrigger = false;

    public static boolean checkStringValues(String data, String expected) {
        if(data.equals(expected)) {
            return false;
        } else {
            errorTrigger = true;
            System.out.println("expected: " + expected);
            System.out.println("actual: " + data);
            System.out.println(" ");
        }
        return true;
    }

    // Main method to run tests.
    public static void main (String[] args) {

        album album = mediaList.getMediaList();
        albums albumList = new albums();
        albumList.setHead(album);

        //Test get album and get artist
        checkStringValues(albumList.getHead().getArtistName(),"Against Me");
        checkStringValues(albumList.getHead().getAlbumName(),"White Crosses / Black Crosses");

        //Test get next via get album and get artist
        checkStringValues(albumList.getHead().getNext().getArtistName(),"Green Day");
        checkStringValues(albumList.getHead().getNext().getAlbumName(),"American Idiot");

        //using set head method
        albumList.setHead(albumList.getHead().getNext().getNext());

        //Testing set head was successful
        checkStringValues(albumList.getHead().getArtistName(),"Frank Turner");
        checkStringValues(albumList.getHead().getAlbumName(),"Positive Songs for Negative People");

        //using set previous method
        albumList.getHead().setPrevious(new album(albumList.getHead(),"testerName", "Sweet sounds"));

        //Testing set previous was successful via the get previous
        checkStringValues(albumList.getHead().getPrevious().getArtistName(),"testerName");
        checkStringValues(albumList.getHead().getPrevious().getAlbumName(),"Sweet sounds");

        //using set methods
        albumList.getHead().setArtistName("John");
        albumList.getHead().setAlbumName("My Album");//(albumList.getHead().getNext().getNext());

        //Testing set was successful
        checkStringValues(albumList.getHead().getArtistName(),"John");
        checkStringValues(albumList.getHead().getAlbumName(),"My Album");

        //using set methods
        albumList.getHead().set(new album(albumList.getHead().getNext(), "Rose", "By any other name"));

        //Testing set was successful
        checkStringValues(albumList.getHead().getArtistName(),"Rose");
        checkStringValues(albumList.getHead().getAlbumName(),"By any other name");

        if(!errorTrigger){
            System.out.println("Tests complete: All tests passed, No errors found");
        }
    }
}
