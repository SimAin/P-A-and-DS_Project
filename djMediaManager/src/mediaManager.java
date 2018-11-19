public class mediaManager {

    public static album getMediaList() {
        album metSt = new album (null, "Metallica", "St Anger");
        album metSo = new album (metSt, "Metallica", "Some Kind Of Monster");
        album metD = new album (metSo, "Metallica", "Death Magnetic");
        album metH = new album (metD, "Metallica", "Hardwired");
        album acFor = new album (metH, "AC/DC", "For Those About to Rock (We Salute You)");
        album acH = new album (acFor, "AC/DC", "Highway to Hell");
        album actR = new album (acH, "AC/DC", "The Razors Edge");
        album imNum = new album (actR, "Iron Maiden", "The Number Of The Beast");
        album imSo = new album (imNum, "Iron Maiden", "Somewhere In Time");
        album gl59 = new album (imSo, "The Gaslight Anthem", "59th Sound");
        album glAM = new album (gl59, "The Gaslight Anthem", "American Slang");
        album amWc = new album (glAM, "Against Me", "White Crosses / Black Crosses");
        album ftEn = new album (amWc, "Frank Turner", "England keep my bones");
        album ftPs = new album (ftEn, "Frank Turner", "Positive Songs for Negative People");
        album gdAm = new album (ftPs, "Green Day", "American Idiot");

        return gdAm;
    }

    public static void main (String[] args) {
        album first = getMediaList();

        //TODO: fix toString to return start of list.
        //Currently leaves the array at the end so can not run the find.
        //System.out.println(first.toString());
        System.out.println("Search for album '59th Sound', returned artist: " + first.findArtistFromAlbum("59th Sound"));
    }
}
