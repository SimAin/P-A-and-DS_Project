
public class mediaManager {

    public static void main (String[] args) {

        album album = mediaList.getMediaList();
        albums head = new albums();
        head.setHead(album);

        System.out.println(head.toString());
        System.out.println("Size: " + head.getSize());

        head.albumBubbleSort();

        System.out.println("Sorted array:  ");
        System.out.println(head.toString());
        System.out.println("Size: " + head.getSize());

        head.artistBubbleSort();

        System.out.println("Sorted array:  ");
        System.out.println(head.toString());
        System.out.println("Size: " + head.getSize());

        if(head.contains("The Razors Edge")){
            System.out.println("The Razors Edge was found in list");
        } else {
            System.out.println("The Razors Edge was NOT found in list");
        }

        if(head.contains("The Razor ")){
            System.out.println("The Razor was found in list");
        } else {
            System.out.println("The Razor was NOT found in list");
        }

        System.out.println("Size: " + head.getSize());
        System.out.println("Artist Count =    " + head.getArtistCount());

    }
}
