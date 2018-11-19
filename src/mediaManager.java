public class mediaManager {

    private static final String m_file = "C:/Users/srain/IdeaProjects/practicalCoursework_Problem_1/src/media_library.txt";

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

        /*Metallica,St Anger,Metal,11,
        Metallica,Some Kind Of Monster,Metal,11,
        Metallica,Death Magnetic,Metal,10,
        Metallica,Hardwired...To Self-Destruct,Metal,12,
        AC/DC,Highway to Hell,Heavy Metal,9,
        ACC/DC,For Those About to Rock (We Salute You),Metal,12,
        AC/DC,The Razors Edge,Metal,10,
        Iron Maiden,The Number Of The Beast, Heavy Rock,14,
        Iron Maiden,Somewhere In Time, Heavy Rock,15,
        The Gaslight Anthum, 59th Sound, Rock,10,
        The Gaslight Anthum, American Slang, Rock,11,
        Against Me,White Crosses / Black Crosses, Rock,10,
        Frank Turner,England keep my bones, Folk Rock, 11,
        Frank Turner,Positive Songs for Negative People, Folk Rock,12,
        Green Day,Anmerican Idoit, Punk Rock,9,*/

        return gdAm;
    }

    public static void main (String[] args) {
        album first = getMediaList();
        System.out.println(first.toString());
        System.out.println(first.find("59th Sound"));
    }
}
