public class mediaManager {

    public static album getMediaList() {
        album metSt = new album (null, "Metallica", "St Anger");   //BACK
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
        album gdAm = new album (ftPs, "Green Day", "American Idiot"); //FRONT

        metSt.setPrevious(metSo);
        metSo.setPrevious(metD);
        metD.setPrevious(metH);
        metH.setPrevious(acFor);
        acFor.setPrevious(acH);
        acH.setPrevious(actR);
        actR.setPrevious(imNum);
        imNum.setPrevious(imSo);
        imSo.setPrevious(gl59);
        gl59.setPrevious(glAM);
        glAM.setPrevious(amWc);
        amWc.setPrevious(ftEn);
        ftEn.setPrevious(ftPs);
        ftPs.setPrevious(gdAm);
        gdAm.setPrevious(null);

        return gdAm;
    }

    public static void main (String[] args) {

        album album = getMediaList();
        albums head = new albums();
        albums sort = new albums();
        head.setHead(album);

        System.out.println(head.toString());
        System.out.println(head.getSize());
        System.out.println("Search for album '59th Sound', returned artist: " + album.findArtistFromAlbum("59th Sound"));
        //System.out.println("Search for album '59th Sound', returned artist: " + head.contains("59th Sound"));
        System.out.println(head.getSize());

        //albums.insertionSort(sort);
    }
}
