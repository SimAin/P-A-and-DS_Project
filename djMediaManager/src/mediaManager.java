import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mediaManager {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main (String[] args) throws IOException {

/*        System.out.print("Please enter a height for your board: ");
        int height = Integer.parseInt(br.readLine());
        System.out.println(height);

        */

        boolean exit = false;


        album album = mediaList.getMediaList();
        albums head = new albums();
        head.setHead(album);
        System.out.println(head.toString());


        while (!exit) {
            System.out.println();
            System.out.println("The albums listed above have been imported");
            System.out.println("Please type 'album' to sort them by album or 'artist' to sort by artist:");
            System.out.println("To search please type 'search':");
            System.out.println("To count artists and albums please type 'count':");
            System.out.println("To add a new album please type 'add'");
            System.out.println("To delete an album please type 'delete'"); //TODO: add delete
            System.out.println("Please type 'exit' to end:");
            String input = (br.readLine());

            if(input.equals("album") || input.equals("album")) {
                head.albumBubbleSort();
                printing(head);

            } else if(input.equals("artist") || input.equals("Artist")) {
                head.artistBubbleSort();
                printing(head);

            } else if(input.equals("search") || input.equals("Search")) {
                searching(head);

            } else if(input.equals("count") || input.equals("Count")) {
                System.out.println("Album Count:  " + head.getSize());
                System.out.println("Artist Count:  " + head.getArtistCount());

            } else if(input.equals("add") || input.equals("Add")) {
                System.out.println("Please type new albums artist:");
                String new_artist = (br.readLine());
                System.out.println("Please type new album name:");
                String new_album_name = (br.readLine());

                album new_album = new album(null, new_artist, new_album_name );
                head.getHead().join(new_album);

            } else if(input.equals("exit")){


                exit = true;
            } else {
                System.out.println("Error please try again.");
            }
        }





    }

    public static void printing(albums head){
        System.out.println("Sorted array:  ");
        System.out.println(head.toString());
        System.out.println();
    }

    public static void searching(albums head) throws IOException {
        System.out.println("To search for an album please type 'album':");
        System.out.println("To search for an artist please type 'artist':");
        String search = (br.readLine());
        if(search.equals("album") || search.equals("album")){
            System.out.println("Type album to search for: :");
            String album_in = (br.readLine());
            boolean res = head.contains(album_in);
            if(res) {
                System.out.println("The album " + album_in + " was found in the collection.");
            } else if(!res) {
                System.out.println("The album " + album_in + " was NOT found in the collection.");
            }
        } else if(search.equals("artist") || search.equals("Artist")) {
            //TODO: artist contains

            head.contains("The Razors Edge");
        }
    }
}
