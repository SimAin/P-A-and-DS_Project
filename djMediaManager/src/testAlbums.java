public class testAlbums {

    public static boolean checkStringValues(String data, String expected) {
        if(data.equals(expected)) {
            return false;
        } else {
            System.out.println("expected: " + expected);
            System.out.println("actual: " + data);
            System.out.println(" ");
        }
        return true;
    }

    public static boolean checkIntValues(int data, int expected) {
        if(data == expected) {
            return false;
        } else {
            System.out.println("expected: " + expected);
            System.out.println("actual: " + data);

        }
        return true;
    }

    public static boolean checkBooleanValues(Boolean data) {
        if(data ) {
            return false;
        } else {
            System.out.println("expected: True" );
            System.out.println("actual: False" );

        }
        return true;
    }

    // Main method to run tests.
    public static void main (String[] args) {

        album album = mediaList.getMediaList();
        albums head = new albums();
        head.setHead(album);

        //Check start order is as expected
        //Enables better data for checking sorting output later
        checkStringValues(head.toString(),"\n{Against Me, White Crosses / Black Crosses}, \n" +
                                                    "{Green Day, American Idiot}, \n" +
                                                    "{Frank Turner, Positive Songs for Negative People}, \n" +
                                                    "{Frank Turner, England keep my bones}, \n" +
                                                    "{The Gaslight Anthem, American Slang}, \n" +
                                                    "{Iron Maiden, Somewhere In Time}, \n" +
                                                    "{Iron Maiden, The Number Of The Beast}, \n" +
                                                    "{AC/DC, The Razors Edge}, \n" +
                                                    "{AC/DC, Highway to Hell}, \n" +
                                                    "{AC/DC, For Those About to Rock (We Salute You)}, \n" +
                                                    "{Metallica, Hardwired}, \n" +
                                                    "{Metallica, Death Magnetic}, \n" +
                                                    "{Metallica, Some Kind Of Monster}, \n" +
                                                    "{Metallica, St Anger}, ");
        checkIntValues(head.getSize(),14);

        head.albumBubbleSort();

        //Check start order is as expected after album bubble sort
        //Enables better data for checking sorting output later
        checkStringValues(head.toString(),"\n{Green Day, American Idiot}, \n" +
                                                    "{The Gaslight Anthem, American Slang}, \n" +
                                                    "{Metallica, Death Magnetic}, \n" +
                                                    "{Frank Turner, England keep my bones}, \n" +
                                                    "{AC/DC, For Those About to Rock (We Salute You)}, \n" +
                                                    "{Metallica, Hardwired}, \n" +
                                                    "{AC/DC, Highway to Hell}, \n" +
                                                    "{Frank Turner, Positive Songs for Negative People}, \n" +
                                                    "{Metallica, Some Kind Of Monster}, \n" +
                                                    "{Iron Maiden, Somewhere In Time}, \n" +
                                                    "{Metallica, St Anger}, \n" +
                                                    "{Iron Maiden, The Number Of The Beast}, \n" +
                                                    "{AC/DC, The Razors Edge}, \n" +
                                                    "{Against Me, White Crosses / Black Crosses}, " );
        checkIntValues(head.getSize(),14);

        head.artistBubbleSort();

        //Check start order is as expected after album bubble sort
        //Enables better data for checking sorting output later
        checkStringValues(head.toString(),"\n{AC/DC, For Those About to Rock (We Salute You)}, \n" +
                                                    "{AC/DC, Highway to Hell}, \n" +
                                                    "{AC/DC, The Razors Edge}, \n" +
                                                    "{Against Me, White Crosses / Black Crosses}, \n" +
                                                    "{Frank Turner, England keep my bones}, \n" +
                                                    "{Frank Turner, Positive Songs for Negative People}, \n" +
                                                    "{Green Day, American Idiot}, \n" +
                                                    "{Iron Maiden, Somewhere In Time}, \n" +
                                                    "{Iron Maiden, The Number Of The Beast}, \n" +
                                                    "{Metallica, Death Magnetic}, \n" +
                                                    "{Metallica, Hardwired}, \n" +
                                                    "{Metallica, Some Kind Of Monster}, \n" +
                                                    "{Metallica, St Anger}, \n" +
                                                    "{The Gaslight Anthem, American Slang}, " );
        checkIntValues(head.getSize(),14);

        //Test positive searches
        checkBooleanValues(head.contains("The Razors Edge"));
        //TODO: Currently returning error
        //checkBooleanValues(head.contains("The Number Of The Beast"));
        //checkBooleanValues(head.contains("St Anger"));

        //Test negative searches
        checkBooleanValues(!head.contains("Razors"));
        checkBooleanValues(!head.contains(""));
        checkBooleanValues(!head.contains("123"));
    }
}
